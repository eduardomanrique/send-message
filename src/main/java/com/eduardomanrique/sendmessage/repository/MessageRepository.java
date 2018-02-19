package com.eduardomanrique.sendmessage.repository;

import com.eduardomanrique.sendmessage.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
}
