package controllers;
import java.io.*;
import users.*;
import system.*;
import data.*;
public class TeacherController  {
	private Teacher teacher;
	public TeacherController() {}
	public TeacherController(Teacher teacher) {
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void teacherMenu() throws IOException  {
	   try {
		menu: while(true) {
			System.out.println("Welcome to the WSP! \n");
			System.out.println("Choose the option \n 1. View courses \n 2. Put marks \n 3. Add or delete file of the course \n "
					+ "4. Register for course \n 5. Messages \n 6. Send order to TechSupportGuy \n 7. Change password \n 8. Exit");
			int option = Integer.parseInt(WSP.readFromConsole());
			switch (option) {
			case 1: teacher.getCourses();
			case 2: this.putMark();
			case 3: this.workWithCourseFiles();
			case 4: this.registerForCourse();
			case 5: {
				DataOperation dataOperation = new DataOperation();
				dataOperation.messageMenu(teacher);}
			case 6: this.sendOrder();
			case 7: UserOperation.changePassword(teacher);}
	   }
	   }catch (Exception e) {
			System.out.println("Erroe detected... \n Saving resources...");
			e.printStackTrace();
			WSP.serialize(WSP.getData(), "data");
		}
	}
	public void putMark() {
		while(true) {
			System.out.println("Choose the number of course");
			int num = 1;
			for (Course c: teacher.getCourses()) 
				System.out.println(num++ + " " + c.getName());
			int option = Integer.parseInt(WSP.readFromConsole());
			Course course = teacher.getCourses().get(option - 1);
			System.out.println("Enter the Student id:");
			int id = Integer.parseInt(WSP.readFromConsole());
			Student studentMark = null;
			for (Student s:course.getStudentsOfCourse()) {
				if (s.getId() == id) {
					studentMark = s;
					break;}
			}
			System.out.println("Enter 1 for first attestation \n Enter 2 for second attestaion \n Enter 3 for final scores");
			int att = Integer.parseInt(WSP.readFromConsole());
			System.out.println("Enter the score:");
			double score = Double.parseDouble(WSP.readFromConsole());
			teacher.putMark(course, studentMark, att, score);
		}
	}
	public void workWithCourseFiles() {
		System.out.println("Enter 1 for add file of course \n Enter 2 for delete file of the course");
		int option = Integer.parseInt(WSP.readFromConsole());
		System.out.println("Choose the number of course");
		int num = 1;
		for (Course c: teacher.getCourses()) 
			System.out.println(num++ + " " + c.getName());
		option = Integer.parseInt(WSP.readFromConsole());
		Course course = teacher.getCourses().get(option - 1);
		System.out.println("Write the name of file with extension");
		String fileName = WSP.readFromConsole();
		File file = new File(fileName);
		if (option == 1) 
			teacher.addCourseFile(course, file);
		if (option == 2)
			teacher.deleteCourseFile(course, file);
	}
	public void registerForCourse() {
		System.out.println("Enter the name of Course:");
		String courseName = WSP.readFromConsole();
		Course course = null;
		for (Course c: WSP.getData().getCourses()) {
			if (c.getName().equals(courseName)) {
				course = c;
				break;}
			else
				System.out.println("Entered course name does not exist!");
		}
		if (teacher.addCourse(course))
			System.out.println("Course successfully registered.");
		else
			System.out.println("This course already registered");
	}
	public void sendOrder() {
    	DataOperation dataOperations = new DataOperation();
    	Order order = dataOperations.createOrder(teacher);
    	WSP.getData().getOrders().add(order);
    	if (teacher.sendOrder(order))
    		System.out.println("Order is sent.");
    	else 
    		System.out.println("Failed to send order");
    }
	
	
	
	
}
