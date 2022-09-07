package com.example.ms1.service.impl;

import com.example.ms1.controller.request.MessageRequest;
import com.example.ms1.dao.entity.Message;
import com.example.ms1.dao.service.MessageServiceDao;
import com.example.ms1.dto.MessageDto;
import com.example.ms1.service.MessageService;
import com.example.ms1.web_socket.CustomStompSessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageServiceDao dao;
    private final WebSocketStompClient stompClient;
    private static int sessionId = 0;
    private int countMessage;
    private Instant start;
    private Instant end;
    private ScheduledExecutorService scheduler;
    private List<MessageDto> messages = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${web-socket.url}")
    private String URL;

    @Value("${web-socket.topic}")
    private String TOPIC;

    @Value("${scheduler.period}")
    private int PERIOD;

    @Autowired
    public MessageServiceImpl(MessageServiceDao dao, WebSocketStompClient stompClient) {
        this.dao = dao;
        this.stompClient = stompClient;
    }

    @Override
    public void save(MessageRequest request) {
        dao.save(fillMessage(request));
    }

    @Override
    public void start(){
        countMessage = 0;
        start = Instant.now();
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
            StompSessionHandler sessionHandler = new CustomStompSessionHandler();
            StompSession stompSession = null;
            sessionId++;
            MessageDto message = new MessageDto(sessionId, new Date(), Boolean.FALSE);
            messages.add(message);
            for(MessageDto dto : messages.stream().filter(m->!m.isSent()).collect(Collectors.toList())){
                try {
                    stompSession = stompClient.connect(URL, sessionHandler).get();
                    stompSession.send(TOPIC, dto);
                    dto.setSent(Boolean.TRUE);
                    countMessage++;
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            messages.removeAll(messages.stream().filter(MessageDto::isSent).collect(Collectors.toList()));
        }, 0, PERIOD, TimeUnit.SECONDS);
    }

    @Override
    public void stop() {
        if (scheduler!=null){
            scheduler.shutdown();
            end = Instant.now();
            long min = Duration.between(start, end).getSeconds()/60;
            long sec = Duration.between(start, end).getSeconds()%60;
            logger.info("Время взаимодействия: мин {}, сек {}", min, sec);
            logger.info("Отправлено сообщений: {}", countMessage);
        }
    }

    private Message fillMessage(MessageRequest request){
        return new Message()
                .setSessionId(request.getSessionId())
                .setMs1Timestamp(request.getMs1Timestamp())
                .setMs2Timestamp(request.getMs2Timestamp())
                .setMs3Timestamp(request.getMs3Timestamp())
                .setEndTimestamp(request.getEndTimestamp());
    }
}
