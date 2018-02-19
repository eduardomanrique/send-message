package com.eduardomanrique.sendmessage.sender;

import com.eduardomanrique.sendmessage.entity.Message;

public interface Sender<T extends Message>{

    void send(T message);
}
