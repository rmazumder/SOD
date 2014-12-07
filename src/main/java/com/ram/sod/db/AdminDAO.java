package com.ram.sod.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.SerializationException;

import com.ram.sod.SODException;
import com.ram.sod.dto.Team;
import com.ram.sod.dto.User;

public class AdminDAO implements IAdminDao {

	@Override
	public List<Team> getTeams() {
		return DBUtils.ListEntity("FROM Team");
		
	}

	@Override
	public Team getTeam(String name) {
		 List<Team> teams = DBUtils.ListEntity("FROM Team as team where team.teamName='"+name+"'");
		 if (teams != null) {
			 if(teams.size() != 0) {
				 return teams.get(0);
         	}
		 }
		 return null;
	}

	@Override
	public User createUser(User user) throws SODException {
		 List<User> users = DBUtils.ListEntity("FROM User as user where user.userName='"+user.getUserName()+"'");
		 if (users != null) {
			 if(users.size() != 0) {
				 users.get(0);
         	}
		 }
		 DBUtils.addEntity(user);
		 return user;
	}

	@Override
	public void addUserToTeam(User user, String teamName) throws SODException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Team> teams = new ArrayList();
        try{
        	session.save(user);
        	teams = session.createQuery("FROM Team as team where team.teamName='"+teamName+"'").list();
        	if (teams != null) {
   			 if(teams.size() != 0) {
   				Team team = teams.get(0);
   				team.addUser(user);
   				session.update(team);
            	}
   		 }
        }catch(Exception e){
        	throw new SODException(e.getMessage());
        }
		 /*List<Team> teams = DBUtils.ListEntity("FROM Team as team where team.teamName='"+teamName+"'");
		 if (teams != null) {
			 if(teams.size() != 0) {
				 Team team =  teams.get(0);
				 team.addUser(user);
				 DBUtils.saveEntity(team);
         	}
		 }*/
		
	}

}
