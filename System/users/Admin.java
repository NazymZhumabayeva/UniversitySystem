package users;
import system.*;

import java.io.IOException;

import controllers.*;
public class Admin extends Employee {
	public Admin() {}
    public Admin( String secondName, String firstName, int id) {
		super(secondName, firstName, id);
    }
    public boolean addUser(User user) {
    	if (user instanceof Student)
    		WSP.getData().getStudents().add((Student)user);
    	else if (user instanceof Employee) {
    		WSP.getData().getEmployees().add((Employee) user);
    		if (user instanceof Teacher) 
        		WSP.getData().getTeachers().add((Teacher)user);
        	if (user instanceof ORManager)
        		WSP.getData().getManagers().add((ORManager)user);
        	if (user instanceof TechSupportGuy)
        		WSP.getData().getTechSupportGuys().add((TechSupportGuy)user);
        	if (user instanceof Admin)
        		WSP.getData().getAdmins().add((Admin)user);
    	}
        return WSP.getData().getUsers().add(user);
    }
    public boolean removeUser(User user) {
    	if (user instanceof Student)
    		WSP.getData().getStudents().remove((Student)user);
    	else if (user instanceof Employee) {
    		WSP.getData().getEmployees().remove((Employee) user);
	    	if (user instanceof Teacher)
	    		WSP.getData().getTeachers().remove((Teacher)user);
	    	if (user instanceof ORManager)
	    		WSP.getData().getManagers().remove((ORManager)user);
	    	if (user instanceof TechSupportGuy)
	    		WSP.getData().getTechSupportGuys().remove((TechSupportGuy)user);
	    	if (user instanceof Admin)
	    		WSP.getData().getAdmins().remove((Admin)user);
    	}
        return WSP.getData().getUsers().remove(user);
    }
    public void updateUser(User user) {
    	user.updateInfo();
    }
    public void updateInfo() {
    	UserOperation.updateAdminInfo(this);}
    public void seeUsersActions() {
    }
	public void userController() {
		AdminController adminController = new AdminController(this);
		try {
			adminController.adminMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


}

