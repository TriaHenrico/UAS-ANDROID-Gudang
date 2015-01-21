package databasehelper;

public class User {
	int userid; 
	String username, password;
	
	public User(){}
	
	public User(int id, String uname, String pass){
		this.userid = id;
		this.username = uname;
		this.password = pass;
	}
	
	public User(String uname, String pass){
		this.username = uname;
		this.password = pass;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
