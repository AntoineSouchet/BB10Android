package fr.bb.android;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuperController {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
	public static HttpSession session;
	public String ip = "";
	public static final Logger logger = Logger.getLogger(SuperController.class);
	
	
	public String getTopBar()
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
			retour = "<a href=\"#myModal\"  data-toggle=\"modal\" class=\"page-scroll\">Connexion</a>";
		}
		else if(session.getAttribute("Login").toString().contentEquals("") == true)
		{
			retour = "<a href=\"#myModal\"  data-toggle=\"modal\" class=\"page-scroll\">Connexion</a>";		
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
