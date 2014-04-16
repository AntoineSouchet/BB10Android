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
		int retour = 0;
		sql = "Select count(*) from Users where login = ?";
		retour = this.montemplate.queryForInt(sql,u.getPassword());
		if (retour > 0)
		{
			return 1;
		}
		sql = "Select count(*) from Users where email = ?";
		retour = this.montemplate.queryForInt(sql,u.getEmail());
		if (retour > 0)
		{
			return 1;
		}
		sql = "insert into Users (login,pass,email,age,sexe,valide) values (?,?,?,?,?,?)";
		this.montemplate.update(sql,u.getLogin(),u.getPassword(),u.getEmail(),u.getAge(),u.getSexe(),u.getValide());
		return 0;
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
			u.setAge(R.getInt("age"));
			u.setEmail(R.getString("email"));
			u.setLogin(R.getString("login"));
			u.setSexe(R.getInt("sexe"));
			u.setValide(R.getInt("valide"));
		}
		
		return u;
	}
}
