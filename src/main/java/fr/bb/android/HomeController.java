package fr.bb.android;


import java.util.Locale; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.bb.android.mysql.MysqlConnec;
import fr.bb.android.util.StringCorrection;

@Controller
public class HomeController extends SuperController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Arrivé d'une nouvelle session sur le site");
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
 	   if (session.getAttribute("Login") == "")
 	   {
 		   session.invalidate();
 	   }
 	   model.addAttribute("ListeApp", getApplication());
 	   
 	 // MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		SqlRowSet RowType = mysql.getAppType();
		String Type = "";
		while (RowType.next())
		{
			Type = Type + "<option id=" + RowType.getInt("id") + " value=" + RowType.getInt("id") + ">" + RowType.getString("Name") + "</option>";
		}
		model.addAttribute("Type",Type);
	return "home";
	}

	@RequestMapping("Connexion.sd")
	public ModelAndView Connexion(HttpServletRequest request)
	{
		logger.info("Debut de connexion d'un utilisateur");
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("Connexion");
		model.addObject("getTopBar", getTopBar());
		return model;
	}

	public String getClientIpAddr(HttpServletRequest request) {  
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
		logger.info("Validation d'un compte pour le site");
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		
		boolean retour = mysql.validMail(id,user);
		if (retour == true)
		{
			return "<center><b>Merci d'avoir créer votre compte sur BBLoveAndroid, vous pouvez dés à présent vous connecter au site</b><br />"
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
		logger.debug("Deconexion d'une session");
		session = request.getSession(true);	
		session.removeAttribute("Login");
		session.setAttribute("Login", "Invite");
		ModelAndView model = new ModelAndView("index");
		model.addObject("getTopBar", getTopBar());
		return model;
	}
	
	@RequestMapping("RefreshApp.sd")
	@ResponseBody
	public String RefreshApp()
	{
		return getApplication();
	}
	
	public String getApplication()
	{
		logger.info("Recupération de la liste des applications");
		ModelAndView model = new ModelAndView("AppList");
		model.addObject("getTopBar",getTopBar());
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		StringCorrection correction = new StringCorrection();
		SqlRowSet RowApp = mysql.getAllApplications();
		String Liste = "";
		int i = 0;
		while (RowApp.next())
		{

			String image = RowApp.getString("Image");
			if (image.contentEquals("") == true)
			{
				image = "<img src=\"http://37.187.47.201/img/Default.png\" height=\"100px\" width=\"100px\">";
			}
			else
			{
				image = "<img src=\"http://37.187.47.201/img/" + image + "\" height=\"100px\" width=\"100px\">";
			}
			if (RowApp.getInt("OK") == 1)
			{
				Liste = Liste +   "<div class=\"panel panel-success\">"
				+ "<div class=\"panel-heading\">"
				+ "<h4 class=\"panel-title\">"
				+ "<a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse" + i + "\">"
				+ correction.Majuscule(RowApp.getString("Name")) + "<span class=\"glyphicon glyphicon-plus-sign\" style=\"float:right\"></span>"
			      + "  </a>"
			     + " </h4>"
			    + "</div>"
			    + "<div id=\"collapse" + i + "\" class=\"panel-collapse collapse\">"
			    + "<div class=\"panel-body\" style=\"color:black;\">"
			    + image + " Posté par : " +  RowApp.getString("login") + "<br /> Description : " + RowApp.getString("Description")
			    + " </div>"
			   + " </div>"
			 + " </div>";
			}
			else
			{
				Liste = Liste +   "<div class=\"panel panel-danger\">"
				+ "<div class=\"panel-heading\">"
				+ "<h4 class=\"panel-title\">"
				+ "<a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse" + i + "\">"
				+ RowApp.getString("Name") + "<span class=\"glyphicon glyphicon-plus-sign\" style=\"float:right\"></span>"
			      + "  </a>"
			     + " </h4>"
			    + "</div>"
			    + "<div id=\"collapse" + i + "\" class=\"panel-collapse collapse\">"
			    + "<div class=\"panel-body\" style=\"color:black;\">"
			    + image + " Posté par : " +  correction.Majuscule(RowApp.getString("login")) + "<br /> Description : " + RowApp.getString("Description")
			    + " </div>"
			   + " </div>"
			 + " </div>";
			
			}
			i = i + 1;
	}
		return Liste;
		
	}
		
}
