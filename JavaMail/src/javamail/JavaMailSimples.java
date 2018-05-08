package javamail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSimples {

    public static void main(String[] args) {

        Properties loginProperties = new Properties();
        String loginPropertiesFile = "javamail/login.properties";
        
        Properties emailProperties = new Properties();
        String emailPropertiesFile = "javamail/email.properties";

        try {
            InputStream loginFile = ClassLoader.getSystemClassLoader().getResourceAsStream(loginPropertiesFile);
            loginProperties.load(loginFile);
            
            InputStream emailFile = ClassLoader.getSystemClassLoader().getResourceAsStream(emailPropertiesFile);
            emailProperties.load(emailFile);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        String username = loginProperties.getProperty("hotmail.username");
        String password = loginProperties.getProperty("hotmail.password");

        // Iniciando autenticação
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        
        // Iniciando sessão
        Session session = Session.getDefaultInstance(emailProperties, auth);
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("givanaldo@gmail.com"));
            //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("outroemail@gmail.com"));
            message.setSubject("Enviando email com JavaMail via Hotmail");
            String msg = "Enviei este <i>e-mail</i> utilizando <b>JavaMail</b>.";
            message.setContent(msg, "text/html");
            Transport.send(message);
            System.out.println("Mensagem enviada.");
        } catch (MessagingException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

}
