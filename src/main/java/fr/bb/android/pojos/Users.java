package fr.bb.android.pojos;

public class Users {
	
	private String login;
	private String password;
	private String email;
	private int age;
	
	public Users()
	{
		super();
	}
	public Users(String login, String password, String email, int age,
			int sexe, int valide) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.age = age;
		this.sexe = sexe;
		this.valide = valide;
	}
	private int sexe;
	private int valide;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public int getValide() {
		return valide;
	}
	public void setValide(int valide) {
		this.valide = valide;
	}

}
