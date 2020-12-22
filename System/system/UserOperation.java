package system;

import enumerations.*;
import users.*;
import data.*;

public class UserOperation {
	//-------User--------
	private String firstName;
	private String secondName;
	private int id;
	//-----Employee-------
	private double salary;
	//-----Teacher--------
	private TeacherTitle title;
	//-----Student--------
	private Degree degree;
	private Faculty faculty;
	private int yearOfStudy;
	private Speciality speciality;
    public UserOperation() {}
    public void optionsForUserCreation() {
    	System.out.println("1. Create Student \n 2. Create Teacher \n 3. Create ORManager \n 4. Create TechSupportguy"
    			+ "\n 5. Create Admin");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: createStudent();
    	case 2: createTeacher();
    	case 3: createORManager();
    	case 4: createTechSupportGuy();
    	case 5: createAdmin();
    	}
    }
    public void enterUserInfo() {
    	System.out.println("Enter second name");
    	this.secondName = WSP.readFromConsole();
    	System.out.println("Enter first name");
    	this.firstName = WSP.readFromConsole();
    	System.out.println("Enter id");
    	this.id = Integer.parseInt(WSP.readFromConsole());
    }
    public void enterStudentInfo() {
        enterUserInfo();
        System.out.println("Enter speciality: ");
        String speciality = WSP.readFromConsole();
        for (Speciality s: WSP.getData().getSpecialities())
        	if (s.getName().equals(speciality))
        		this.speciality = s;
        	else System.out.println("Incorrect name of speciality.");
        
        System.out.println("Enter faculty: ");
        String faculty = WSP.readFromConsole();
        for (Faculty f: WSP.getData().getFaculties())
        	if (f.getName().equals(faculty))
        		this.faculty = f; 
        	else System.out.println("Incorrect name of faculty.");
        
        System.out.println("Enter year of study: ");
        int year = Integer.parseInt(WSP.readFromConsole());
        this.yearOfStudy = year;
    }
    public void enterEmployeeInfo() {
    	enterUserInfo();
    	System.out.println("Enter salary");
    	this.salary = Double.parseDouble(WSP.readFromConsole());
    }
    public void selectStudentDegree() {
    	System.out.println("Select degree of student: ");
    	System.out.println("\n 1. Bachelor \n 2. Master \n 3. Doctor");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: this.degree = Degree.BACHELOR;
    	case 2: this.degree = Degree.MASTER;
    	case 3: this.degree = Degree.DOCTOR;
    	}
    }
    public void selectTeacherTitle() {
    	System.out.println("Select title of teacher");
    	System.out.println("1. TUTOR \n 2. LECTOR \n 3. SENIOR_LECTOR \n 4. PROFESSOR");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch (option) {
    	case 1: this.title = TeacherTitle.TUTOR;
    	case 2: this.title = TeacherTitle.LECTOR;
    	case 3: this.title = TeacherTitle.SENIOR_LECTOR;
    	case 4: this.title = TeacherTitle.PROFESSOR;		
    	}
    }
    public Student createStudent() {
    	enterStudentInfo();
    	selectStudentDegree();
    	return new Student(this.secondName, this.firstName, this.id,
			this.degree, this.faculty, this.yearOfStudy, this.speciality);
    }
    public Teacher createTeacher() {
    	enterEmployeeInfo();
    	selectTeacherTitle();
    	return new Teacher(this.secondName, this.firstName, this.id, this.salary, this.title);
    }
    public ORManager createORManager() {
    	enterEmployeeInfo();
    	return new ORManager(this.secondName, this.firstName, this.id, this.salary);
    }
    public TechSupportGuy createTechSupportGuy() {
    	enterEmployeeInfo();
    	return new TechSupportGuy(this.secondName, this.firstName, this.id, this.salary);
    }
    public Admin createAdmin() {
        enterEmployeeInfo();
        return new Admin();
    }
    public static void optionsToChangeUser() {
    	System.out.println("1. Change first name \n 2. Change second name");
    }
    public static void optionsToChangeStudent() {
    	optionsToChangeUser();
    	System.out.println("3. Change speciality \n 4. Change faculty \n 5. Change degree \n 6. Change year of study");
    }
    public static void optionsToChangeEmployee() {
    	optionsToChangeUser();
    	System.out.println("3. Change salary");
    }
    public static void optionsToChangeTeacher() {
    	optionsToChangeEmployee();
    	System.out.println("4. Change teaher title");
    }
    public static void optionsToChangeORManager() {
    	optionsToChangeEmployee();
    }
    public static void optionsToChangeTechSupportGuy() {
    	optionsToChangeEmployee();
    }
    public static void changeFirstName(User user) {
    	System.out.println("Enter new first name");
    	user.setFirstName(WSP.readFromConsole());
    }
    public static void changeSecondName(User user) {
    	System.out.println("Enter new second name");
    	user.setSecondName(WSP.readFromConsole());
    }
    public static void changeSpeciality(Student student) { 
        System.out.println("Enter new speciality: ");
        String newSpeciality = WSP.readFromConsole();
        for (Speciality s: Data.getInstance().getSpecialities())
          if (s.getName().equals(newSpeciality)) {
            student.setSpeciality(s); 
            System.out.println("Successfully done.");
          }
          else System.out.println("Incorrect name of speciality.");
    }
    public static void changeFaculty(Student student) {
        System.out.println("Enter new faculty: ");
        String newFaculty = WSP.readFromConsole();
        for (Faculty f: Data.getInstance().getFaculties())
          if (f.getName().equals(newFaculty)) {
            student.setFaculty(f);; 
            System.out.println("Successfully done.");
          }
          else System.out.println("Incorrect name of faculty.");
      }
    public static void changeYearOfStudy(Student student) {
    	System.out.println("Enter new year of study: ");
    	int year = Integer.parseInt(WSP.readFromConsole());
    	student.setYearOfStudy(year);
    	System.out.println("Successfully done!");
    }
    public static void changeDegree(Student student) {
    	System.out.println("Choose new degree: ");
    	System.out.println("1. Bachelor \n2.Master \n3.Doctor");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: student.setDegree(Degree.BACHELOR); 
    	case 2: student.setDegree(Degree.MASTER);
    	case 3: student.setDegree(Degree.DOCTOR);
    	}
    	System.out.println("Successfully done!"); 
    }
    public static void changeSalary(Employee emp) {
    	System.out.println("Enter new salary");
    	emp.setSalary(Double.parseDouble(WSP.readFromConsole()));
    }
    public static void changeTeacherTitle(Teacher teacher) {
    	System.out.println("Choose new title");
    	System.out.println("Enter 1 for Tutor \n 2. Enter 2 for Lector \n 3. Enter 3 for Senior Lector \n 4. Enter 4 for Professor");
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: teacher.setTitle(TeacherTitle.TUTOR);
    	case 2: teacher.setTitle(TeacherTitle.LECTOR);
    	case 3: teacher.setTitle(TeacherTitle.SENIOR_LECTOR);
    	case 4: teacher.setTitle(TeacherTitle.PROFESSOR);
    	}
    }
    public static void updateStudentInfo(Student student) {
    	optionsToChangeStudent();
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: changeSecondName(student);
    	case 2: changeFirstName(student);
    	case 3: changeSpeciality(student);
    	case 4: changeFaculty(student);
    	case 5: changeDegree(student);
    	case 6: changeYearOfStudy(student);
    	}
    }
    public static void updateTeacherInfo(Teacher teacher) {
    	optionsToChangeTeacher();
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: changeFirstName(teacher);
    	case 2: changeSecondName(teacher);
    	case 3: changeSalary(teacher);
    	case 4: changeTeacherTitle(teacher);
    	}
    }   
    public static void updateORManagerInfo(ORManager orManager) {
    	optionsToChangeORManager();
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: changeFirstName(orManager);
    	case 2: changeSecondName(orManager);
    	case 3: changeSalary(orManager);
    	}
    }
    public static void updateTechSupportGuy(TechSupportGuy techSupportGuy) {
    	optionsToChangeTechSupportGuy();
    	int option = Integer.parseInt(WSP.readFromConsole());
    	switch(option) {
    	case 1: changeFirstName(techSupportGuy);
    	case 2: changeSecondName(techSupportGuy);
    	case 3: changeSalary(techSupportGuy);
    	}
    }
    public static void updateAdminInfo(Admin admin) {
        optionsToChangeUser();
        int option = Integer.parseInt(WSP.readFromConsole());
        switch(option) {
        case 1: changeFirstName(admin);
        case 2: changeSecondName(admin);}
   }
    public static void changePassword(User u) {
    	System.out.println("Write new password");
    	String password = WSP.readFromConsole();
    	u.setPassword(password);
    }
}
