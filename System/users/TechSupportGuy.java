package users;

import java.util.ArrayList;
import enumerations.OrderStatus;
import data.*;
import system.*;
import controllers.*;
/** Class Tech Support Guy */
public class TechSupportGuy extends Employee {
	/** ArrayList of new orders that were not viewed*/
	private static ArrayList<Order> newOrders;
	/** ArrayList of accepted orders - all orders that were accepted */
	private static ArrayList<Order> acceptedOrders;
    /** No-argument constructor */
	public TechSupportGuy() {}
	/**
	 * Constructor for creating object TechSupportGuy with parameters
	 * @param secondName surname of Tech Support Guy
	 * @param firstName name of Tech Support Guy
	 * @param id unique ID of Tech Support Guy
	 * @param salary salary of Tech Support Guy
	 */
    public TechSupportGuy(String secondName, String firstName, int id, double salary) {
		super(firstName, secondName, id, salary);}
    /**Static initialization block*/
    static {
    	newOrders = new ArrayList<Order>();
    	acceptedOrders = new ArrayList<Order>();
    }
    /**
     * Returns ArrayList of new orders
     * @return ArrayList List of orders which are not viewed
     */
    public static ArrayList<Order> getNewOrders() {return newOrders;}
    /**
     * Returns ArrayList of accepted order
     * @return ArrayList List of orders which are accepted
     */
	public static ArrayList<Order> getAcceptedOrders() {return acceptedOrders;}
	/**
	 * This method is used to add order to static ArrayList "accepted orders" and remove it from "new orders" static ArrayList. 
	 * The status of order is changed to ACCEPT
	 * @param order the order that Tech Support Guy wants to accept;
	 */
    public void acceptOrder(Order order) {
    	acceptedOrders.add(order);
    	newOrders.remove(order);
    	order.setStatus(OrderStatus.ACCEPTED);}
	 /**This method is used to remove order from "new orders" static ArrayList. The status of order is changed to REJECT
	  * @param order the order Tech Support Guy wants to reject;
	  */
    public void rejectOrder(Order order) {
    	newOrders.remove(order);
        order.setStatus(OrderStatus.REJECTED);}
	 /**
	  * This method is used to add new order to static "newOrders" ArrayList
	  * @param order the order User wants to send;
	  * @return boolean check whether the order is added to new orders list or not
	  */
    public static boolean addNewOrder(Order order) {
    	return newOrders.add(order);}
	  /**
	   * This method is used to update particular fields of TechSupportGuy
	   */
    public void updateInfo() {
    	UserOperation.updateTechSupportGuy(this);}
	  /**
	   * Menu of Tech Support Guy with different options
	   */
	public void userController() {
		TechSupportGuyController tc = new TechSupportGuyController(this);
		tc.techSupportGuyMenu();
		
	}
}

	

