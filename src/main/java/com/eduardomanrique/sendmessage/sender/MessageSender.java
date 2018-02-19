package com.eduardomanrique.sendmessage.sender;

import com.eduardomanrique.sendmessage.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageSender {

    @Autowired
    private Map<String, Sender> senderMap;

    public void send(Message message) {
        senderMap.get(getComponentName(message)).send(message);
    }

    private String getComponentName(Message message) {
        return message.getClass().getSimpleName().substring(0, 1).toLowerCase() +
                message.getClass().getSimpleName().substring(1) + "Sender";
    }


}
