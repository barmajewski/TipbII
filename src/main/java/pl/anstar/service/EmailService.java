package pl.anstar.service;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessage(String to, String subject, String text) throws MessagingException;
}