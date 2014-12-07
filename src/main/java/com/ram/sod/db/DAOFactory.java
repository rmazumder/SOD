package com.ram.sod.db;

public class DAOFactory {
	
	public static IAdminDao getAdminDAO(){
		return new AdminDAO();
	}

}
