package data;

import java.io.Serializable;
import java.util.Date;
import enumerations.*;
import users.*;

public class Order implements Serializable{
	private Employee sender;
	private String header;
    private String body;
    private OrderStatus status;
    private Date date;
    public Order() {}
    public Order(Employee sender, String header, String body) {
    	this.sender = sender;
    	this.header = header;
    	this.body = body;
    	this.date = new Date();
    	this.status=OrderStatus.INPROCESSING;}
    
    
    public Employee getSender() {return sender;}
	public void setSender(Employee sender) {this.sender = sender;}
	
	public String getHeader() {return header;}
	public void setHeader(String header) {this.header = header;}
	
	public String getBody() {return body;}
	public void setBody(String body) {this.body = body;}
	
	public Date getDate() {return date;}
	
	public OrderStatus getOrderStatus() {return this.status;}
    public void setStatus(OrderStatus newstatus) {
    	this.status = newstatus;}
	@Override
	public String toString() {
		return "Order [sender=" + sender + ", header=" + header + ", body=" + body + ", status=" + status + ", date="
				+ date + "]";
	}
    
    
    
}