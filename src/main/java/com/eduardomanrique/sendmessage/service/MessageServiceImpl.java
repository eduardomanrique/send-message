package com.eduardomanrique.sendmessage.service;

import com.eduardomanrique.sendmessage.entity.Message;
import com.eduardomanrique.sendmessage.sender.MessageSender;
import com.eduardomanrique.sendmessage.repository.MessageRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Log
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageSender sender;

    @Override
    @Transactional
    public void send(Message message) {
        message.setCreateTime(new Date());
        messageRepository.save(message);
        sender.send(message);
    }

    @Override
    public Iterable<Message> listSent() {
        return messageRepository.findAll();
    }


}
