package fr.bb.android.pojos;

public class Applications {
	
	private int id;
	private String Name;
	private String Description;
	private String GooglePlay;
	private int type;
	
	public Applications(){	
		super();
	}

	public Applications(int id, String name, String description,
			String googlePlay, int type) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		GooglePlay = googlePlay;
		this.type = type;
	}


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
	public String getGooglePlay() {
		return GooglePlay;
	}
	public void setGooglePlay(String googlePlay) {
		GooglePlay = googlePlay;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
