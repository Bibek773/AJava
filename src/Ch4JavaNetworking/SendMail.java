package Ch4JavaNetworking;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {

        // Mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");                  // Auth required
        props.put("mail.smtp.starttls.enable", "true");       // Enable STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com");        // SMTP server
        props.put("mail.smtp.port", "587");                    // TLS port

        // Create session with authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Your Gmail username and app password here
                return new PasswordAuthentication("a@gmail.com", "your_app_password");
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set From email field
            message.setFrom(new InternetAddress("a@gmail.com"));

            // Set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("t@gmail.com"));

            // Set email subject
            message.setSubject("hello");

            // Set email body text
            message.setText("message");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}