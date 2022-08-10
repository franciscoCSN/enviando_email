package enviando_email.enviando_email;

import org.junit.jupiter.api.Test;
import java.net.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.PasswordAuthentication;
import java.security.Security;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class AppTest {
	private String mailhost = "smtp.live.com";
	private String userName = "javajdev3@gmail.com";
	private String senha= "smmgulbskeaqmygm";
	
	@Test
	public void testeEmail(){
		try {
			
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl", "*");
		properties.put("mail.smtp.auth", "true");/*Autorização*/
		properties.put("mail.smtp.starttls", "true"); /*Autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com"); /*Sercidor gmail Google*/
		properties.put("mail.smtp.port", "465");/*Porta do servidor*/
		properties.put("mail.smtp.socketFactory.port", "465");/*Expecifica a porta a ser conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(userName, senha);
			}
		});
		
		
		Address[] toUser = InternetAddress.parse("fesoalll9@hotmail.com, fesoalll3@gmail.com");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName,"Test de envio")); /*Quem está enviano*/
		message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
		message.setSubject("Chegou e-mail enviado com java");/*Assunto do e-mail*/
		message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java do curso Formação Java Web do Alex");
		
		
		Transport.send(message);
		System.out.println("email enviado.");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
