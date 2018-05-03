package com.fuseIn.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuseIn.Impl.RegistrationServiceImpl;
import com.fuseIn.Iservice.IRegister;
import com.fuseIn.bo.RegisterUserBO;
import com.fuseIn.dto.RegisterUserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/*
 * 
 * @author AshishChaturvedi
 * 
 */

@Api(value = "/Registration")
@Path(Registration.REGISTER_PATH)
public class Registration {
	
	protected static final String REGISTER_PATH = "/register";
	
	@Autowired
	private IRegister registerUserBo;

	@POST
	@ApiOperation(value = "Submit registration details", httpMethod = "POST", notes = "registration details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistrationDetails(
			@ApiParam(value = "User addition to portal", required = true) RegisterUserDTO userRegistration) {

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
