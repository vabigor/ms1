package com.example.ms1.dto;

import java.util.Date;

public class MessageDto {

    private Integer id;
    private Integer sessionId;
    private Date ms1Timestamp;
    private Date ms2Timestamp;
    private Date ms3Timestamp;
    private Date endTimestamp;

    public MessageDto() {
    }

    public MessageDto(Integer sessionId, Date ms1Timestamp) {
        this.sessionId = sessionId;
        this.ms1Timestamp = ms1Timestamp;
    }

    public Integer getId() {
        return id;
    }

    public MessageDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public MessageDto setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Date getMs1Timestamp() {
        return ms1Timestamp;
    }

    public MessageDto setMs1Timestamp(Date ms1Timestamp) {
        this.ms1Timestamp = ms1Timestamp;
        return this;
    }

    public Date getMs2Timestamp() {
        return ms2Timestamp;
    }

    public MessageDto setMs2Timestamp(Date ms2Timestamp) {
        this.ms2Timestamp = ms2Timestamp;
        return this;
    }

    public Date getMs3Timestamp() {
        return ms3Timestamp;
    }

    public MessageDto setMs3Timestamp(Date ms3Timestamp) {
        this.ms3Timestamp = ms3Timestamp;
        return this;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public MessageDto setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
        return this;
    }
}
