package com.ram.sod.dto;


public class Task implements SODEnity {
	String taskId;
	String taskdesc;
	String teamName;
	
	public Task(String taskId, String taskdesc, String teamName) {
		this.taskId = taskId;
		this.taskdesc = taskdesc;
		this.teamName = teamName;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskdesc() {
		return taskdesc;
	}
	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskdesc=" + taskdesc
				+ ", teamName=" + teamName + "]";
	}
	
	
	
}
