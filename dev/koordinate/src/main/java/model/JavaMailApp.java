/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author eduar
 */
public class JavaMailApp {

    public void enviarEmail(ArrayList<String> array, Docente docente) {

        String destinatarios = configDestinatarios(array);
        
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("eduardoamaral66@gmail.com", "Dragon1010");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("eduardoamaral66@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatarios);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("KOORDINATE");//Assunto
            message.setText("Olá, o docente "+docente.getNome()+" gostaria de informar à todos que concluiu o planejamento referente ao seu curso. \n\nEste é um email automático, por favor não responda a este email.");
            /**
             * Método para enviar a mensagem criada
             */
            Transport transport = session.getTransport("smtps");
            transport.connect("smtp.gmail.com", 465, "eduardoamaral66@gmail.com", "dragon1010");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public String configDestinatarios(ArrayList<String> array){
        String destinatarios = "";
        
        for (String array1 : array) {
            destinatarios += array1;
        }
        return destinatarios;
    }
}
