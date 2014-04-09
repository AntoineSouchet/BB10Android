package fr.bb.android.postgre;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class GetPostGre {
	
	
	private JdbcTemplate montemplate;
	private String sql;
	private String retour;
	
	public GetPostGre(DataSource ds)
	{
		this.montemplate = new JdbcTemplate(ds);
	}
	
	public String GetType()
	{
		sql = "Select * from Type";
		SqlRowSet Resultat = this.montemplate.queryForRowSet(sql);
		while (Resultat.next())
		{
			retour = "<option id=" + Resultat.getInt("id") + ">" + Resultat.getString("Description") + "</option>";
		}
		return retour;
	}

}
