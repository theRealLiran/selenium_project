package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;

public class JavaMailUtils {

    public JavaMailUtils(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private final String username;
    private final String password;


    private Session setUpSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public void sendMail(String from, String to, String subject, String body) {
        try {

            Message message = new MimeMessage(setUpSession());
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void retrieveEmailFromGmail() throws MessagingException {
        Store store = setUpSession().getStore("imaps");
        store.connect("smtp.gmail.com", username, password);
        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        System.out.println("------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println("Mail from: " + Arrays.toString(messages[i].getFrom()));
        }

        inbox.close(false);
        store.close();
    }


}
