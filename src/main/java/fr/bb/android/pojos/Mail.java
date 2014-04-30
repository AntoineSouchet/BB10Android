package fr.bb.android.pojos;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	
	 private Session session = null;
	    private Transport transport = null;


	    public void connect(String host, String user, String password) throws NoSuchProviderException, MessagingException {
	        Properties properties = new Properties();
	        properties.setProperty("mail.transport.protocol", "smtp");
	        properties.put("mail.smtp.auth", "true");
	        this.session = Session.getDefaultInstance(properties, null);
	        this.transport = this.session.getTransport();
	        this.transport.connect(host, user, password);
	    }

	    public void send(String from, String to, String subject, String body,String file) throws MessagingException, IOException {
	        MimeMessage message = new MimeMessage(this.session);
	        message.setSubject(subject);
	        message.setContent(body, "text/html");
	        message.addRecipient(Message.RecipientType.TO,  new InternetAddress(to));
	        message.setFrom(new InternetAddress(from));
		    // Partie 1: Le texte
		    MimeBodyPart mbp1 = new MimeBodyPart();
		    //mbp1.setText(body);
		    mbp1.setContent(body,"text/html");
		    
		    MimeMultipart mp = new MimeMultipart();
		    mp.addBodyPart(mbp1);
		    message.setContent(mp);
		    
	        this.transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	    }
	    
	    public void SendSimple() throws MessagingException
	    {
	    	MimeMessage message = new MimeMessage(this.session);
	        message.setSubject("ok");
	        message.setContent("ok", "text/html");
	        message.addRecipient(Message.RecipientType.TO,  new InternetAddress("antoine.souchet@securitasdirect.fr"));
	        message.setFrom(new InternetAddress("antoine.souchet@securitasdirect.fr"));
	    	this.transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	    }
	    public void close()  throws MessagingException
	    {
	    	this.transport.close();
	    }

}