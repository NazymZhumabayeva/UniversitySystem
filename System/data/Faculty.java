package data;

import java.io.Serializable;
import java.util.*;

public class Faculty implements Serializable{
	private String name;
	private ArrayList<Speciality> facultySpecialities;
	public Faculty() {}
	public Faculty(String name) {
		this.name = name;
		facultySpecialities = new ArrayList<Speciality>();}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public ArrayList<Speciality> getFacultySpecialities() {return facultySpecialities;}
	public void addSpeciality(Speciality speciality) { 
		this.facultySpecialities.add(speciality);}
	
	public int hashCode() {
		return Objects.hash(name, facultySpecialities);}

	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Faculty other = (Faculty) obj;
		if (!name.equals(other.name))return false;
		return true;}

	public String toString() {
		return "Faculty [name: " + this.getName() + "]";}
}

