package com.fuseIn.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


@Api(value="/Registration")
@Path("/register")
public class Registration {

	@POST
	@ApiOperation(value = "Submit registration details", httpMethod = "POST", notes = "registration details")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}
}
