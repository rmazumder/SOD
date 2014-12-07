package com.ram.sod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ram.sod.SODConstant.StatusCode;
import com.ram.sod.db.DAOFactory;
import com.ram.sod.db.DBUtils;
import com.ram.sod.dto.Team;
import com.ram.sod.dto.User;
import com.ram.sod.dto.ui.UIResponse;


@Path("/admin")
public class SODAdminManager {
	
	 	@GET
	 	@Produces(MediaType.APPLICATION_JSON)
	    @Path("/load")
	    public Response loadData()
	    {
		 	List<Team> teams = new ArrayList<Team>();
			try {
				teams = DAOFactory.getAdminDAO().getTeams();
			} catch (SODException e) {
				e.printStackTrace();
			}
		 	Gson gson = new GsonBuilder().create();
	        return Response.status(200).entity(gson.toJson(teams)).build();
	    }

	 	 @POST
	     @Produces(MediaType.APPLICATION_JSON)
	     @Path("/addteam")
	     public Response addTeam(@Context HttpServletRequest httpRequest)
	     {
	     	
	 		UIResponse response = new UIResponse();
	     	try {
				String requestData =  SODUtil.readInputStream(httpRequest);
				 JsonElement jelement = new JsonParser().parse(requestData);
				 JsonObject  jobject = jelement.getAsJsonObject();
				 Team team = new Team();
				 String teamName = jobject.get("teamName").getAsString();
				 team.setTeamName(teamName);
				 team.setDescription(jobject.get("description").getAsString());
				 DBUtils.addEntity(team);
				 response.setStatus(StatusCode.success);
				 response.setMessage(teamName + " created successfully");
				
			
	     	} catch (IOException | SODException e) {
				
				response.setStatus(StatusCode.serviceerror);
				response.setMessage(e.getMessage());
			}
	         Gson gson = new GsonBuilder().create();
	         return Response.status(200).entity(gson.toJson(response)).build();
	     }
	 	 
	 	 @POST
	     @Produces(MediaType.APPLICATION_JSON)
	     @Path("/adduser/{team}")
	     public Response addUser(@Context HttpServletRequest httpRequest, @PathParam("team") String teamName)
	     {
	     	
	 		UIResponse response = new UIResponse();
	     	try {
				String requestData =  SODUtil.readInputStream(httpRequest);
				 JsonElement jelement = new JsonParser().parse(requestData);
				 JsonObject  jobject = jelement.getAsJsonObject();
				 String userName = jobject.get("userName").getAsString();
				 String password = jobject.get("password").getAsString();
				 String firstName = jobject.get("firstName").getAsString();
				 String lastName = jobject.get("lastName").getAsString();
				 boolean isScrumMaster = jobject.get("isScrumMaster").getAsBoolean();
				 
				
				 User user = new User();
				 user.setUserName(userName);
				 user.setPassword(password);
				 user.setFirstName(firstName);
				 user.setLastName(lastName);
				 user.setScrumMaster(isScrumMaster);
				 
				 //user = DAOFactory.getAdminDAO().createUser(user);
				 DAOFactory.getAdminDAO().addUserToTeam(user, teamName);
				 
				 
				 response.setStatus(StatusCode.success);
				 response.setMessage(teamName + " created successfully");
				
			
	     	} catch ( Exception e) {
				
				response.setStatus(StatusCode.serviceerror);
				response.setMessage(e.getMessage());
			}
	         Gson gson = new GsonBuilder().create();
	         return Response.status(200).entity(gson.toJson(response)).build();
	     }
}
