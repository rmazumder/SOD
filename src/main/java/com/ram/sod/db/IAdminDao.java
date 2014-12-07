package com.ram.sod.db;

import java.util.List;

import com.ram.sod.SODException;
import com.ram.sod.dto.Team;
import com.ram.sod.dto.User;

public interface IAdminDao {
	
	List<Team> getTeams() throws SODException;
	
	Team getTeam(String name) throws SODException;

	User createUser(User user) throws SODException;

	void addUserToTeam(User user, String teamName) throws SODException;;

}
