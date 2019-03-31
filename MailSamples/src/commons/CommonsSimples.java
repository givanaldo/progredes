package commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class CommonsSimples {

    public static void main(String[] args) {

        Properties login = new Properties();
        String properties = "javamail/login.properties";
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(properties);
            login.load(stream);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        String username = login.getProperty("hotmail.username");
        String password = login.getProperty("hotmail.password");

        try {
            System.out.println("Enviando e-mail...");
            Email email = new HtmlEmail();
            email.setHostName("smtp.live.com");
            email.setSmtpPort(587);
            email.setStartTLSRequired(true);
            email.setAuthenticator(new DefaultAuthenticator(username, password));
            email.setFrom(username);
            email.setSubject("Enviando e-mail com Apache Commons-email");
            
            String msg = "E-mail enviado a partir do <i>Apache Commons-email</i>." +
                    "<br /><p>Testando o envio de e-mail de HTML</p>" +
                    "<br /><h1>Porta 587 Liberada</h1>";
            
            email.setMsg(msg);
            email.addTo("givanaldo@gmail.com");
            email.setDebug(true);
            email.send();
            System.out.println("Mensagem enviada.");
        } catch (EmailException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
