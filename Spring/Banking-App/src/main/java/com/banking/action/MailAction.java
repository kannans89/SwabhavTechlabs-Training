package com.banking.action;

import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.EmailService;
import com.opensymphony.xwork2.ActionSupport;

public class MailAction extends ActionSupport {
	private EmailService emailService = null;
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEmailService(EmailService service) {
		this.emailService = service;
	}

	public String execute() throws MessagingException, IOException {
		String email = ServletActionContext.getRequest().getParameter("rEmail");
		System.out.println("Registered email " + email);
		Multipart multipart = new MimeMultipart();
		BodyPart headingPart = new MimeBodyPart();
		
		headingPart.setContent("<h4>This is confirmation email from our side.</h4>", "text/html");
		
		BodyPart htmlPart = new MimeBodyPart();
		String url = "http://localhost:8080/Banking-App/activateaccount?email="+email;
		String html = "Plese click the following link to activate your account \n <a href="+url+">Click here to activate your account</a>";
		System.out.println("url "+url);
		System.out.println("html "+html);
		htmlPart.setContent(html, "text/html");
		
		MimeBodyPart imagePart = new MimeBodyPart();

		//imagePart.attachFile("/resource/margo1.png");

		
		multipart.addBodyPart(headingPart);
		//multipart.addBodyPart(imagePart);
		multipart.addBodyPart(htmlPart);
		
		emailService.sendActivationLink("manojb912@gmail.com", "3451682634516826", email, "Activation link",
				multipart);
				
		return SUCCESS;
	}
}
