package fr.bb.android;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.bb.android.mysql.MysqlConnec;
import fr.bb.android.pojos.Applications;
import fr.bb.android.pojos.Users;
import fr.bb.android.util.Mail;
import fr.bb.android.util.StringCorrection;

@Controller
public class HomeController {
	
	public static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
	public static HttpSession session;
	public String ip = "";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		session = request.getSession(true);

		String ipAddress  = request.getHeader("X-FORWARDED-FOR");  	
        if(ipAddress == null)  
        {  
          ipAddress = request.getRemoteAddr();  
        }  
       ip = getClientIpAddr(request);
	   session.setAttribute("Login", "Invite");
 	   session.setAttribute("Email", "Invite");
 	   session.setAttribute("Sexe", "");
 	   session.setAttribute("ip", ip);
 	   session.setAttribute("id", 0);
 	   model.addAttribute("getTopBar", getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
 	   model.addAttribute("TotalApp", mysql.getTotalApp());
	return "home";
	}

	@RequestMapping("Connexion.sd")
	public ModelAndView Connexion(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("Connexion");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("Tuto.sd")
	public ModelAndView Tuto(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("Tutorial");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("Propos.sd")
	public ModelAndView Propos(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("Propos");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("index.sd")
	public ModelAndView index(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("index");
		model.addObject("getTopBar", getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
	 	model.addObject("TotalApp", mysql.getTotalApp());
		return model;
	}
	
	@RequestMapping("NewLog.sd")
	public ModelAndView NewLog(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("CreateLogin");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("Login.sd")
	public ModelAndView Login(String log,String pass,HttpServletRequest request)
	{
		//retour
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("Logon");
		String retour = "<div class=\"alert alert-warning\">Login ou mot de passe incorrect.</div>";
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		System.out.println(mysql.CheckLog(log, pass));
		if (mysql.CheckLog(log, pass) == 2)
		{

			Users u = new Users();
			u = mysql.getInformation(log, pass);
			session.setAttribute("Login", u.getLogin());
		 	session.setAttribute("Email", u.getEmail());
		 	session.setAttribute("Sexe", u.getSexe());
		 	session.setAttribute("id", u.getId());
			retour = "<div class=\"alert alert-success\">Bienvenue " + u.getLogin() + " sur BB10LoveAndroid !</div>";
		 	this.index(request);
		}
		model.addObject("getTopBar", getTopBar());
		model.addObject("retour",retour);
		return model;
	}
	
	@RequestMapping("AddApp.sd")
	public ModelAndView AddApp(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("AjoutAPP");
		model.addObject("getTopBar",getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		SqlRowSet RowType = mysql.getAppType();
		String Type = "";
		while (RowType.next())
		{
			Type = Type + "<option id=" + RowType.getInt("id") + " value=" + RowType.getInt("id") + ">" + RowType.getString("Name") + "</option>";
		}
		model.addObject("Type",Type);
		return model;	
	}
	
//	var AppName = $("#Name").val();
//	var Description = $("#Description").val();
//	var Editeur = $("#Editeur").val();
//	var Google = $("#Google").val();
//	var Type = $("#Type").val();
//	var Fonctionne = $("#Fonctionne").val();
	@RequestMapping("NewApp.sd")
	@ResponseBody
	public String  NewwApp(HttpServletRequest request,String Name,String Description,String Editeur,String Google,int Type,int Fonctionne,int User)
	{
		session = request.getSession(true);	
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		boolean check = false;
		check = mysql.verifExist(Name);
		if (check == true)
		{
			return "X";
		}
		else
		{
			Applications app = new Applications();
			app.setName(Name);
			app.setDescription(Description);
			app.setGooglePlay(Google);
			app.setEditeur(Editeur);
			app.setOk(Fonctionne);
			app.setType(Type);
			app.setUser(User);
			//record database
			mysql.addApp(app);
			return "ok";
		}

	}
	
	@RequestMapping("AppList.sd")
	public ModelAndView GetApp(HttpServletRequest request)
	{
		session = request.getSession(true);
		ModelAndView model = new ModelAndView("AppList");
		model.addObject("getTopBar",getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		StringCorrection correction = new StringCorrection();
		SqlRowSet RowApp = mysql.getAllApplications();
		String Liste = "";
		while (RowApp.next())
		{
			String stat = "";
			
			if (RowApp.getInt("OK") == 1)
			{
				stat = "<font color=\"green\">Compatible</font>";
				Liste = Liste + 
						"<tr class=\"success\">"
						+ "<td><b>" + RowApp.getString("Name") + "</b></td>"
						+ "<td>" + RowApp.getString("Editeur") + "</td>"
						+ "<td>" + RowApp.getString("Type") + "</td>"
						+ "<td><b>" + stat + "</b></td>"
						+ "<td><a href=\"" + RowApp.getString("GooglePlay") + "\" target=\"_blank\"><img src=\"resources/img/GooglePlay.png\"></a></td>"
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("UserId") + "\"><a href=\"#myModal2\" data-toggle=\"modal\" class=\"usr-zommApp\" >" + correction.Majuscule(RowApp.getString("login")) + "</a></td>" 
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("id") + "\"><a href=\"#myModal\" data-toggle=\"modal\" class=\"btn-zoomApp\"><img src=\"resources/img/Info.png\"></a></td></tr>";
			}
			else
			{
				stat = "<font color=\"red\">Incompatible</font>";
				Liste = Liste + 
						"<tr class=\"warning\">"
						+ "<td><b>" + RowApp.getString("Name") + "</b></td>"
						+ "<td>" + RowApp.getString("Editeur") + "</td>"
						+ "<td>" + RowApp.getString("Type") + "</td>"
						+ "<td><b>" + stat + "</b></td>"
						+ "<td><a href=\"" + RowApp.getString("GooglePlay") + "\" target=\"_blank\"><img src=\"resources/img/GooglePlay.png\"></a></td>"
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("UserId") + "\"><a href=\"#myModal2\" data-toggle=\"modal\" class=\"usr-zommApp\" >" + correction.Majuscule(RowApp.getString("login")) + "</a></td>" 
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("id") + "\"><a href=\"#myModal\" data-toggle=\"modal\" class=\"btn-zoomApp\"><img src=\"resources/img/Info.png\"></a></td></tr>";
			}
	}
		model.addObject("ListeApp",Liste);
		return model;
	}
	
	
	@RequestMapping("Seek.sd")
	public ModelAndView Seek(HttpServletRequest request,String AppName)
	{
		session = request.getSession(true);
		ModelAndView model = new ModelAndView("AppList");
		model.addObject("getTopBar",getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		StringCorrection correction = new StringCorrection();
		SqlRowSet RowApp = mysql.getSeekApp(AppName);
		String Liste = "";
		int verification = 0;
		while (RowApp.next())
		{
			verification = 1;
			String stat = "";
			
			if (RowApp.getInt("OK") == 1)
			{
				stat = "<font color=\"green\">Compatible</font>";
				Liste = Liste + 
						"<tr class=\"success\">"
						+ "<td><b>" + RowApp.getString("Name") + "</b></td>"
						+ "<td>" + RowApp.getString("Editeur") + "</td>"
						+ "<td>" + RowApp.getString("Type") + "</td>"
						+ "<td><b>" + stat + "</b></td>"
						+ "<td><a href=\"" + RowApp.getString("GooglePlay") + "\" target=\"_blank\"><img src=\"resources/img/GooglePlay.png\"></a></td>"
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("UserId") + "\"><a href=\"#myModal2\" data-toggle=\"modal\" class=\"usr-zommApp\" >" + correction.Majuscule(RowApp.getString("login")) + "</a></td>" 
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("id") + "\"><a href=\"#myModal\" data-toggle=\"modal\" class=\"btn-zoomApp\"><img src=\"resources/img/Info.png\"></a></td></tr>";
			}
			else
			{
				stat = "<font color=\"red\">Incompatible</font>";
				Liste = Liste + 
						"<tr class=\"warning\">"
						+ "<td><b>" + RowApp.getString("Name") + "</b></td>"
						+ "<td>" + RowApp.getString("Editeur") + "</td>"
						+ "<td>" + RowApp.getString("Type") + "</td>"
						+ "<td><b>" + stat + "</b></td>"
						+ "<td><a href=\"" + RowApp.getString("GooglePlay") + "\" target=\"_blank\"><img src=\"resources/img/GooglePlay.png\"></a></td>"
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("UserId") + "\"><a href=\"#myModal2\" data-toggle=\"modal\" class=\"usr-zommApp\" >" + correction.Majuscule(RowApp.getString("login")) + "</a></td>" 
						+ "<td><input type=\"Hidden\" id=idApp name=idApp value=\""+ RowApp.getInt("id") + "\"><a href=\"#myModal\" data-toggle=\"modal\" class=\"btn-zoomApp\"><img src=\"resources/img/Info.png\"></a></td></tr>";
			}
		}
		if (verification == 0)
		{
			Liste = "<tr class=\"danger\">"
					+ "<td><b>Aucun résultat pour :  " + AppName + "</b></td>"
					+ "<td></td>"
					+ "<td></td>"
					+ "<td></td>"
					+ "<td></a></td>"
					+ "<td></td>" 
					+ "<td></td></tr>";

		}
			model.addObject("ListeApp",Liste);
			return model;
	}
	
	@RequestMapping("ZoomApp.sd")
	@ResponseBody
	public String zoomapp(int idApp)
	{
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		Applications app = mysql.getApplication(idApp);
		String retour = "";
		String titre = "";
		retour = "<b>Titre : </b>" + app.getName() + "<br />"
				+ "<b>Description : </b>" + app.getDescription() + "<br />"
						+ "<b>Lien GooglePlay : </b><a href=" + app.getGooglePlay() + ">ici</a><br />"
								+ "<b>Editeur : </b>" + app.getEditeur();
		titre = app.getName();
		return titre + "/////"+ retour;
	}
	
	@RequestMapping("zoomUsr.sd")
	@ResponseBody
	public String zoomUsr(int idUser)
	{
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		int TotalApp = mysql.getAppUser(idUser);
		StringCorrection correction = new StringCorrection();
		SqlRowSet User = mysql.getUserInformation(idUser);
		String retour = "";
		String sexe = "";
		String grade = "Baby BB Lover";
		if (TotalApp >= 10 && TotalApp < 20)
		{grade = "Bon BB Lover";}
		else if (TotalApp >= 20 && TotalApp < 30)
		{grade = "BB Lover";}
		else if (TotalApp >= 30 && TotalApp < 40)
		{grade = "Super BB Lover";}
		else if (TotalApp > 40)
		{grade = "Enorme BB Lover";}
		while (User.next())
		{
			if (User.getInt("sexe") == 1)
			{
				sexe = "Homme";
			}
			else
			{
				sexe = "Femme";
			}
			retour = correction.Majuscule(User.getString("login")) + "/////" + sexe + "/////" + TotalApp + "/////" + grade;
			
			
		}
		return retour;
	}
	
	
	@RequestMapping("CreateLog.sd")
	@ResponseBody	
	public String createLog(String login,String password,String sexe,String email,HttpServletRequest request) throws NoSuchProviderException, MessagingException, IOException
	{
		session = request.getSession(true);	
		int monsexe = Integer.parseInt(sexe);
		Users u = new Users(0,login, password, email, 0, monsexe, 0);
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		int retour = mysql.CreateLogin(u);
		System.out.println(retour);
		if (retour != 0)
		{
			Mail mail = new Mail();
			mail.connect("auth.smtp.1and1.fr", "contacts@bbloveandroid.com", "Kikoo2031");
			
			mail.send("contacts@bbloveandroid.com", email, "Validez votre compte BBLoveAndroid !", "<html><head>"
					+ "<link rel=\"stylesheet\" href=\"http://37.187.47.201:8080/BB10Android/resources/bootstrap-3.1.1/css/bootstrap.min.css\" type=\"text/css\" />"
					+ "<link rel=\"stylesheet\" href=\"http://37.187.47.201:8080/BB10Android/resources/bootstrap-3.1.1/css/bootstrap-theme.min.css\" type=\"text/css\" />"
					+ "<style type=\"text/css\">a:link{text-decoration:none}</style>"
					+ "</head>"
					+ "<body style=background-color:#295e92;color:white;a:link{text-decoration:none}>"
					+ "<center><img src=\"http://37.187.47.201:8090/BB10Android/resources/img/MyBBLOVE.png\"></center><br />"
					+ "Bonjour " + login + ", vous venez de cr&eacute;er un compte sur BBLoveAndroid.<br />"
					+ "Afin de valider votre compter merci de cliquez sur le lien ci-dessous.<br />"
					+ "<center><a href=http://37.187.47.201:8090/BB10Android/ValidCompte.sd?id="+ retour+"&user=" +login + " style=a:link{text-decoration:none}>"
					+ "Valider mon compte</a></center><br/><br />"
					+ "Ceci est un mail automatique merci de ne pas y r&eacutepondre.</div>", "");
			return "X";
			
		}
		else
		{
			return "0";
		}
	}
	
	public  String getClientIpAddr(HttpServletRequest request) {  
		session = request.getSession(true);	
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
//        System.out.println(ip);
        return ip;  
    }  

	public boolean islog()
	{
		if (session.getAttribute("login").toString().contentEquals("Invite") == true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		
	@RequestMapping("ValidCompte.sd")
	@ResponseBody
	public String ValidEmail(int id,String user)
	{
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		
		boolean retour = mysql.validMail(id,user);
		if (retour == true)
		{
			return "<center><b>Merci d'avoir créer votre compte sur BB10LoveAndroid, vous pouvez dés à présent vous connecter au site</b><br />"
					+ "www.BBLoveAndroid.com";
		}
		else
		{
			return "Il semblerai que votre compte ou l'url saisie ne soit pas valide";
		}
	}
	
	@RequestMapping("Lougout.sd")
	public ModelAndView logout(HttpServletRequest request)
	{
		session = request.getSession(true);	
		session.removeAttribute("Login");
		session.setAttribute("Login", "Invite");
		ModelAndView model = new ModelAndView("index");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	public String getTopBar()
	{
		String retour = "";
		if (session.getAttribute("Login").toString().contentEquals("Invite") == true)
		{
			retour = "<a href=\"#PageLog\" class=\"PageLog btn btn-primary\">Connexion</a>";
		}
		else if(session.getAttribute("Login").toString().contentEquals("") == true)
		{
			retour = "<a href=\"#PageLog\" class=\"PageLog btn btn-primary\">Connexion</a>";		
		}
		else
		{
			retour = "<div id=\"MonId\" name=\"MonId\" style=\"display:none\">" + session.getAttribute("id") + "</div>"
					+ "<input type=\"hidden\" name=MonId value=" + session.getAttribute("id") + ">"
					+ "<a href=\"#Logout\" id=\"Logout\" class=\"Logout\"><img src=\"resources/img/Account.png\" ></a>  "
					+ "<a href=\"#AddApp\" id=\"AddApp\" class=\"AddApp btn btn-success\">Ajouter application</a>";		
		}
		return retour;
	}
}
