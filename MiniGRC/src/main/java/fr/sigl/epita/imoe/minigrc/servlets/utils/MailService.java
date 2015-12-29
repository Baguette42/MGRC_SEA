package fr.sigl.epita.imoe.minigrc.servlets.utils;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;


public class MailService {
	
	public static String replaceMailTagsForClient(String mailText, ClientEntity client) {
		
		String mailTextForClient = mailText;
		
		mailTextForClient.replaceAll("<nom>", client.getClientNom());
		mailTextForClient.replaceAll("<prenom>", client.getClientPrenom());
		mailTextForClient.replaceAll("<region>", client.getClientRegion());
		
		
		//Client age calculations
		Date now = new Date();
		Date clientNaissance = client.getClientNaissance();
		int clientAge = now.getYear() - clientNaissance.getYear();
		
		if (now.getMonth() < clientNaissance.getMonth())
			clientAge--;
		else if ((now.getMonth() == clientNaissance.getMonth()) && (now.getDate() < clientNaissance.getDate()))
			clientAge--;
		
		mailTextForClient.replaceAll("<age>", Integer.toString(clientAge));

		//Returning the new string where tags are replaced by client values
		return mailTextForClient;
	}
	
	public static int sendMessageToClients(String mailMessage, List<ClientEntity> clients) {
		
		int sentEmailsCount = 0;
		
		//INITIALISATION
		// Sender's email ID needs to be mentioned
        String from = "seattle.minigrc@gmail.com";
        final String username = "seattle.minigrc@gmail.com";
        final String password = "seattle42";

        // Using gmail
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        // Get the Session object.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
           }
        });
		
		//SENDING 
		for (ClientEntity client : clients) {
			
			String messageToSend = replaceMailTagsForClient(mailMessage, client);
			String to = client.getClientEmail();
			
			try {
		           // Create a default MimeMessage object.
		           Message message = new MimeMessage(session);

		           // Set From: header field of the header.
		           message.setFrom(new InternetAddress(from));

		           // Set To: header field of the header.
		           message.setRecipients(Message.RecipientType.TO,
		           InternetAddress.parse(to));

		           // Set Subject: header field
		           message.setSubject("MiniGRC");

		           // Now set the actual message
		           message.setText(messageToSend);

		           // Send message
		           Transport.send(message);

		           System.out.println("Sent message successfully....");
		           
		           sentEmailsCount++;

		        } catch (MessagingException e) {
			       System.out.println("Sent message successfully....");
		        }
			
		}
		
		return sentEmailsCount;
	}
	
	/***
	 * Function used to test the gmail smtp
	 */
	private static void sendMailTest(){
		 // Recipient's email ID needs to be mentioned.
        String to = "guillaume.moizan@gmail.com";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "seattle.minigrc@gmail.com";
        final String username = "seattle.minigrc@gmail.com";
        final String password = "seattle42";

        // Using gmail
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        // Get the Session object.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
           }
        });

        try {
           // Create a default MimeMessage object.
           Message message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(to));

           // Set Subject: header field
           message.setSubject("Testing Subject");

           // Now set the actual message
           message.setText("Hello, this is sample for to check send "
              + "email using JavaMailAPI ");

           // Send message
           Transport.send(message);

           System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
	}

}
