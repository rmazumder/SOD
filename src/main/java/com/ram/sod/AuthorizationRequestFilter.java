package com.ram.sod;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import com.sun.jersey.spi.container.ContainerRequest;
 

@Provider  
public class AuthorizationRequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FIlter intecepted");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response; 
		AuthStatus status  = (AuthStatus)httpRequest.getSession().getAttribute("AUTH_STATUS");
		if(checkResources(httpRequest, httpResponse)){
			if(!isAuthenticated(status)){
				System.out.println("401");
				httpResponse.setStatus(401);
				httpResponse.sendError(401);
			}
		}
		
		chain.doFilter(request,response);
	}
		
		

	private boolean checkResources(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		System.out.println(httpRequest.getRequestURI());
		if(httpRequest.getRequestURI().endsWith("rest/mmapi/load")){
			return true;
		}
		return false;
	}

	private boolean isAuthenticated(AuthStatus status) {
		if(status != null && status.isAuthenticated){
			return true;
		}
		
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
	
}