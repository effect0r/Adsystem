package Adsystem;

public class User {
	//1 = adsystant, 2 = expert, 3 = manager
	private String name;
	private int level;
	
	public User() {
		this(null,0);
	}
	public User(String name) {
		this.name = name;
		this.level = 0;
	}
	public User(String name, int level) {
		this.name = name;
		this.level=level;
	}
	public boolean equals(User u) {
		if (this.name.compareTo(u.getName()) == 0){
		 	return true;
		}
		return false;
	}
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	public String toString() {
		return this.name + " " + this.level;
	}
}
