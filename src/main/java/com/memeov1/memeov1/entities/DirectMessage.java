package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DirectMessage {
    public @Id @GeneratedValue Integer message_id;
    public Integer conversation_id;
    public Integer sender_user_id;
    public Integer receiver_user_id;
    public Date sent_datetime;
    public String text_content;

    DirectMessage(Integer conversation_id, Integer sender_user_id, Integer receiver_user_id, Date sent_datetime,
            String text_content) {
        this.conversation_id = conversation_id;
        this.sender_user_id = sender_user_id;
        this.receiver_user_id = receiver_user_id;
        this.sent_datetime = sent_datetime;
        this.text_content = text_content;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Integer conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Integer getSender_user_id() {
        return sender_user_id;
    }

    public void setSender_user_id(Integer sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public Integer getReceiver_user_id() {
        return receiver_user_id;
    }

    public void setReceiver_user_id(Integer receiver_user_id) {
        this.receiver_user_id = receiver_user_id;
    }

    public Date getSent_datetime() {
        return sent_datetime;
    }

    public void setSent_datetime(Date sent_datetime) {
        this.sent_datetime = sent_datetime;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

}
