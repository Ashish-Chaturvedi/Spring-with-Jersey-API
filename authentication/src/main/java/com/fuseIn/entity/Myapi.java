package com.fuseIn.entity;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.fuseIn.IserviceImpl.RegistrationImpl;
import com.fuseIn.controller.Registration;


public class Myapi extends ResourceConfig {
 
	public Myapi() {
		register(RequestContextFilter.class);
		register(Registration.class);
		register(RegistrationImpl.class);
		
	}
}
