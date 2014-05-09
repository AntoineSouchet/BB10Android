package fr.bb.android.mysql;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import fr.bb.android.pojos.Applications;
import fr.bb.android.pojos.Users;

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
	
	public void addApp(Applications applications)
	{
		
	}
	
	public Applications getApp(int id)
	{
		Applications app = new Applications();
		return app;
	}
		
	public SqlRowSet Rechercher(String recherche)
	{
		sql = "";
		return this.montemplate.queryForRowSet(sql,recherche);
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
		this.montemplate.update(sql,u.getLogin(),u.getPassword(),u.getEmail(),u.getAge(),u.getSexe(),u.getValide());
		
		String sqlid = "Select id from Users where login = ? and pass=? and email=?";
		return this.montemplate.queryForInt(sqlid,u.getLogin(),u.getPassword(),u.getEmail());
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
		}
		return app;
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
		String sql = "Select app.id,app.Name,Description,Editeur,GooglePlay,T.Name as 'Type',u.login,OK from Applications as app "
					+ " inner join Type as T on app.Type = T.id "
					+ " inner join Users as U on app.User = U.id";
		return this.montemplate.queryForRowSet(sql);
	}
}
