

package com.ram.sod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ram.sod.db.DBUtils;
import com.ram.sod.db.SODDummyDB;


@Path("/mmapi")
public class SODManager
{
	
	public static Properties appProperties = null;
	
	
	public SODManager(){
		appProperties = new Properties();
		try {
			appProperties.load(new FileInputStream(new File("sod.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			appProperties = new Properties();
			appProperties.put("media_ext", ".avi,.mpg,.mkv,.mov,.dat");
			appProperties.put("rt_api_key", "");
			appProperties.put("media_fileExtractor_regex1", "(.*?)(dvdrip|xvid| cd[0-9]|dvdscr|brrip|divx|[\\{\\(\\[]?[0-9]{4}).*");
			appProperties.put("media_fileExtractor_regex2","(.*?)\\(.*\\)(.*)");
			
		}
	}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/load")
    public Response loadData()
    {
       
        Gson gson = new GsonBuilder().create();
        return Response.status(200).entity(gson.toJson(SODDummyDB.getTodaysNotes())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(@Context HttpServletRequest httpRequest)
    {
    	String userName = httpRequest.getParameter("userName");
    	String password = httpRequest.getParameter("password");
    	AuthStatus status = new AuthStatus();
    	status.isAuthenticated = true;
    	status.authenticatedUser = userName;
    	httpRequest.getSession().setAttribute("AUTH_STATUS", status);
    	
        Gson gson = new GsonBuilder().create();
        return Response.status(200).entity(gson.toJson(status)).build();
    }
   
}
