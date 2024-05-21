package com.memeov1.memeov1.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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

    @ManyToOne(targetEntity = User.class)
    public User senderUser;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date sent_datetime;

    public String text_content;

    public DirectMessage() {

    }

    public DirectMessage(Date sent_datetime, String text_content) {
        this.sent_datetime = sent_datetime;
        this.text_content = text_content;
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

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

}
