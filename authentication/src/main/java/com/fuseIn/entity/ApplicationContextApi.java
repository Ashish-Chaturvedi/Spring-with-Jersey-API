package com.fuseIn.entity;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.fuseIn.Impl.RegistrationDAOImpl;
import com.fuseIn.Impl.RegistrationServiceImpl;
import com.fuseIn.controller.Registration;

public class ApplicationContextApi extends ResourceConfig {
 
	public ApplicationContextApi() {
		register(RequestContextFilter.class);
		register(Registration.class);
		register(RegistrationServiceImpl.class);
		register(RegistrationDAOImpl.class);		
	}
}