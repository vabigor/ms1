package com.example.ms1.dao.service.impl;

import com.example.ms1.dao.entity.Message;
import com.example.ms1.dao.repository.MessageRepository;
import com.example.ms1.dao.service.MessageServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceDaoImpl implements MessageServiceDao {

    private final MessageRepository repository;

    @Autowired
    public MessageServiceDaoImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }
}
