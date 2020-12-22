package users;
import java.io.IOException;
import java.util.*;

import controllers.*;
import system.*;
import data.*;
public class ORManager extends Employee{
	public ORManager() {}
	public ORManager( String secondName, String firstName, int id) {
		super(firstName, secondName, id);
	}
    public ORManager( String secondName, String firstName, int id, double salary) {
		super(firstName, secondName, id, salary);
	}
    
    public ArrayList<Student> infoStudents() {
        return WSP.getData().getStudents();}

    public ArrayList<Teacher> infoTeachers() {
    	return WSP.getData().getTeachers();}

    public boolean sendOrder(Order order) {
    	return TechSupportGuy.addNewOrder(order);
    }
    public void updateInfo() {
    	UserOperation.updateORManagerInfo(this);
    }
    public boolean addCoursesForRegister(Course course, Speciality speciality) { 
    	return speciality.addToSpecialityCourses(course);
    }
    public void userController() {
		ORManagerController orManagerController = new ORManagerController();
		try {
			orManagerController.ORManagerMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Course createNewCourse() {
    	return DataOperation.createCourse();
    }

}

