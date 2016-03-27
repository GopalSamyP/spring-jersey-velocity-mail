package com.mail.service;

import com.mail.model.MailModel;

public interface MailService {

	public void sendMail(MailModel mail);
	
	public void sendVelocityMail(MailModel mail);
}
