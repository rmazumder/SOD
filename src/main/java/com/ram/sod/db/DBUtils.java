// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DBUtils.java

package com.ram.sod.db;

import com.ram.sod.SODException;
import com.ram.sod.dto.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.*;

// Referenced classes of package com.ram.mm.db:
//            HibernateUtil

public class DBUtils
{

    public DBUtils()
    {
    }

    public static void saveEntity(SODEnity entity) throws SODException
    {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
        	
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
            
        }
        catch(Exception e)
        {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            throw new SODException(e.getMessage());
        }
    }
    
    public static void addEntity(SODEnity entity) throws SODException
    {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
        	
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
        catch(Exception e)
        {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            throw new SODException(e.getMessage());
        }
    }
    
    public static void deleteEntity(String entityName) throws SODException
    {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            SODEnity movie = (SODEnity)session.get(SODEnity.class, entityName);
            session.delete(movie);
            tx.commit();
        }
        catch(Exception e)
        {
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            throw new SODException(e.getMessage());
        }
    }


   

	

	public static List ListEntity(String query)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List entities = new ArrayList();
        try
        {
            entities = session.createQuery(query).list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return entities;
    }

    public static void main(String r[]) throws SODException 
    {
    	/*Team team  = DAOFactory.getAdminDAO().getTeam("SSP11");
    	System.out.println(team);
    	
    	team = new Team();
    	 team.setTeamName("SSP11");
    	 team.setDescription("sdsds");
    	 
    	 HashSet<User> users = new HashSet<User>();
    	 User user = new User("ruhul", "password", true, "ruhul", "mazumder");
    	 users.add(user);
    	 team.setUsers(users);
    	 DBUtils.saveEntity(team);
    	
    	List<Team> teams =  DAOFactory.getAdminDAO().getTeams();
    	for (Team team1 : teams){
    		System.out.println(team1);
    	}*/
    	
    	
    	/*ScrumNotes notes = SODDummyDB.getTodaysNotes();
    	
    	List<Blockers> blockers = notes.getBlockers();
    	for(Blockers blocker : blockers){
    		DBUtils.saveEntity(blocker);
    	}
    	
    	Map<String , ScrumEntry > entry  = notes.getOthers();
    	for (Map.Entry<String , ScrumEntry > scentry : entry.entrySet()){
    		
    		ScrumEntry task = scentry.getValue();
    		
    		DBUtils.saveEntity(task);
    	}
    	
    	List<ScrumEntry> scrumEnt = DBUtils.ListEntity("FROM ScrumEntry");
    	for (ScrumEntry entry1 : scrumEnt){
    		System.out.println(entry1);
    	}*/
    	
    	Task task = new Task("1123","dwddsds","SSP");
    	TaskEntry entry = new TaskEntry("dsdsds", 12, 4, task, "ruhul");
    	DBUtils.saveEntity(entry);
    	
      
    }
}
