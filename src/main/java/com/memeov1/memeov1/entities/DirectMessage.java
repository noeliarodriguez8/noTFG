package com.memeov1.memeov1.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
public class DirectMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer messageID;

    @ManyToOne(targetEntity = Conversation.class)
    @JoinColumns({
            @JoinColumn(name = "conversationID", referencedColumnName = "conversationID"),
            @JoinColumn(name = "starterUserID", referencedColumnName = "starterUserID"),
            @JoinColumn(name = "receiverUserID", referencedColumnName = "receiverUserID")
    })
    public Conversation conversation;
    // public Integer conversationID;

    @ManyToOne(targetEntity = User.class)
    public User senderUser;

    public Date sent_datetime;
    public String text_content;

    public DirectMessage() {

    }

    public DirectMessage(Date sent_datetime, String text_content) {
        // this.conversationID = conversationID;
        // this.senderUserID = senderUserID;
        // this.receiverUserID = receiverUserID;
        this.sent_datetime = sent_datetime;
        this.text_content = text_content;
    }

    public Integer getmessageID() {
        return messageID;
    }

    public void setmessageID(Integer messageID) {
        this.messageID = messageID;
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
