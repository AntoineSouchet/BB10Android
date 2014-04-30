package fr.bb.android;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;

import org.junit.Test;

import fr.bb.android.util.Mail;

public class MailTest {

	@Test
	public void test01() throws NoSuchProviderException, MessagingException, IOException
	{
		Mail mail = new Mail();
		mail.connect("auth.smtp.1and1.fr", "contacts@bbloveandroid.com", "Kikoo2031");
		String email = "antoine.souchet@securitasdirect.fr";
		String login = "Antoine";
		int retour = 1;
		mail.send("contacts@bbloveandroid.com", email, "Validez votre compte BBLoveAndroid !", "<html><head>"
				+ "<link rel=\"stylesheet\" href=\"resources/bootstrap-3.1.1/css/bootstrap.min.css\" type=\"text/css\" />"
				+ "<link rel=\"stylesheet\" href=\"resources/bootstrap-3.1.1/css/bootstrap-theme.min.css\" type=\"text/css\" />"
				+ "<style type=\"text/css\">a:link{text-decoration:none}</style>"
				+ "</head>"
				+ "<body style=background-color:#295e92;color:white;a:link{text-decoration:none}>"
//				+ "<div style=width:100%;height:100%;background-color:#295e92;color:white;font-family: \"trebuchet ms\", sans-serif;>"
				+ "<center><img src=\"resources/img/MyBBLOVE.png\"></center><br />"
				+ "Bonjour " + login + ", vous venez de cr&eacute;er un compte sur BBLoveAndroid.<br />"
				+ "Afin de valider votre compter merci de cliquez sur le lien ci-dessous.<br />"
				+ "<center><a href=http://localhost:8080/android/ValidComte.sd?id="+ retour+"&user=" +login + " style=a:link{text-decoration:none}>"
				+ "Valider mon compte</a></center><br/><br />"
				+ "Ceci est un mail automatique merci de ne pas r&eacutepondre.</div>", "");
	}
}
