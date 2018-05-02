package com.fuseIn.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuseIn.Iservice.IRegister;
import com.fuseIn.bo.RegisterUserBO;
import com.fuseIn.dto.RegisterUserTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value="/Registration")
@Path("/register")
public class Registration {
	
	@Autowired
	private IRegister registerUserBo;
	
	@POST
	@ApiOperation(value = "Submit registration details", httpMethod = "POST", notes = "registration details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistrationDetails(@ApiParam(value = "User addition to portal", required = true) RegisterUserTO userRegistration) {
		
		RegisterUserBO userBo = new RegisterUserBO();
		
		userBo.setFirstName(userRegistration.getFirstName());
		userBo.setLastName(userRegistration.getLastName());
		userBo.setGender(userRegistration.getGender());
		userBo.setAddress(userRegistration.getAddress());
		userBo.setAge(userRegistration.getAge());
		userBo.setContact(userRegistration.getContact());
		userBo.setEmail(userRegistration.getEmail());
		userBo.setInterest(userRegistration.getInterest());
		
		registerUserBo.create(userBo);
		
		return Response.ok().entity(userRegistration).build();
	}
}
