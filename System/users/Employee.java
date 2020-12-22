package users;

import java.util.ArrayList;

import data.*;
import enumerations.MessageStatus;
public abstract class Employee extends User {
    private double salary;
    private ArrayList<Message> readMessages;
    private ArrayList<Message> unreadMessages;
    
    public Employee() {}
    public Employee( String secondName, String firstName, int id) {
		super(secondName, firstName, id);
		readMessages = new ArrayList<Message>();
		unreadMessages = new ArrayList<Message>();}
    
    public Employee( String secondName, String firstName, int id, double salary) {
		super(secondName, firstName, id);
		this.salary = salary;
		readMessages = new ArrayList<Message>();
		unreadMessages = new ArrayList<Message>();}
    
    public double getSalary() {return salary;}
	public void setSalary(double salary) {this.salary = salary;}
	
	public ArrayList<Message> getReadMessages() {return readMessages;}
	
	public ArrayList<Message> getUnreadMessages() {return unreadMessages;}
	
    public boolean sendMessage(Message message, Employee receiver) {
    	return receiver.unreadMessages.add(message);}

    public void readMessage(Message message) {	
    	message.setStatus(MessageStatus.READ);
    	unreadMessages.remove(message);
    	readMessages.add(message);}
    
    public ArrayList<Message>findMessages(Employee employee){
    	ArrayList <Message> findMessages = new ArrayList <Message>();
    	for (Message m : this.readMessages) {
    		if (m.getSender().equals(employee))
    			findMessages.add(m);}
    	for (Message m : this.unreadMessages) {
    		if (m.getSender().equals(employee))
    			findMessages.add(m);}
    	return findMessages;
    }

	@Override
	public String toString() {
		return super.toString() + "/n" + "Employee [salary=" + salary + "]";}
    }

  


