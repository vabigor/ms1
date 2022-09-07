package com.example.ms1.controller.request;

import java.util.Date;

public class MessageRequest {

    private Integer id;
    private Integer sessionId;
    private Date ms1Timestamp;
    private Date ms2Timestamp;
    private Date ms3Timestamp;
    private Date endTimestamp;

    public MessageRequest() {
    }

    public Integer getId() {
        return id;
    }

    public MessageRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public MessageRequest setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Date getMs1Timestamp() {
        return ms1Timestamp;
    }

    public MessageRequest setMs1Timestamp(Date ms1Timestamp) {
        this.ms1Timestamp = ms1Timestamp;
        return this;
    }

    public Date getMs2Timestamp() {
        return ms2Timestamp;
    }

    public MessageRequest setMs2Timestamp(Date ms2Timestamp) {
        this.ms2Timestamp = ms2Timestamp;
        return this;
    }

    public Date getMs3Timestamp() {
        return ms3Timestamp;
    }

    public MessageRequest setMs3Timestamp(Date ms3Timestamp) {
        this.ms3Timestamp = ms3Timestamp;
        return this;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public MessageRequest setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
        return this;
    }
}
