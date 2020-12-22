package data;

import java.io.*;
import java.util.*;

import users.*;

public class Course implements Serializable{
    private String name;
    private String code;
    private int numberOfCredits;
    private Course prerequisite;
    private Teacher teacher;
    private ArrayList<File> files;
    private ArrayList<Student> studentsOfCourse;
    
    public Course() {}
    public Course(String name, String code, int numOfCredits) {
    	this.name = name;
    	this.code = code;
    	this.numberOfCredits = numOfCredits;
    	files = new ArrayList <File>();
    	studentsOfCourse = new ArrayList<Student>();
    }
    public Course(String name, String code, int numOfCredits, Course prerequisite) {
    	this.name = name;
    	this.code = code;
    	this.numberOfCredits = numOfCredits;
    	this.prerequisite = prerequisite;
    	files = new ArrayList <File>();
    	studentsOfCourse = new ArrayList<Student>();
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

	public int getNumberOfCredits() {return numberOfCredits;}
	public void setNumberOfCredits(int numberOfCredits) {this.numberOfCredits = numberOfCredits;}

	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}

	public Course getPrerequisite() {return prerequisite;}
	public void setPrerequisite(Course prerequisite) {this.prerequisite = prerequisite;}

	public Teacher getTeacher() {return teacher;}
	public void setTeacher(Teacher teacher) {this.teacher = teacher;}

	public ArrayList<File> getFiles() {return files;}

	public ArrayList<Student> getStudentsOfCourse() {return studentsOfCourse;}

    public void addFile(File file) {
    	this.files.add(file);}

    public void remove(File file) {
    	this.files.remove(file);}

    public void addStudentToCourse(Student student) {
    	this.studentsOfCourse.add(student);}
    
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Course other = (Course) obj;
		if (code == null) {
			if (other.code != null)return false;
		} else if (!code.equals(other.code))return false;
		return true;
	}
	public String  printName() {
		return this.name + " " + "credit number:" + this.numberOfCredits ;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", numberOfCredits=" + numberOfCredits + ", code=" + code + ", prerequisite="
				+ prerequisite + ", teacher=" + teacher + "]";
	}
	
    
}

