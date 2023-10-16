package mail;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class sendemail {
	public sendemail(String x,String y)
	{
		final String Senderemail="harishreddy7486@gmail.com";
		final String password="kstdympjqbkgsaey";
		Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587");
        Session session=Session.getInstance(props, new javax.mail. Authenticator(){
        	protected PasswordAuthentication getPasswordAuthentication() { 
       return new PasswordAuthentication (Senderemail,password);
		
	         }
        });
        try {
        	System.out.print("mail started");
        	Message message = new MimeMessage(session); 
        	message.setFrom(new InternetAddress("harishreddy7486@gmail.com"));
        	message.setRecipients (Message. RecipientType.TO, InternetAddress.parse(y));
        	message.setSubject("Ticket confirmation");
        	message.setText(x);
        	Transport.send(message);
        	System.out.println("Done");
        	} catch (MessagingException e) 
        		{ 
        		throw new RuntimeException(e);

        	}

        	}

   
}


