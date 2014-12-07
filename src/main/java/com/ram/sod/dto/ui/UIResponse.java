package com.ram.sod.dto.ui;

import com.ram.sod.SODConstant.StatusCode;

public class UIResponse {
	
	StatusCode status;
	String message;
	int code;
	public StatusCode getStatus() {
		return status;
	}
	public void setStatus(StatusCode status) {
		this.status = status;
		this.code = status.code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
