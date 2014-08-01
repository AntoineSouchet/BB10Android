package fr.bb.android;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import fr.bb.android.mysql.MysqlConnec;
import fr.bb.android.pojos.Applications;
import fr.bb.android.util.GooglePlayAPI;

@Controller
public class ApplicationController extends SuperController {

	@RequestMapping("AddApp.sd")
	public ModelAndView AddApp(HttpServletRequest request)
	{
		logger.info("Debut d'ajout d'une application dans la base de données.");
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
	
	@RequestMapping("NewApp.sd")
	@ResponseBody
	public String NewwApp(HttpServletRequest request,String Name,String Description,String Editeur,String Google,int Type,int Fonctionne,int User)
	{
		logger.info("Ajout d'une nouvelle application dans la base de données par " + User);
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
			GooglePlayAPI googleAPI = new GooglePlayAPI();
			String id = googleAPI.getId(Name);
			String image = "";
			if (id.contentEquals("") == false)
			{
				image = googleAPI.getImage(id,Name);
			}
			Applications app = new Applications();
			app.setName(Name);
			app.setDescription(Description);
			app.setGooglePlay(Google);
			app.setEditeur(Editeur);
			app.setOk(Fonctionne);
			app.setType(Type);
			app.setUser(User);
			app.setImage(image);
			/*
			 * record database
			 */
			mysql.addApp(app);
			return "ok";
		}

	}
	

}
