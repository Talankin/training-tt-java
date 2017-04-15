/**
 *  26.03.2017
 *  Dmitry Talankin
 */

package com.dtalankin.threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class TransportTask814 {
    public void sendToFile(MessageTask814 message) {
        String outPutText = "From: " + message.getSender() + "\n";
        outPutText += "To: " + message.getEmailAddress() + "\n";
        outPutText += "Subj: " + message.getSubject() + "\n";
        outPutText += "Body: " + message.getBody() + "\n";
        String file = "src/test/resources/com/dtalankin/Lesson8/output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file),true))) {
            bw.write(outPutText);
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("I'm in the transport");
    }

    public void sendToSmtpSSL(MessageTask814 message) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.user", "kilo.vatt@mail.ru");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, null);

//        Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.host", "smtp.gmail.com");
////        props.put("mail.smtp.socketFactory.port", "587");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "587");
////        props.put("mail.smtp.port", "465");
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.debug", "true");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
////                        return new PasswordAuthentication("dtalankin","Rototuy!!");
//                        return new PasswordAuthentication("d.talankin@gmail.com","Topograf!)");
//                    }
//                });



//        Properties props = new Properties();
////        props.setProperty("mail.smtp.**ssl.enable", "true");
////        props.setProperty("mail.smtp.**ssl.required", "true");
//        props.setProperty ("mail.transport.protocol", "smtps");
//        props.put("mail.smtps.host", "smtp.mail.ru");
////        props.put("mail.smtps.socketFactory.port", "587");
//        props.put("mail.smtps.socketFactory.port", "465");
//        props.put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtps.auth", "true");
//        props.put("mail.smtps.port", "587");
////        props.put("mail.smtps.port", "465");
//        props.put("mail.smtps.ssl.enable", "true");
////        props.setProperty("mail.smtps.starttls.enable", "true");
////        props.put("mail.smtps.connectiontimeout", "30000");
////        props.put("mail.smtps.timeout", "30000");
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("kilo.vatt@mail.ru","tds5137");
//                    }
//                });

        try {
            System.out.println("Sending a message to " + message.getEmailAddress() + " ...");
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("kilo.vatt@mail.ru");
            msg.setRecipients(Message.RecipientType.TO, "kilo.vatt@mail.ru");
//            msg.setRecipients(Message.RecipientType.TO, message.getEmailAddress());
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody() + "\n");

            session.setDebug(true);
//            Transport transport = session.getTransport("smtps");
//            transport.connect();
//            Transport.send(msg);
            Transport.send(msg);
//            Transport.send(msg,"d.talankin@gmail.com","Topograf!)");
//            Transport.send(msg, "me@example.com", "my-password");
//            transport.close();
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
        System.out.println("Message has been sent");
    }

}
