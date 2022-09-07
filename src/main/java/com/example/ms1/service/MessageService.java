package com.example.ms1.service;

import com.example.ms1.controller.request.MessageRequest;

import java.util.concurrent.ExecutionException;

public interface MessageService {

    void save(MessageRequest request);

    void start() throws ExecutionException, InterruptedException;

    void stop();
}
