package com.example.ms1.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "session_id")
    private Integer sessionId;

    @NotNull
    @Column(name = "ms1_timestamp")
    private Date ms1Timestamp;

    @NotNull
    @Column(name = "ms2_timestamp")
    private Date ms2Timestamp;

    @NotNull
    @Column(name = "ms3_timestamp")
    private Date ms3Timestamp;

    @NotNull
    @Column(name = "end_timestamp")
    private Date endTimestamp;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public Message setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Date getMs1Timestamp() {
        return ms1Timestamp;
    }

    public Message setMs1Timestamp(Date ms1Timestamp) {
        this.ms1Timestamp = ms1Timestamp;
        return this;
    }

    public Date getMs2Timestamp() {
        return ms2Timestamp;
    }

    public Message setMs2Timestamp(Date ms2Timestamp) {
        this.ms2Timestamp = ms2Timestamp;
        return this;
    }

    public Date getMs3Timestamp() {
        return ms3Timestamp;
    }

    public Message setMs3Timestamp(Date ms3Timestamp) {
        this.ms3Timestamp = ms3Timestamp;
        return this;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public Message setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", ms1Timestamp=" + ms1Timestamp +
                ", ms2Timestamp=" + ms2Timestamp +
                ", ms3Timestamp=" + ms3Timestamp +
                ", endTimestamp=" + endTimestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(sessionId, message.sessionId) && Objects.equals(ms1Timestamp, message.ms1Timestamp) && Objects.equals(ms2Timestamp, message.ms2Timestamp) && Objects.equals(ms3Timestamp, message.ms3Timestamp) && Objects.equals(endTimestamp, message.endTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId, ms1Timestamp, ms2Timestamp, ms3Timestamp, endTimestamp);
    }
}
