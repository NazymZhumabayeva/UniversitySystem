package controllers;
import users.*;
import system.*;

import java.io.IOException;

public class AdminController {
	private Admin admin;
	
	public AdminController() {}

	public AdminController(Admin admin) {this.admin = admin;}
	
	public void adminMenu() throws IOException {
		try {
			menu : while(true) {
				System.out.println("Welcome to the WSP! \n");
				System.out.println("Choose the option: \n 1. Manage users \n 2. See users' actions \n 3. Messages \n 4. Change password \n 5. Exit");
				int option = Integer.parseInt(WSP.readFromConsole());
			    switch (option) {
			    case 1: {manageUsersMenu();break;}
			    case 2: {admin.seeUsersActions();break;}
			    case 3: {
					DataOperation dataOperation = new DataOperation();
					dataOperation.messageMenu(admin);
					break;}
			    case 4: {UserOperation.changePassword(admin);break;}
			    case 5: {
			    	System.out.println("Good bye!");
			    
			    	WSP.serialize(WSP.getData(), "data.out");
			    	break menu;}}
			}
		}catch (Exception e) {
			System.out.println("Erroe detected... \n Saving resources...");
			e.printStackTrace();
			WSP.serialize(WSP.getData(), "data.out");
		}
	}
	public Admin getAdmin() {
		return admin;
	}
	
	public void manageUsersMenu() throws IOException {
		while(true) {
			System.out.println("Choose operation: \n 1. Add user \n 2. Remove user \n 3. Update info about user \n 4. Returns back");
		    int option = Integer.parseInt(WSP.readFromConsole());
		    switch (option) {
		    case 1: {this.addUserMenu();break;}
		    case 2: {this.removeUserMenu();break;}
		    case 3: {this.updateUserInfoMenu();break;}
		    case 4: {
		    	this.adminMenu();
		    	WSP.serialize(WSP.getData(), "data.out");}
		    }}}
	  
	  public void addUserMenu() {
	    UserOperation uo = new UserOperation();
	    System.out.println("Who do you want to add?\n");
	    System.out.println("1. Student\n2.Teacher\n3.ORManager\n4.Admin\n5.Tech Support Guy\n");
	    int option = Integer.parseInt(WSP.readFromConsole());
	    switch(option) {
	    case 1: {admin.addUser(uo.createStudent());break;}
	    case 2: {admin.addUser(uo.createTeacher());break;}
	    case 3: {admin.addUser(uo.createORManager());break;}
	    case 4: {admin.addUser(uo.createAdmin());break;}
	    case 5: {admin.addUser(uo.createTechSupportGuy());break;}
	    }
	  } 
	  
	  public void removeUserMenu() {
	    System.out.println("Write the ID of the student you want to remove.");
	    int id = Integer.parseInt(WSP.readFromConsole());
	    User user = null;
	    for (User u: WSP.getData().getUsers()) {
	      if (u.getId() == id) 
	        user = u;
	    }
	    if (user == null) System.out.println("Incorrect ID. There is no user with such ID.");
	    else admin.removeUser(user);
	  }
	  public void updateUserInfoMenu() {
	    System.out.println("Write the ID of the student you want to update.");
	    int id = Integer.parseInt(WSP.readFromConsole());
	    User user = null;
	    for (User u: WSP.getData().getUsers()) {
	      if (u.getId() == id) 
	        user = u;
	    }
	    if (user == null) System.out.println("Incorrect ID. There is no user with such ID.");
	    else admin.updateUser(user);
	  }
	  /*
	  public void checkUser(){
		  System.out.println("Write the ID of the student you want to remove.");
		    int id = Integer.parseInt(WSP.readFromConsole());
		    User user = null;
		    for (User u: WSP.getData().getUsers()) {
		      if (u.getId() == id) 
		        user = u;
		    }
		    if (user == null) System.out.println("Incorrect ID. There is no user with such ID.");
	  }
	  */

	

}
