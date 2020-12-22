package system;
import java.io.Serializable;
import java.util.*;
import users.*;
import data.*;

public final class Data implements Serializable {
    private ArrayList<User> users;
    private ArrayList<Employee>employees;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<ORManager> managers;
    private ArrayList<TechSupportGuy> techSupportGuys;
    private ArrayList<Admin> admins;
    private ArrayList<Faculty> faculties;
    private ArrayList<Speciality> specialities;
    private ArrayList<Course> courses;
    private ArrayList<Message> messages;
    private ArrayList<Order> orders;
    private static final Data INSTANCE = new Data();
    private Data() {
    	users = new ArrayList<User>();
    	employees = new ArrayList<Employee>();
    	students = new ArrayList<Student>();
    	teachers = new ArrayList<Teacher>();
    	managers = new ArrayList<ORManager>();
    	techSupportGuys = new ArrayList<TechSupportGuy>();
    	admins = new ArrayList<Admin>();
    	faculties = new ArrayList<Faculty>();
    	specialities = new ArrayList<Speciality>();
    	courses = new ArrayList<Course>();
    	messages = new ArrayList<Message>();
    	orders = new ArrayList<Order>();
    }
    
    public static Data getInstance() {
        return INSTANCE;}

	public ArrayList<User> getUsers() {return users;}
	
	public ArrayList<Employee> getEmployees() {return employees;}

	public ArrayList<Student> getStudents() {return students;}

	public ArrayList<Teacher> getTeachers() {return teachers;}

	public ArrayList<ORManager> getManagers() {return managers;}

	public ArrayList<TechSupportGuy> getTechSupportGuys() {return techSupportGuys;}
	
	public ArrayList<Admin> getAdmins(){return admins;}

	public ArrayList<Faculty> getFaculties() {return faculties;}
	
	public ArrayList<Speciality> getSpecialities() {return specialities;}

	public ArrayList<Course> getCourses() {return courses;}

	public ArrayList<Message> getMessages() {return messages;}

	public ArrayList<Order> getOrders() {return orders;}
	
}

