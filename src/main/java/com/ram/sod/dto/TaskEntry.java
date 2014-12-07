package com.ram.sod.dto;

public class TaskEntry implements SODEnity {
	int id;
	String description;
	int timeSpent;
	int timeRemaining;
	Task task;
	String userName;
	
	
	public TaskEntry(String desc, int timeSpent, int timeRemaining, Task task, String userName) {
		
		this.description = desc;
		this.timeSpent = timeSpent;
		this.timeRemaining = timeRemaining;
		this.task = task;
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	public int getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}
	public int getTimeRemaining() {
		return timeRemaining;
	}
	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "TaskEntry [id=" + id + ", description=" + description
				+ ", timeSpent=" + timeSpent + ", timeRemaining="
				+ timeRemaining + ", task=" + task + ", userName=" + userName
				+ "]";
	}

	
	
	
}
