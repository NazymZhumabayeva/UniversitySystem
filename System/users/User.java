package users;

import java.io.Serializable;

public abstract class User implements Serializable, java.lang.Comparable<User> {
    private String firstName;
    private String secondName;
    private int id;
    private String password;
    
    public User() {}
    public User(String secondName, String firstName, int id) {
    	this.secondName = secondName;
    	this.firstName = firstName;
    	this.id = id;
    	this.password = "kbtu0000";}
  
    public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getSecondName() {return secondName;}
	public void setSecondName(String secondName) {this.secondName = secondName;}
	
	public int getId() {return id;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
    @Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (id != other.id) return false;
		return true;}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;}
 
    public int compareTo(User u) {
    	if(this.id<u.id) return -1;
	    else if(u.id<this.id) return 1;
	    return 0;}
    @Override
	public String toString() {
		return "User [firstName=" + firstName + ", secondName=" + secondName + ", id=" + id + ", password=" + password+ "]";}
    
	public abstract void updateInfo();
	public abstract void userController();
}

