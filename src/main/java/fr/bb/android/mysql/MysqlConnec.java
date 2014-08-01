package fr.bb.android.mysql;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import fr.bb.android.pojos.Applications;
import fr.bb.android.pojos.Users;
import fr.bb.android.util.Mail;

public class MysqlConnec {
	
	private JdbcTemplate montemplate;
	private String retour;
	private String sql;

	public MysqlConnec(DataSource ds)
	{
		this.montemplate = new JdbcTemplate(ds);
	}
	
	public String getType()
	{
		return retour;
	}
	

	public void addApp(Applications app)
	{		
		String sql = "insert into Applications (Name,Description,Editeur,GooglePlay,Type,User,Ok,Image) values (?,?,?,?,?,?,?,?);";
		if (CheckInjection(sql) == false) {
		this.montemplate.update(sql,app.getName(),app.getDescription(),app.getEditeur(),app.getGooglePlay(),app.getType(),app.getUser(),app.getOk(),app.getImage()); }
	}
	
	public Applications getApp(int id)
	{
		Applications app = new Applications();
		return app;
	}
		
	
	public int CreateLogin(Users u)
	{
		int retour = 1;
		sql = "Select count(*) from Users where login = ?";
		retour = this.montemplate.queryForInt(sql,u.getPassword());
		if (retour > 0)
		{
			return 0;
		}
		sql = "Select count(*) from Users where email = ?";
		retour = this.montemplate.queryForInt(sql,u.getEmail());
		if (retour > 0)
		{
			return 0;
		}
		sql = "insert into Users (login,pass,email,age,sexe,valide) values (?,?,?,?,?,?)";
		if (CheckInjection(sql) == false){
		this.montemplate.update(sql,u.getLogin(),u.getPassword(),u.getEmail(),u.getAge(),u.getSexe(),u.getValide());}
		
		String sqlid = "Select id from Users where login = ? and pass=? and email=?";
		return this.montemplate.queryForInt(sqlid,u.getLogin(),u.getPassword(),u.getEmail());
	}
	
	public int checkEmail(String mail)
	{
		String sql = "Select COUNT(*) from User where email = ?";
		return this.montemplate.queryForInt(sql,mail);
	}
	public String generatePWD(String mail) throws MessagingException, IOException
	{
		String sql = "update User set pass = ? where email = ?";
		SecureRandom random = new SecureRandom();
		String NewPwd = new BigInteger(130, random).toString(32);
		NewPwd = NewPwd.substring(1, 9);
		this.montemplate.update(sql,NewPwd,mail);
		Mail MonMail = new Mail();
		MonMail.connect("auth.smtp.1and1.fr", "contacts@bbloveandroid.com", "Kikoo2031");
		
		MonMail.send("contacts@bbloveandroid.com", mail, "BBLoveAndroid recréationd de votre Mot de passe", "<html><head>"
				+ "<link rel=\"stylesheet\" href=\"http://37.187.47.201:8080/BB10Android/resources/bootstrap-3.1.1/css/bootstrap.min.css\" type=\"text/css\" />"
				+ "<link rel=\"stylesheet\" href=\"http://37.187.47.201:8080/BB10Android/resources/bootstrap-3.1.1/css/bootstrap-theme.min.css\" type=\"text/css\" />"
				+ "<style type=\"text/css\">a:link{text-decoration:none}</style>"
				+ "</head>"
				+ "<body style=background-color:#295e92;color:white;a:link{text-decoration:none}>"
				+ "<center><img src=\"http://37.187.47.201:8090/BB10Android/resources/img/MyBBLOVE.png\"></center><br />"
				+ "Bonjour vous avez une demande de réinitialisation de votre mot de passe sur BBLoveAndroid"
				+ "Votre nouveau mot de passe est : " + NewPwd + ".<br />"
				+ "A bientot sur le site !</div>", "");
		return "ok";
	}
	
	public boolean validMail(int id,String user)
	{
		String sql = "update Users set valide = 1 where id = ? and login = ?";
		int retour = this.montemplate.update(sql,id,user);
		if (retour == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public int CheckLog(String log,String pass)
	{
		//System.out.println(this.montemplate.queryForInt("Select COUNT(*) from Users where (login=? OR email=?) and pass = ?",log,log,pass));
		if (this.montemplate.queryForInt("Select COUNT(*) from Users where (login=? OR email=?) and pass= ? and valide = 0",log,log,pass) == 1)
		{
			return 1;
		}
		else if (this.montemplate.queryForInt("Select COUNT(*) from Users where (login=? OR email=?) and pass= ? and valide = 1",log,log,pass) == 1)
		{
			return 2;
		}
		else 
		{
			return 0;
		}
			
	}
	
	public Users getInformation(String login,String pass)
	{
		Users u = new Users();
		sql = "Select * from Users where (login=? OR email=?) and pass=?";
		SqlRowSet R = this.montemplate.queryForRowSet(sql,login,login,pass);
		while (R.next())
		{
			u.setId(R.getInt("id"));
			u.setAge(R.getInt("age"));
			u.setEmail(R.getString("email"));
			u.setLogin(R.getString("login"));
			u.setSexe(R.getInt("sexe"));
			u.setValide(R.getInt("valide"));
		}
		
		return u;
	}
	
	public Applications getApplication(int id)
	{
		Applications app = new Applications();
		String sql = "Select * from Applications where id = ?";
		SqlRowSet R = this.montemplate.queryForRowSet(sql,id);
		while (R.next())
		{
			app.setId(R.getInt("id"));
			app.setName(R.getString("Name"));
			app.setDescription(R.getString("Description"));
			app.setEditeur(R.getString("Editeur"));
			app.setGooglePlay(R.getString("GooglePlay"));
			app.setType(R.getInt("Type"));
			app.setUser(R.getInt("User"));
			app.setOk(R.getInt("Ok"));
			app.setImage(R.getString("Image"));
		}
		return app;
	}
	
	public boolean verifExist(String name)
	{
		String sql = "Select COUNT(*) from Applications where Name = ?";
		if (this.montemplate.queryForInt(sql,name) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int insertAPP(String Name,String Description,String Editeur,String GooglePlay,int Type,int User,int Ok)
	{
		String sql = "insert into Applications (Name,Description,Editeur,GooglePlay,Type,User,Ok) values (?,?,?,?,?,?,?)";
		return this.montemplate.update(sql,Name,Description,Editeur,GooglePlay,Type,User,Ok);
	}

	public SqlRowSet getAppType()
	{
		String sql = "Select * from Type";
		return this.montemplate.queryForRowSet(sql);
	}
	
	public SqlRowSet getAllApplications()
	{
		String sql = "Select app.id,app.Name,Description,Image,Editeur,GooglePlay,T.Name as 'Type',U.login,OK,U.id as 'UserId' from Applications as app "
					+ " inner join Type as T on app.Type = T.id "
					+ " inner join Users as U on app.User = U.id order by app.id desc";
		return this.montemplate.queryForRowSet(sql);
	}
	
	public SqlRowSet getSeekApp(String appname)
	{		String sql = "Select app.id,app.Name,Description,Image,Editeur,GooglePlay,T.Name as 'Type',U.login,OK,U.id as 'UserId' from Applications as app "
			+ " inner join Type as T on app.Type = T.id "
			+ " inner join Users as U on app.User = U.id where app.Name like '%" + appname + "%'";
			return this.montemplate.queryForRowSet(sql);
		
	}
	
	public int getTotalApp()
	{
		String sql = "Select COUNT(*) from Applications";
		return this.montemplate.queryForInt(sql);
	}
	
	public int getTotalUser()
	{
		String sql = "Select COUNT(*) from Users";
		return this.montemplate.queryForInt(sql);
	}
	
	
	public int getAppUser(int id)
	{
		String sql = "Select COUNT(*) from Applications where User = ?";
		return this.montemplate.queryForInt(sql,id);
	}
	
	public SqlRowSet getUserInformation(int id)
	{
		String sql = "Select * from Users where id = ?";
		return this.montemplate.queryForRowSet(sql,id);
	}
	
	
	public boolean CheckInjection(String sql)
	{
		int position = 0;
		position=sql.indexOf("DELETE"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("UPDATE"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("TRUNCATE"); 
		if (position != -1) {
			return true;  
		}
		position=sql.indexOf("DROP"); 
		if (position != -1) {
			return true;   
		}
		position=sql.indexOf("ALTER"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("delete"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("update"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("truncate"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("drop"); 
		if (position != -1) {
			return true; 
		}
		position=sql.indexOf("alter"); 
		if (position != -1) {
			return true;   
		}
		return false;
	}
}
