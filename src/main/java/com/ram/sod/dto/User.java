package com.ram.sod.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class User implements SODEnity{
	
	String userName;
	String password;
	boolean scrumMaster;
	String firstName;
	String lastName;
	
	
	public User(){
		
	}
	
	public User(String userName, String password, boolean isScrumMaster,
			String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.scrumMaster = isScrumMaster;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public boolean isScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(boolean scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", isScrumMaster=" + scrumMaster + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	 public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      User obj2 = (User)obj;
	      if(this.userName == obj2.getUserName())
	      {
	         return true;
	      }
	      return false;
	   }
	 
	 
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( userName ).hashCode();
	      return tmp;
	   }
	
	
	
	
}
