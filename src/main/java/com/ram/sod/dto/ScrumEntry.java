package com.ram.sod.dto;

import java.util.Set;

public class ScrumEntry implements SODEnity {


	long id;	
	String userName;
	Set<TaskEntry> todaysEtries ;
	Set<TaskEntry> yestardayEntry ;	
	String date;
	
	public ScrumEntry(Set<TaskEntry> todays, Set<TaskEntry> yestardays, String userName, String date){
		this.todaysEtries = todays;
		this.yestardayEntry = yestardays;
		this.userName = userName;
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<TaskEntry> getTodaysEtries() {
		return todaysEtries;
	}

	public void setTodaysEtries(Set<TaskEntry> todaysEtries) {
		this.todaysEtries = todaysEtries;
	}

	public Set<TaskEntry> getYestardayEntry() {
		return yestardayEntry;
	}

	public void setYestardayEntry(Set<TaskEntry> yestardayEntry) {
		this.yestardayEntry = yestardayEntry;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	

}
