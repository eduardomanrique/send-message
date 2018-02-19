package com.eduardomanrique.sendmessage.sender.implementations;

import com.eduardomanrique.sendmessage.entity.EmailMessage;
import com.eduardomanrique.sendmessage.sender.Sender;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class EmailMessageSender implements Sender<EmailMessage> {

    @Override
    public void send(EmailMessage message) {
        log.info("==============");
        log.info("Sending email");
        log.info("  from: " + message.getFrom());
        log.info("  to: " + message.getTo());
        log.info("  title: " + message.getTitle());
        log.info("  message: " + message.getBody());
        log.info("==============");
    }
}
