package com.eduardomanrique.sendmessage.sender.implementations;

import com.eduardomanrique.sendmessage.entity.SmsMessage;
import com.eduardomanrique.sendmessage.sender.Sender;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class SmsMessageSender implements Sender<SmsMessage> {

    @Override
    public void send(SmsMessage message) {
        log.info("==============");
        log.info("Sending SMS");
        log.info("  from: " + message.getFrom());
        log.info("  to: " + message.getTo());
        log.info("  title: " + message.getText());
        log.info("==============");
    }
}
