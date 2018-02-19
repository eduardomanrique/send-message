package com.eduardomanrique.sendmessage.service;

import com.eduardomanrique.sendmessage.entity.Message;

public interface MessageService{

    void send(Message message);

    Iterable<Message> listSent();
}
