package com.ram.sod.db;

import java.util.ArrayList;
import java.util.List;

import com.ram.sod.SODException;
import com.ram.sod.dto.Team;
import com.ram.sod.dto.User;

public class DummyAdminDAO implements IAdminDao {

	@Override
	public List<Team> getTeams() {
		Team team = new Team();
		team.setTeamName("PS_SSP");
		team.addUser(new User("ruhul", "ruhul", true, "ruhul", "mazumder"));
		team.addUser(new User("sam", "sam", true, "sam", "mazumder"));
		team.addUser(new User("karthik", "karthik", false, "karthik", "paulpandian"));
		team.addUser(new User("mukilan", "mukilan", false, "mukilan", "p"));
		
		List<Team> teams = new ArrayList<Team>();
		teams.add(team);
		return teams;
		
	}

	@Override
	public Team getTeam(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToTeam(User user, String teamName) throws SODException {
		// TODO Auto-generated method stub
		
	}

}
