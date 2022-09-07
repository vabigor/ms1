package com.example.ms1.controller;

import com.example.ms1.controller.request.MessageRequest;
import com.example.ms1.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
public class MessageController {

    private final MessageService service;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping(value = "/start")
    public void start() throws ExecutionException, InterruptedException {
        service.start();
        logger.info("MS1 started: {}", Instant.now());
    }

    @GetMapping(value = "/stop")
    public void stop(){
        service.stop();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody MessageRequest request){
        logger.info("MS1 received message");
        request.setEndTimestamp(new Date());
        service.save(request);
    }
}
