package com.ram.sod.dto;


public class Blockers implements SODEnity {


	long id;
	String text;
	String createdBy;
	String sevirity;
	String date;
	
	public Blockers(String blocker, String createdBy, String sev, String date){
		this.text =  blocker;
		this.createdBy =  createdBy;
		this.sevirity = sev;
		this.date = date;
	}
	
	public String getBlockers() {
		return text;
	}
	public void setBlockers(String blockers) {
		this.text = blockers;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getSevirity() {
		return sevirity;
	}
	public void setSevirity(String sevirity) {
		this.sevirity = sevirity;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
