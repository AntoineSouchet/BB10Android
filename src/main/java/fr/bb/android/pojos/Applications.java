package fr.bb.android.pojos;

public class Applications {
	
	private int id;
	private String Name;
	private String Description;
	private String Editeur;
	private String GooglePlay;
	private int Type;
	private int User;
	private int Ok;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEditeur() {
		return Editeur;
	}
	public void setEditeur(String editeur) {
		Editeur = editeur;
	}
	public String getGooglePlay() {
		return GooglePlay;
	}
	public void setGooglePlay(String googlePlay) {
		GooglePlay = googlePlay;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getUser() {
		return User;
	}
	public void setUser(int user) {
		User = user;
	}
	public int getOk() {
		return Ok;
	}
	public void setOk(int ok) {
		Ok = ok;
	}

}
