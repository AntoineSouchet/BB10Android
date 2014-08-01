package fr.bb.android;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.bb.android.mysql.MysqlConnec;
import fr.bb.android.mysql.MysqlUser;
import fr.bb.android.pojos.Users;
import fr.bb.android.util.Mail;
import fr.bb.android.util.StringCorrection;

@Controller
public class UserController extends SuperController {
	
	
	@RequestMapping("GetUserInformation.sd")
	@ResponseBody
	public String GetUserInformation(int id)
	{
		logger.info("Recuperation des informations d'un utilisateur");
		MysqlUser mysql = context.getBean("",MysqlUser.class);
		Users u = mysql.getUser(id);
		String retour = "Login : " + u.getLogin() + "<br />Adresse mail : " + u.getEmail() + "<br />";
		return retour;
	}
	
	@RequestMapping("UpdateInformation.sd")
	@ResponseBody
	public int UpdateInformations(int id,String email,int age,int sexe)
	{
		logger.info("Mise à jour des informations d'un utilisateur");
		MysqlUser mysql = context.getBean("MysqlUser",MysqlUser.class);
		return mysql.UpdateUser(id, email, age, sexe);
	}

	@RequestMapping("zoomUsr.sd")
	@ResponseBody
	public String zoomUsr(int idUser)
	{
		logger.info("Zoom depuis la liste des app sur un utilisateur" + idUser);
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		int TotalApp = mysql.getAppUser(idUser);
		StringCorrection correction = new StringCorrection();
		SqlRowSet User = mysql.getUserInformation(idUser);
		String retour = "";
		String sexe = "";
		String grade = "Baby BB Lover <img src=\"resources/img/Stars.png\">";
		if (TotalApp >= 10 && TotalApp < 20)
		{grade = "Bon BB Lover <img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\">";}
		else if (TotalApp >= 20 && TotalApp < 30)
		{grade = "BB Lover <img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\">";}
		else if (TotalApp >= 30 && TotalApp < 40)
		{grade = "Super BB Lover <img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\">";}
		else if (TotalApp > 40)
		{grade = "Maitre BB Lover <img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\"><img src=\"resources/img/Stars.png\">";}
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
		logger.info("Creation d'un log sur le site avec envoit du mail de validation");
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
	
	@RequestMapping("MdpLost.sd")
	public ModelAndView MdpLost(HttpServletRequest request)
	{
		logger.info("Envoit vers la section mot de passe perdu");
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("RecupMDP");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("GeneratePass.sd")
	@ResponseBody
	public String GetMdp(String email) throws MessagingException, IOException
	{
		logger.info("Generation d'un nouveau mot de passe");
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		if (mysql.checkEmail(email) > 0)
		{
			mysql.generatePWD(email);	
			return "Un nouveau mot de passe vous a √©t√© envoy√© sur votre addresse : " + email;
		}
		else
		{
			return "Aucun compte sur BBLoveAndroid n'utilise l'addresse mail : " + email;
		}

	}
	
	@RequestMapping("NewLog.sd")
	public ModelAndView NewLog(HttpServletRequest request)
	{
		logger.info("Creation d'un nouveau login");
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("CreateLogin");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	
	@RequestMapping("Login.sd")
	@ResponseBody
	public String Login(String log,String pass,HttpServletRequest request)
	{
		logger.info("Login d'un user sur le site BBLoveAndroid " + log);
		//retour
		session = request.getSession(true);	
//		ModelAndView model = new ModelAndView("Logon");
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
			//retour = "<div class=\"alert alert-success\">Bienvenue " + u.getLogin() + " sur BB10LoveAndroid !</div>";
		 	retour = "ok";
		 	this.index(request);
		}
		else
		{
			retour = "<div class=\"alert alert-warning\">Mauvais login ou mot de passe</div>";
		}
		System.out.println(retour);
		return retour;
	}
	
	public ModelAndView index(HttpServletRequest request)
	{
		logger.info("Retour à la page principale du site");
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("index");
		model.addObject("getTopBar", getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
	 	model.addObject("TotalApp", mysql.getTotalApp());
		return model;
	}
	
	@RequestMapping("MyTopBar.bb")
	@ResponseBody
	public String MyTopBar()
	{
		String retour = "";
		if(session.getAttribute("Login").toString().contentEquals("") == true)
		{
			retour = "<a href=\"#PageLog\" class=\"page-scroll\" >Connexion</a>";
		   session.setAttribute("Login", "Invite");
	 	   session.setAttribute("Email", "Invite");
	 	   session.setAttribute("Sexe", "");
	 	   session.setAttribute("ip", ip);
	 	   session.setAttribute("id", 0);
	 	   return retour;
		}
		if (session.getAttribute("Login").toString().contentEquals("Invite") == true)
		{
			retour = "<a href=\"#myModal\"  data-toggle=\"modal\"  class=\"page-scroll\" >Connexion</a>";
		}
		else if(session.getAttribute("Login").toString().contentEquals("") == true)
		{
			retour = "<a href=\"#myModal\"  data-toggle=\"modal\" class=\"page-scroll\" >Connexion</a>";		
		}
		else
		{
			retour = "<div id=\"MonId\" name=\"MonId\" style=\"display:none\">" + session.getAttribute("id") + "</div>"
					+ "<input type=\"hidden\" name=MonId value=" + session.getAttribute("id") + ">"
//					+ "<a href=\"#Logout\" id=\"Logout\" class=\"page-scroll\" >Se déconnecter</a></li><li>  "
					//+ "<a href=\"#Logout\" id=\"Logout\" class=\"page-scroll\" ><img src=\"resources/img/Account.png\" ></a></li><li>  "
					+ "<a href=\"#ModalAddApp\" id=\"AddApp\"  data-toggle=\"modal\" class=\"page-scroll\" >Ajouter application</a>";		
		}
		return retour;
	}
}
