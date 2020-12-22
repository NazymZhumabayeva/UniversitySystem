package data;

import java.io.Serializable;
import java.util.*;
import enumerations.MessageStatus;
import users.Employee;

public class Message implements Serializable{
    private Employee sender;
    private String header;
    private String body;
	private Date date;
	private MessageStatus status;
    public Message() {}
    public Message(Employee sender, String header, String body) {
		this.header = header;
		this.body = body;
		this.date = new Date();               
		this.sender = sender;
		this.status = MessageStatus.UNREAD;
	}
	public Employee getSender() {return sender;}
	public void setSender(Employee sender) {this.sender = sender;}
	
	public String getHeader() {return header;}
	public void setHeader(String header) {this.header = header;}
	
	public Date getDate() {return date;}
	
	public String getBody() {return body;}
	public void setBody(String body) {this.body = body;}
	
	
	public MessageStatus getStatus() {return status;}
	public void setStatus(MessageStatus status) {this.status = status;}
	public String printHeader() {
		return "sender= " + sender + "header = " + header;
	}
	@Override
	public String toString() {
		return "Message [sender=" + sender + ", header=" + header + ", body=" + body + ", status=" + status + ", date=" + date + "]";
	}
	
	
	
	
	
    
}

