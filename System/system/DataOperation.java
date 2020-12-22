package system;
import users.*;

import java.util.ArrayList;

import data.*;

public class DataOperation {
	private String header;
	private String body;
	private String secondName;
	private String firstName;
	private Employee employee = null;
	private Message message = null;
	
	public DataOperation () {}
	public static Faculty createFaculty() {
		System.out.println("Enter name of new Faculty");
		String name = WSP.readFromConsole();
		return new Faculty(name);
	}
	public static void updateFaculty() {
		System.out.println("Enter name of Faculty that should be changed");
		String facultyName = WSP.readFromConsole();
		Faculty faculty = null;
		for (Faculty f: WSP.getData().getFaculties()) {
			if(f.getName().equals(facultyName)) {
				faculty = f ;
				break;}
			else
				System.out.println("Faculty with this name is not found");
		}
		System.out.println("Print new name");
		String a = WSP.readFromConsole();
		faculty.setName(a);
	}
	public static Speciality createSpeciality() {
		System.out.println("Enter name of new Speciality");
		String name = WSP.readFromConsole();
		return new Speciality(name);
	}
	public static void updateSpeciality() {
		System.out.println("Enter name of Speciality that should be changed");
		String specialityName = WSP.readFromConsole();
		Speciality speciality = null;
		for (Speciality s: WSP.getData().getSpecialities()) {
			if(s.getName().equals(specialityName)) {
				speciality = s ;
				break;}	
			else
				System.out.println("Speciality with this name");
		}
		System.out.println("Print new name");
		String a = WSP.readFromConsole();
		speciality.setName(a);
	
	}
	public static Course createCourse() {
		System.out.println("Enter name of Course");
		String name = WSP.readFromConsole();
		System.out.println("Enter code of Course");
		String code = WSP.readFromConsole();
		System.out.println("Enter number of Credits");
    	int numOfCredits = Integer.parseInt(WSP.readFromConsole());
    	System.out.println("Does the course have prerequisite? \n 1. Enter 1 if YES \n 2. Enter 2 if NO");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	Course course = null;
    	if (option == 2) 
    		course = new Course(name, code,numOfCredits);
    	if (option == 1) {
    		String prereq = WSP.readFromConsole();
        	for (Course c: WSP.getData().getCourses()) {
        	    if (c.getName().equals(prereq))
        	    	course = new Course(name, code, numOfCredits, c);}
    	}
    	return course;	
	}
	public static void updateCourse() {
		System.out.println("Enter name of Course that should be changed");
		String courseName = WSP.readFromConsole();
		Course course = null;
		for (Course c: WSP.getData().getCourses()) {
			if(c.getName().equals(courseName)) {
				course = c ;
				break;
			}	
		}
		System.out.println("Choose what do you want to change /n 1.Name /n 2.Course /n 3.Credits");
		int option = Integer.parseInt(WSP.readFromConsole());
        if(option==1) {
		System.out.println("Enter new name of Course");
		String name = WSP.readFromConsole();
		course.setName(name);
        }
        if(option==2) {
		System.out.println("Enter new code of Course");
		String code = WSP.readFromConsole();
		course.setCode(code);
        }
		if(option==3) {System.out.println("Enter new number of Credits");
    	int numOfCredits = Integer.parseInt(WSP.readFromConsole());
    	course.setNumberOfCredits(numOfCredits);
		}
	}
	public void enterMessageOrOrderInfo() {
		System.out.println("Write header of Message");
		this.header = WSP.readFromConsole();
		System.out.println("Write body of Message");
		this.body = WSP.readFromConsole();
	}
	public Message createMessage(Employee sender) {
		enterMessageOrOrderInfo();
		return new Message(sender, header, body);	
	}
	public Order createOrder(Employee sender) {
		enterMessageOrOrderInfo();
		return new Order(sender, header, body);
	}
	public void printMessage(ArrayList<Message>messages) {
		int num = 1;
		for (Message m : messages)
			System.out.println(num++ + m.printHeader());
		System.out.println("Choose the number of message to open");
		int choice = Integer.parseInt(WSP.readFromConsole());
		this.message = messages.get(choice - 1);
		System.out.println(message);
	}
	public void messageMenu(Employee sender) {
		System.out.println("Choose the option: \n 1. Send Message \n 2. Unread messages \n 3.Read messages \n "
				+ "4. Find messages of given Employee");
		int option = Integer.parseInt(WSP.readFromConsole());
		if (option == 1) 
			sendMessage(sender);
		if (option == 2) {
			this.printMessage(sender.getUnreadMessages());
			sender.readMessage(message);}
		if (option == 3) 
			this.printMessage(sender.getReadMessages());
		if (option == 4) 
			this.findMessages(sender);
	}
	public void enterEmployeeInfo() {
		System.out.println("Write second name of Receiver");
		this. secondName = WSP.readFromConsole();
		System.out.println("Write first name of Receiver");
		this. firstName = WSP.readFromConsole();
		for (Employee e : WSP.getData().getEmployees()) {
			if (e.getFirstName().equals(firstName) && e.getSecondName().equals(secondName)) {
				this.employee = e;
				break;}
			else
				System.out.println("Receiver is not found!");
		}
	}
	public void sendMessage(Employee sender) {
		enterEmployeeInfo();
		Message message = this.createMessage(sender);
		WSP.getData().getMessages().add(message);
		if (sender.sendMessage(message, employee))
			System.out.println("Message is sent.");
		else
			System.out.println("Failed to sent message.");
	}
	public void findMessages(Employee sender) {
		enterEmployeeInfo();
		this.printMessage(sender.findMessages(employee));
	}
	
}
