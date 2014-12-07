package com.ram.sod;

public class SODConstant {

	public static enum StatusCode {
		success(0), serviceerror(1),  autherror(2);
		
		public int code;
		
		StatusCode(int code){
			this.code = code;
		}
	}
}
