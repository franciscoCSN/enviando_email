package enviando_email.enviando_email;

import enviando_email.myclasses.MailSender;

public class App {
  public static void main(String[] args) throws Exception {
	  
	  MailSender mailsender = new MailSender("fesoa...hotmail.com,fesoa...@gmail.com"
											  ,"fesoalll fradetu", "Test de aplicação 8 "
											  ,"<span style=\"color:green;\"><b><h2>Este email foi enviado auomaticamente.</h2></b></span><br>"
											  		+ "<img src=\"https://media-exp2.licdn.com/dms/image/C4E03AQFpP3Ud0FsAmQ/profile-displayphoto-shrink_200_200/0/1554730276124?e=1660780800&v=beta&t=jjlYhdNhvIctzRC24WOsB0f-PGMp1sWS6-uu46oM4fY\">");
	  mailsender.SendMail(true);
	  
	  
    System.out.println("Sended!");
  }
}
