package controllers;

import java.io.IOException;
import java.util.Collections;
import users.*;
import system.*;
import comparators.*;
import data.*;

public class ORManagerController {
	private ORManager orManager;
	public ORManagerController() {};
	public ORManagerController(ORManager orManager) {
		this.orManager=orManager;
	}
	public ORManager getORManager() {
		return orManager;
	}
	public void ORManagerMenu() throws IOException {
		try {
			System.out.println("Welcome to the WSP! \n");
			menu : while(true) {
				System.out.println("Choose the option \n 1.Info about ORManager \n 2.Create data \n 3. Update data \n 4. Info about student's \n 5. Info about teachers \n "
						+ " 6. Messages \n 7. Send order to TechSupportGuy \n 8. Add Courses For Register  \n 9. Change password \n 10. Exit");
				int option = Integer.parseInt(WSP.readFromConsole());
				switch (option) {
				case 1: {orManager.toString();break;}
				case 2: {this.createData();break;}
				case 3: {this.updateData();break;}
				case 4: {this.infoAboutStudent();break;}
				case 5: {this.infoAboutTeacher();break;}
				case 6: {
					DataOperation dataOperation = new DataOperation();
					dataOperation.messageMenu(orManager);break;}
				case 7: {this.sendOrder();break;}
				case 8: {this.AddCoursesForRegister();break;}
				case 9: {UserOperation.changePassword(orManager);}
				case 10: {System.out.println("Good bye!");
		    	WSP.serialize(WSP.getData(), "data.out");
		    	break menu;}
				}
			}
		}catch (Exception e) {
				System.out.println("Erroe detected... \n Saving resources...");
				e.printStackTrace();
				WSP.serialize(WSP.getData(), "data");
			}
	}
	public void createData() throws IOException {
		while(true) {
			System.out.print("Choose the option \n 1.Create Course \n 2. Create Speciality \n 3.Create Faculty \n 4. Returns back\n");
			int option = Integer.parseInt(WSP.readFromConsole());
			if (option == 1) {
			
    		WSP.getData().getCourses().add(DataOperation.createCourse());
    		break;
			}
			if (option == 2) {
				Speciality speciality = DataOperation.createSpeciality(); 
				WSP.getData().getSpecialities().add(speciality);
				break;
		}
		if (option == 3) {
    		Faculty faculty = DataOperation.createFaculty();
    		WSP.getData().getFaculties().add(faculty);break;
    	}
		if (option == 4) {
			this.ORManagerMenu();
		}
		
		System.out.println("Set number of credits:");
		int a = Integer.parseInt(WSP.readFromConsole());
		Student.setLimitOfCredits(a);
	}
	}
    public void updateData() throws IOException {
    	while(true) { 
    	System.out.print("Choose the option \n 1.Update Course \n 2.Update Speciality \n 3.Update Faculty \n 4. Returns back\n");
		int option = Integer.parseInt(WSP.readFromConsole());
		if (option == 1) {
			DataOperation.updateCourse();break;
    	}
		if (option == 2) {
			DataOperation.updateSpeciality();
			break;
    	}
		if (option == 3) {
			DataOperation.updateFaculty();
			break;
    	}
		if (option == 4) {
			this.ORManagerMenu();
		}
    	}
    }
	public void infoAboutTeacher() {
		
    	Collections.sort(orManager.infoTeachers());
    		for(Student s:orManager.infoStudents()) 
    			System.out.print(s);
	}
		
	public void infoAboutStudent() throws IOException {
		while(true) {
			System.out.print("Choose the option \n 1.Sort students info with gpa \n 2. Sort students info with id \n 3.Returns back \n");
			int option = Integer.parseInt(WSP.readFromConsole());
			if (option == 1) {
	    		Collections.sort(orManager.infoStudents(),new GpaComparator());
	    		for(Student s:orManager.infoStudents()) 
	    			System.out.print(s);
	    		break;
	    	}
			if (option == 2) {
	    		Collections.sort(orManager.infoStudents());
	    		for(Student s:orManager.infoStudents()) 
	    			System.out.print(s);
	    		break;
			}
			if (option == 3) {
				this.ORManagerMenu();
			}
		    }

	}
    public void sendOrder() {
    	DataOperation dataOperations = new DataOperation();
    	Order order = dataOperations.createOrder(orManager);
    	WSP.getData().getOrders().add(order);
    	orManager.sendOrder(order);
    }
    public void AddCoursesForRegister() throws IOException { 
    while(true) {
    	System.out.println("Choose the option: \n 1. Create a new course \n 2. Choose an existing course \n 3. Returns back");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	System.out.println("Write the name of Speciality to add this Course");
		String specialityName = WSP.readFromConsole();
		Speciality speciality = null;
		for (Speciality s: WSP.getData().getSpecialities()) {
			if (s.getName().equals(specialityName)) {
				speciality = s;
				break;}
			else
				System.out.println("Entered speciality name is wrong!");
		}
    	if (option == 1) {
    		Course newCourse = this.orManager.createNewCourse();
    		if (WSP.getData().getCourses().add(newCourse))
	    		if (this.orManager.addCoursesForRegister(newCourse, speciality))
	    			System.out.println("Course successfully added.");
				else
					System.out.println("Course was already added.");
    		else
    			System.out.println("Course is already existing.");
    	}
    	if (option == 2) {
    		System.out.println("Write the name of Course");
    		String courseName = WSP.readFromConsole();
    		Course course = null;
    		for (Course c : WSP.getData().getCourses()) {
    			if (c.getName().equals(courseName)) {
    				course = c;
    				break;
    				}
    			else
    				System.out.println("Entered course name is wrong!");
    		}
    		if (this.orManager.addCoursesForRegister(course, speciality)) 
				System.out.println("Course successfully added.");
			else
				System.out.println("Course was already added.");
    	}
    	if(option == 3) {
    		this.ORManagerMenu();
    	}
    }
    }
    
}
