package fr.bb.android;

import java.io.IOException;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.bb.android.mysql.MysqlConnec;
import fr.bb.android.pojos.Users;
import fr.bb.android.util.Mail;

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
		return model;
		
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
//					+ "<div style=width:100%;height:100%;background-color:#295e92;color:white;font-family: \"trebuchet ms\", sans-serif;>"
					//37.187.47.201:8080/BB10Android/
					+ "<center><img src=\"http://37.187.47.201:8090/BB10Android/resources/img/MyBBLOVE.png\"></center><br />"
					+ "Bonjour " + login + ", vous venez de cr&eacute;er un compte sur BBLoveAndroid.<br />"
					+ "Afin de valider votre compter merci de cliquez sur le lien ci-dessous.<br />"
					+ "<center><a href=http://37.187.47.201:8090/BB10Android/ValidCompte.sd?id="+ retour+"&user=" +login + " style=a:link{text-decoration:none}>"
					+ "Valider mon compte</a></center><br/><br />"
					+ "Ceci est un mail automatique merci de ne pas y r&eacutepondre.</div>", "");
			//TODO envoit du mail pour valider le compte.
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
	
	public String getTopBar()
	{
		String retour = "";
		if (session.getAttribute("Login") != "Invite")
		{
			retour = "<div id=\"MonId\" name=\"MonId\" style=\"display:none\">" + session.getAttribute("id") + "</div>"
					+ "<img src=\"resources/img/Roundicons-36.png\" > "
					+ "<a href=\"#AddApp\" id=\"AddApp\" class=\"AddApp btn btn-success\">Ajouter application</a>";
		}
		else
		{
			retour = "<a href=\"#PageLog\" class=\"PageLog btn btn-primary\">Connexion</a>";
					
		}
		return retour;
	}
}
