package com.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.mail.model.MailModel;
import com.mail.service.MailService;

@Path("mail")
public class ChatRest {
	
	@Autowired
	private MailService mailService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response test(@QueryParam("sub") String sub,@QueryParam("msg") String message){
		
		MailModel mail = new MailModel();
		
		mail.setFrom("kpggopal@gmail.com");
		mail.setReceiver("kpgsamy@gmail.com");
		mail.setSub(sub);
		mail.setMessage(message);
		
		mailService.sendVelocityMail(mail);
		
		return Response.ok().build();
	}
	
	
	

}
