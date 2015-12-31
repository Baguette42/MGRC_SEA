package fr.sigl.epita.imoe.minigrc.servlets.utils;

import fr.sigl.epita.imoe.minigrc.beans.ClientEntity;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailService {

    /**
     * Remplace les tags par les informations du clients
     *
     * @param mailText     Le message avec les tags
     * @param client       Le client auquel envoyer le mail
     * @param result       Les résultats de l'envoi du mail
     * @return Le message à envoyer au client
     */
    public static String replaceMailTagsForClient(String mailText, ClientEntity client, MailResult result) {

        String mailTextForClient = mailText;

        //Replacing <nom>
        if (client.getClientNom() != null && !client.getClientNom().equals(""))
        	mailTextForClient = mailTextForClient.replaceAll("<nom>", client.getClientNom());
        else
        	result.setMissingDataCount(result.getMissingDataCount() + 1);

        //Replacing <prenom>
        if (client.getClientPrenom() != null && !client.getClientPrenom().equals(""))
        	mailTextForClient = mailTextForClient.replaceAll("<prenom>", client.getClientPrenom());
        else
        	result.setMissingDataCount(result.getMissingDataCount() + 1);
        
        //Replacing <region>
        if (client.getClientRegion() != null && !client.getClientRegion().equals(""))
        	mailTextForClient = mailTextForClient.replaceAll("<region>", client.getClientRegion());
        else
        	result.setMissingDataCount(result.getMissingDataCount() + 1);


        //Client age calculations
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(client.getClientNaissance());
        Calendar today = Calendar.getInstance();
        int clientAge = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < calendar.get(Calendar.MONTH)) {
            clientAge--;
        } else if (today.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH)) {
            clientAge--;
        }

        mailTextForClient.replaceAll("<age>", Integer.toString(clientAge));

        //Returning the new string where tags are replaced by client values
        return mailTextForClient;
    }

    /**
     * Envoi un message aux clients
     *
     * @param mailMessage   Le message à envoyer
     * @param clients       La liste des clients auquels envoyer le message
     * @return Le résultat de l'envoi des messages auc clients
     */
    public static MailResult sendMessageToClients(String mailMessage, List<ClientEntity> clients) {

        MailResult result = new MailResult(0, 0, 0);
        int sentEmailsCount = 0;
        int invalidEmailCount = 0;

        //INITIALISATION
        // Sender's email ID needs to be mentioned
        String from = "seattle.minigrc@gmail.com";
        final String username = "seattle.minigrc@gmail.com";
        final String password = "seattle42";

        // Using gmail
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        //SENDING
        for (ClientEntity client : clients) {

            String messageToSend = replaceMailTagsForClient(mailMessage, client, result);
            String to = client.getClientEmail();

            try {
                // Create a default MimeMessage object.
                Message message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));

                // Set Subject: header field
                message.setSubject("MiniGRC");

                // Now set the actual message
                message.setText(messageToSend);

                // Send message
                Transport.send(message);

                System.out.println("Sent message successfully....");

                sentEmailsCount++;

            } catch (MessagingException e) {
                invalidEmailCount++;
                System.out.println("Sent not message successfully....");
            }

        }

        result.setSentMailsCount(sentEmailsCount);
        result.setInvalidEmailCount(invalidEmailCount);

        return result;
    }
}
