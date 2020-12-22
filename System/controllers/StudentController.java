package controllers;

import java.io.IOException;

import data.*;
import exceptions.*;
import system.*;
import users.*;

public class StudentController {
	private Student student;
	
	public StudentController() {}
	
	public StudentController(Student student) {	this.student = student; }

	public Student getStudent() { return student; }
	
	public void studentMenu() throws IOException {
		try {
			menu : while(true) {
				System.out.println("Welcome to the WSP! \n");
				System.out.println("Choose the option: \n 1. View info about student \n 2. View current courses \n 3. Manage course \n 4. View transcript \n "
						+ "5. Register for course \n 6. Change password \n 7.exit");
				int option = Integer.parseInt(WSP.readFromConsole());
			    switch (option) {
			    case 1: {student.toString();break;}
			    case 2: {student.viewCurrentCourses();break;}
			    case 3: {manageCourse();break;}
			    case 4: {student.viewTranscript().print();break;}
			    case 5: {registerMenu();break;}
			    case 6: {UserOperation.changePassword(student);break;}
			    case 7: {
			    	System.out.println("Good bye!");
			    	WSP.serialize(WSP.getData(), "data.out");
			    	break menu;}}
			}
		}catch (Exception e) {
			System.out.println("Erroe detected... \n Saving resources...");
			e.printStackTrace();
			WSP.serialize(WSP.getData(), "data");
		}
	}
	
	public void manageCourse() throws IOException {
			System.out.println("Choose the number of course: ");
			int num = 1;
			for (Course c: student.viewCurrentCourses()) {
				System.out.println(num++ + " - " + c.getName());
			
			int chosenCourse  = Integer.parseInt(WSP.readFromConsole());
			Course course = student.viewCurrentCourses().get(chosenCourse - 1);
			while(true) {
				System.out.println("Choose operation: \n 1. View info about teacher \n 2. View marks of course \n 3.View files of course \n 4.Returns back");
				int option  = Integer.parseInt(WSP.readFromConsole());
				System.out.println("Course: " + course.getName());
				switch(option) {
				case 1: {student.infoAboutTeacher(course);break;}
				case 2: {System.out.println("\nMarks: " + student.viewMarks(course).toString());break;}
				case 3: {System.out.println("\nFiles: " + student.viewFilesOfCourse(course));break;}
				case 4: {this.manageCourse();break;}
			}}
		}
	}
	
	public void registerMenu() {
		
		System.out.println("Choose the number of course: ");
		int num = 1;
		for (Course c: student.getSpeciality().getSpecialityCourses()) {
			System.out.println(num++ + " - " + c.getName());
		}
		int option  = Integer.parseInt(WSP.readFromConsole());
		Course course = student.getSpeciality().getSpecialityCourses().get(option - 1);
		try {
			student.registerForCourse(course);
		} catch (ExcessOfCreditsException e) {
			e.printStackTrace();
		}
		System.out.println("Well done, dude");
	}
	
}

