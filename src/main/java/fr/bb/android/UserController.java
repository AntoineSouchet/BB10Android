package fr.bb.android;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.bb.android.mysql.MysqlUser;
import fr.bb.android.pojos.Users;

@Controller
public class UserController extends HomeController {
	
	
	@RequestMapping("GetUserInformation.sd")
	@ResponseBody
	public String GetUserInformation(int id)
	{
		MysqlUser mysql = context.getBean("",MysqlUser.class);
		Users u = mysql.getUser(id);
		String retour = "Login : " + u.getLogin() + "<br />Adresse mail : " + u.getEmail() + "<br />";
		return retour;
	}
	
	@RequestMapping("UpdateInformation.sd")
	@ResponseBody
	public int UpdateInformations(int id,String email,int age,int sexe)
	{
		MysqlUser mysql = context.getBean("MysqlUser",MysqlUser.class);
		return mysql.UpdateUser(id, email, age, sexe);
	}

}
