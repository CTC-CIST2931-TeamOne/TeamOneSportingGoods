package Beans;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: MailSenderBean.java
* Due: 10.31.2020
* @authors Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
 */

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class MailSenderBean {

    public void sendEmail(String fromEmail, String username, String password,
                          String toEmail, String subject, String message){

        try {
            // INIT properties for smtp usage
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            // setup message type, content and subject
            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);
            // setup transport protocol
            Transport transport = mailSession.getTransport("smtps");
            transport.connect("smtp.gmail.com",username ,password);
            // send email
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

        } catch (MessagingException ex) {

            Logger.getLogger(MailSenderBean.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
