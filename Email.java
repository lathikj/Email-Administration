package com.java.emailApplication;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultpasswordLength=8;
	private String department;
	private String email;
	private String companySuffix = "company-name.com";
	private int mailboxCapacity = 50;
	private String alternateEmail;
	
	// Constructor to recieve the first name and last name
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		//Call a method from the department - return the department
		this.department = setDepartment();
		
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultpasswordLength); 
		System.out.println("Your Password is:-" + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +department + "."+companySuffix;
		
	}
		
	// Ask for the department
	
	private String setDepartment() {
		System.out.println("New worker: "+ firstName+ "\nThe Department Codes:\n1. Sales\n2. Development\n3. Accounting\n0. None\nEnter department code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		switch(depChoice) {
			case 1:
				return "sales";
			case 2:
				return "dev";
			case 3:
				return "acct";
			default:
				 return "";
		}
		
		/*
		 
		 if(depChoice == 1) {return "sales";}
		 
		 else if(depChoice == 2) {return "dev";} 	
		 
		 else if(depChoice == 3) {return "acct";}
		 
		 else {return "";}
		 
		 */
		
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^*&()";
		char[] password1 = new char[length];
		for(int i=0;i<length;i++) {
			int random = (int)(Math.random() * passwordSet.length());
			password1[i] = passwordSet.charAt(random);
		}
		
		return new String(password1);
	}
		
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternativeEmail(String altEmail) {
		this.alternateEmail = altEmail;
		//Even though the variables have different names 
		//but its best practice when doing this set methods
	}
	
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return ("DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: " +mailboxCapacity +"gb");
	}
	
}
