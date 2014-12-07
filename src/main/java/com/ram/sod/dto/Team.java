package com.ram.sod.dto;

import java.util.Set;
import java.util.TreeSet;

public class Team implements SODEnity {

	String teamName;

	Set<User> users;
	String description;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addUser(User user) {
		if (this.users == null) {
			this.users = new TreeSet<User>();

		}
		users.add(user);
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", users=" + users
				+ ", description=" + description + "]";
	}

}
