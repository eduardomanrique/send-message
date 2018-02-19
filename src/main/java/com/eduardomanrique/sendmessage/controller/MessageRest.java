package com.eduardomanrique.sendmessage.controller;

import com.eduardomanrique.sendmessage.entity.Message;
import com.eduardomanrique.sendmessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageRest {

    @Autowired
    private MessageService service;

    @PostMapping("/send")
    @ResponseStatus(value = HttpStatus.OK)
    public void send(@RequestBody Message message) {
        service.send(message);
    }

    @GetMapping("/list")
    public Iterable<Message> list() {
        return service.listSent();
    }
}
