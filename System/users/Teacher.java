package users;

import java.io.*;
import java.util.*;
import data.*;
import system.*;
import controllers.*;
import enumerations.TeacherTitle;

public class Teacher extends Employee {
    private TeacherTitle title;
    private ArrayList<Course> teacherCourses;
    
    public Teacher() {}
    public Teacher(String secondName, String firstName, int id) {
		super(secondName, firstName, id);
		}
    public Teacher(String secondName, String firstName, int id, double salary, TeacherTitle title) {
		super(secondName, firstName, id, salary);
		this.title = title;}
    
    public TeacherTitle getTitle() {return title;}
    public void setTitle(TeacherTitle title) {this.title = title;}

    public ArrayList<Course> getCourses() {return teacherCourses;}
    
    public boolean addCourse(Course course) {
    	course.setTeacher(this);
    	return teacherCourses.add(course);
    	}

    public void addCourseFile(Course course, File file) {
    	course.addFile(file);}
  
    public void deleteCourseFile(Course course, File file) {
    	course.remove(file);}

    public void putMark(Course course, Student student,  int att, double score) {
    	Attestation a = null;
    	for(HashMap.Entry<Course,Attestation> entry : student.viewTranscript().getJournal().entrySet()) {
    		if (entry.getKey().equals(course)) 
    			a = entry.getValue();
    	}
    	if (att == 1) 
    		a.addScoresToFirstAtt(score);
    	if (att == 2) 
    		a.addScoresToSecondtAtt(score);
    	if (att == 3)    
    		a.setFinalScore(score);}

    public boolean sendOrder(Order order) {
    	return TechSupportGuy.addNewOrder(order);}

    @Override
	public String toString() {
		return super.toString() + "\n" + "Teacher [title=" + title + "]";
	}
	public void updateInfo() {
    	UserOperation.updateTeacherInfo(this);}
	public void userController() {
		TeacherController teacherController = new TeacherController(this);
		try {
			teacherController.teacherMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

