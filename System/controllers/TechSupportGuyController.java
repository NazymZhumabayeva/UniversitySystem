package controllers;

import users.*;
import system.*;
import data.*;
public class TechSupportGuyController {
	private TechSupportGuy techSupportGuy;
	public TechSupportGuyController() {};
	public TechSupportGuyController(TechSupportGuy techSupportGuy) {
		this.techSupportGuy=techSupportGuy;
	}
    public TechSupportGuy getTechsupportguy() {
    	return techSupportGuy;
    }
    public void techSupportGuyMenu()  {
		System.out.println("Welcome to the WSP! \n");
		System.out.println("Choose the option \n 1. Info about TechSupportGuy \n 2. View new orders  \n 3. View accepted orders "
				+ "\n 4. Manage Order \n 5. Messages \n 6. Change password");
		int option = Integer.parseInt(WSP.readFromConsole());
		switch (option) {
		case 1: techSupportGuy.toString();
		case 2: TechSupportGuy.getNewOrders();
		case 3: TechSupportGuy.getAcceptedOrders();
		case 4: this.manageOrder();
		case 5: {
			DataOperation dataOperation = new DataOperation();
			dataOperation.messageMenu(techSupportGuy);}
		case 6: UserOperation.changePassword(techSupportGuy);}
    }		
	public void manageOrder() {
		System.out.println("Here new orders");
		int num = 1;
		for(Order o:TechSupportGuy.getNewOrders()) {
			System.out.println(num++ + " "+o.getHeader());}
		System.out.println("Choose the number of Order");
		int ordNum = Integer.parseInt(WSP.readFromConsole());
		Order order = TechSupportGuy.getNewOrders().get(ordNum - 1);
		System.out.println("Choose the option: \n 1. Accept order \n 2. Reject order");
		int option = Integer.parseInt(WSP.readFromConsole());
		switch (option) {
		case 1: techSupportGuy.acceptOrder(order); 
		case 2: techSupportGuy.rejectOrder(order);}
	}
	
	}
    
