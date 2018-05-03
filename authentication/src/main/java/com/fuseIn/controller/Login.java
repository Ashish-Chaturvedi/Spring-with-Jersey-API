package com.fuseIn.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fuseIn.Iservice.ILogin;
import com.fuseIn.bo.LoginUserBO;
import com.fuseIn.dto.LoginUserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="/Login")
@Path("/login")
public class Login {

		@Autowired
		private ILogin loginUserBo;
		
		@POST
		@ApiOperation(value = "Login details", httpMethod = "POST", notes = "login using email")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response getLoginDetails(@ApiParam(value = "User logging in", required = true) LoginUserDTO loginUserObject) {
			
			LoginUserBO userBo = new LoginUserBO();
			userBo.setEmail(loginUserObject.getEmail());
			userBo.setPassword(loginUserObject.getPassword());
			
			loginUserBo.create(userBo);
			
			return Response.ok().entity(loginUserObject).build();
		}
	
}
