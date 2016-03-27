package com.mail.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mail.model.MailModel;
import com.mail.service.MailService;

@Service
public class MailServiceImpl implements MailService {

//	@Autowired
//	private MailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public static final String sender = "testing1991t@gmail.com";
	
	@Override
	public void sendMail(MailModel mailInfo) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		try{
			
			mail.setFrom(sender);
			mail.setTo(mailInfo.getReceiver());
			mail.setSubject(mailInfo.getSub());
			mail.setText(mailInfo.getMessage());
			mail.setSentDate(new Date());
			
//			mailSender.send(mail);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void sendVelocityMail(final MailModel mail) {
		
		try{
			
			MimeMessagePreparator prepMessage = new MimeMessagePreparator() {
				
				@Override
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage message) throws Exception {
					
					MimeMessageHelper mimeMessage = new MimeMessageHelper(message);
					
					mimeMessage.setFrom(sender);
					mimeMessage.setTo( new InternetAddress(mail.getReceiver()));
					mimeMessage.setSubject(mail.getSub());
					
					mimeMessage.setSentDate(new Date());
					
					Map model = new HashMap();	             
		            model.put("message", "its done!!");
		            
		            String text = VelocityEngineUtils.mergeTemplateIntoString(
		            		velocityEngine, "mail/mailTemplate.vm", "UTF-8", model);
		            mimeMessage.setText(text,true);
				}
			};
			
			this.javaMailSender.send(prepMessage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
