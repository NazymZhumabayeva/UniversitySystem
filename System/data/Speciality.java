package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Speciality implements Serializable {
    private String name; 
    private ArrayList<Course> specialityCourses;
    
    public Speciality() {} 
    public Speciality(String name) {
    	this.name = name;
    	specialityCourses = new ArrayList<Course>();}
    
    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

	public ArrayList<Course> getSpecialityCourses() {return specialityCourses;}

    public String viewSpecialityCourses() { 
    	int i = 0;
    	for(Course c: this.specialityCourses) return i++ + c.getName(); 
    	return "End.";}

    public boolean addToSpecialityCourses(Course course) {
    	return this.specialityCourses.add(course);}

	public String toString() {
    	return "Speciality name: " + this.getName();}
	
	public int hashCode() {
		return Objects.hash(name, specialityCourses);}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Speciality other = (Speciality) obj;
		if (name == null) {
			if (other.name != null)return false;
		} else if (!name.equals(other.name))return false;
		return true;}
	
	public int compareTo(Object o) {
		Speciality s = (Speciality)o;
		return name.compareTo(s.name);}
}

