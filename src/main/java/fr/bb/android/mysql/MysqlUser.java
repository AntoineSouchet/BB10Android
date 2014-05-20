package fr.bb.android.mysql;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import fr.bb.android.pojos.Users;

public class MysqlUser {
	
	private JdbcTemplate montemplate;
	
	
	public MysqlUser(DataSource ds)
	{
		this.montemplate = new JdbcTemplate(ds);
	}
	
	
	public Users getUser(int id)
	{
		String sql = "Select id,login,pass,email,age,sexe,valide from Users where id = ?";
		SqlRowSet R = this.montemplate.queryForRowSet(sql,id);
		Users u = new Users();
		while (R.next())
		{
			u.setId(R.getInt("id"));
			u.setAge(R.getInt("age"));
			u.setEmail(R.getString("email"));
			u.setSexe(R.getInt("sexe"));
		}
		return u;
	}
	
	public int UpdateUser(int id,String email,int age,int sexe)
	{
		String sql = "update User set email = ? AND age = ? AND sexe = ? where id = ?";
		return this.montemplate.update(sql,email,age,sexe,id);
	}
	
	public int updatePassword(int id,String pass)
	{
		String sql = "Update User set pass = ? where id = ?";
		return this.montemplate.update(sql,pass,id);
	}

}
