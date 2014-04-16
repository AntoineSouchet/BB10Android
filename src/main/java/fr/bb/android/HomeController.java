package fr.bb.android;

import java.util.Locale;

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

/**
 * Handles requests for the application home page.
 */
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
 	   model.addAttribute("getTopBar", getTopBar());
	return "home";
	}
	
	@RequestMapping("AddApp.sd")
	public ModelAndView AddApplication(HttpServletRequest request)
	{
		session = request.getSession(true);	
		ModelAndView model = new ModelAndView("AjoutAPP");
		model.addObject("getTopBar", getTopBar());
		return model;
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
	
	@RequestMapping("CreateLog.sd")
	@ResponseBody
	public String createLog(String login,String password,String sexe,String email,HttpServletRequest request)
	{
		session = request.getSession(true);	
		int monsexe = Integer.parseInt(sexe);
		Users u = new Users(login, password, email, 0, monsexe, 0);
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		int retour = mysql.CreateLogin(u);
		if (retour == 0)
		{
			return "X";
			//TODO envoit du mail pour valider le compte.
		}
		else
		{
			return "0";
		}
	}
	
	@RequestMapping("Login.sd")
	@ResponseBody
	public String Login(String log,String pass,HttpServletRequest request)
	{
		session = request.getSession(true);	
		String retour = "KO";
		MysqlConnec mysql = context.getBean("MysqlConnec",MysqlConnec.class);
		System.out.println(mysql.CheckLog(log, pass));
		if (mysql.CheckLog(log, pass) == 2)
		{
			retour = "OK";
			Users u = new Users();
			u = mysql.getInformation(log, pass);
			session.setAttribute("Login", u.getLogin());
		 	session.setAttribute("Email", u.getEmail());
		 	session.setAttribute("Sexe", u.getSexe());
		 	this.index(request);
		}
		return retour;
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
	
	public String getTopBar()
	{
		String retour = "";
		if (session.getAttribute("Login") != "Invite")
		{
			retour = "Login " + session.getAttribute("Login").toString() + "  <a href=\"#AddApp\" id=\"AddApp\" class=\"AddApp btn btn-success\">Ajouter application</a>";
		}
		else
		{
			retour = "<a href=\"#PageLog\" class=\"PageLog btn btn-primary\">Connexion</a>";
					
		}
		return retour;
	}
}
