package com.fuseIn.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.fuseIn.Iservice.IRegister;
import com.fuseIn.bo.RegisterBO;
import com.fuseIn.dto.RegisterDTO;
import com.fuseIn.util.EncodeCredentials;

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
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private IRegister registerUserBo;

	@POST
	@ApiOperation(value = "Submit registration details", httpMethod = "POST", notes = "registration details")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getRegistrationDetails(
			@ApiParam(value = "User addition to portal", required = true) RegisterDTO userRegistration) {
		
		logger.info("user registration called");
		
		RegisterBO userBo = new RegisterBO();

		userBo.setFirstName(userRegistration.getFirstName());
		userBo.setLastName(userRegistration.getLastName());
		userBo.setGender(userRegistration.getGender());
		userBo.setAddress(userRegistration.getAddress());
		userBo.setAge(userRegistration.getAge());
		userBo.setContact(userRegistration.getContact());
		userBo.setEmail(userRegistration.getEmail());
		userBo.setInterest(userRegistration.getInterest());
		userBo.setPassword(userRegistration.getPassword());

		String check = registerUserBo.create(userBo);

		return Response.ok().entity(check).build();
	}
}
