package fr.bb.android.pojos;

public class Type {
	
	
	private int id;
	private String Name;
	
	public Type()
	{
		super();
	}
	
	public Type(int id,String name)
	{
		setId(id);
		setName(name);
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
	

}
