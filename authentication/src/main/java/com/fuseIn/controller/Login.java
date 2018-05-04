package com.fuseIn.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuseIn.Iservice.ILogin;
import com.fuseIn.bo.LoginBO;
import com.fuseIn.dto.LoginDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/Login")
@Path(Login.LOGIN_PATH)
public class Login {
	
	protected static final String LOGIN_PATH = "/login";

	@Autowired
	private ILogin loginUserBo;

	@POST
	@ApiOperation(value = "Login details", httpMethod = "POST", notes = "login using email")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLoginDetails(
			@ApiParam(value = "User logging in", required = true) LoginDTO loginUserObject) {

		LoginBO userBo = new LoginBO();
		userBo.setEmail(loginUserObject.getEmail());
		userBo.setPassword(loginUserObject.getPassword());

		loginUserBo.create(userBo);

		return Response.ok().entity(loginUserObject).build();
	}

}
