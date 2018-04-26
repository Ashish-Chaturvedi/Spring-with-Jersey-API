package com.fuseIn.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


@Api(value="/helloworld")
@Path("/helloworld")
public class HelloWorld {

	@GET
	@ApiOperation(value = "Get specific admin", httpMethod = "GET", notes = "Fetch the admin user details")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello World RESTful Jersey!";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
				+ "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + "Hello World RESTful Jersey"
				+ "</body></h1>" + "</html> ";
	}

}
