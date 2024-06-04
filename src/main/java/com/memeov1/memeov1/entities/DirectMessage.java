package com.memeov1.memeov1.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "direct_message")
public class DirectMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageID", nullable = false)
    public Integer messageID;

    @JsonIgnoreProperties(value = "directMessages", allowSetters = true)
    @ManyToOne(targetEntity = Conversation.class, optional = false)
    @JoinColumns({
            @JoinColumn(name = "conversationID", referencedColumnName = "conversationID", nullable = false),
            @JoinColumn(name = "starterUserID", referencedColumnName = "starterUserID"),
            @JoinColumn(name = "receiverUserID", referencedColumnName = "receiverUserID")
    })
    public Conversation conversation;

    @JsonIgnoreProperties(value = { "name", "surname", "email", "login", "avatar", "signup_date", "birth_date",
            "followers", "following", "comments", "memeLikes", "posts", "conversations",
            "directMessages" }, allowSetters = true)
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    public User senderUser;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date sent_datetime;

    public String text_content;

    public DirectMessage() {

    }

    public DirectMessage(String text_content) {
        this.sent_datetime = new Date();
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
