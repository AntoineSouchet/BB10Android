package fr.bb.android;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.bb.android.postgre.GetPostGre;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//GetPostGre postgre = context.getBean("GetPostGre",GetPostGre.class);
		//System.out.println(postgre.GetType());
		return "home";
	}
	
	@RequestMapping("AddApp.sd")
	public ModelAndView AddApplication()
	{
		ModelAndView model = new ModelAndView("AjoutAPP");
//		GetPostGre postgre = context.getBean("GetPostGre",GetPostGre.class);
//		model.addObject("MesType", postgre.GetType());
		return model;
	}
	
	@RequestMapping("Connexion.sd")
	public ModelAndView Connexion()
	{
		ModelAndView model = new ModelAndView("Connexion");
		return model;
	}
	
	@RequestMapping("Tuto.sd")
	public ModelAndView Tuto()
	{
		ModelAndView model = new ModelAndView("Tutorial");
		return model;
	}
	
	@RequestMapping("Propos.sd")
	public ModelAndView Propos()
	{
		ModelAndView model = new ModelAndView("Propos");
		return model;
	}
	
}
