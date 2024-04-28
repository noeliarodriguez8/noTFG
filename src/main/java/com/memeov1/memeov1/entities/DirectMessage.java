package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DirectMessage {
    public @Id @GeneratedValue Integer messageID;
    public Integer conversationID;
    public Integer senderUserID;
    public Integer receiverUserID;
    public Date sent_datetime;
    public String text_content;

    @ManyToOne
    public Conversation conversation;

    DirectMessage(Integer conversationID, Integer senderUserID, Integer receiverUserID, Date sent_datetime,
            String text_content) {
        this.conversationID = conversationID;
        this.senderUserID = senderUserID;
        this.receiverUserID = receiverUserID;
        this.sent_datetime = sent_datetime;
        this.text_content = text_content;
    }

    public Integer getmessageID() {
        return messageID;
    }

    public void setmessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Integer getconversationID() {
        return conversationID;
    }

    public void setconversationID(Integer conversationID) {
        this.conversationID = conversationID;
    }

    public Integer getsenderUserID() {
        return senderUserID;
    }

    public void setsenderUserID(Integer senderUserID) {
        this.senderUserID = senderUserID;
    }

    public Integer getreceiverUserID() {
        return receiverUserID;
    }

    public void setreceiverUserID(Integer receiverUserID) {
        this.receiverUserID = receiverUserID;
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
