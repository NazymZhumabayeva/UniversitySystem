package controllers;
import java.io.IOException;

import data.Course;
import system.*;
import users.*;
public class UserController {
	public UserController() {}
	public void login() throws IOException {
		System.out.println("Enter login");
		int id = Integer.parseInt(WSP.readFromConsole());
		System.out.println("Enter password");
		String password = WSP.readFromConsole();
		for (User u: WSP.getData().getUsers()) {
			if (u.getId()==id && u.getPassword().equals(password)) {
				u.userController();
				break;
			}
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		WSP intranet = new WSP();
		UserController userController = new UserController();
		Admin test = new Admin("Second", "First", 100);
		ORManager orManager = new ORManager("A", "B", 200);
		WSP.getData().getUsers().add(test);
		WSP.getData().getAdmins().add(test);
		
		userController.login();
		
		
		
	}


	

}
