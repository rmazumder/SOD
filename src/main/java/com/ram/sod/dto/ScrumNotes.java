package com.ram.sod.dto;

import java.util.List;
import java.util.Map;
import com.ram.sod.SODConstant.StatusCode;

public class ScrumNotes {
	
	List<Blockers> blockers;	
	Map<String , ScrumEntry> others;	
	ScrumEntry self;	
	String date;	
	StatusCode status;
	

	public List<Blockers> getBlockers() {
		return blockers;
	}

	public void setBlockers(List<Blockers> blockers) {
		this.blockers = blockers;
	}

	public Map<String, ScrumEntry> getOthers() {
		return others;
	}

	public void setOthers(Map<String, ScrumEntry> others) {
		this.others = others;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ScrumEntry getSelf() {
		return self;
	}

	public void setSelf(ScrumEntry self) {
		this.self = self;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}

	
	
 
}
