package com.fuseIn.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fuseIn.entity.RegisterUserTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value="/Registration")
@Path("/register")
public class Registration {

	@POST
	@ApiOperation(value = "Submit registration details", httpMethod = "POST", notes = "registration details")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getRegistrationDetails(@ApiParam(value = "User addition to portal", required = true) RegisterUserTO userRegistration) {
		return Response.ok().entity(userRegistration).build();
	}
}
