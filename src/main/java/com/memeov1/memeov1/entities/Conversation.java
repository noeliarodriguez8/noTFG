package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Conversation {

    public @Id @GeneratedValue Integer conversationID;
    public String starterUserID;
    public String receiverUserID;
    public Date created_at;

    @OneToMany
    public List<DirectMessage> messages;

    Conversation(Integer conversationID, String starterUserID, String receiverUserID, Date created_at,
            List<DirectMessage> messages) {
        this.conversationID = conversationID;
        this.starterUserID = starterUserID;
        this.receiverUserID = receiverUserID;
        this.created_at = created_at;
        this.messages = messages;
    }

    public Integer getconversationID() {
        return conversationID;
    }

    public void setconversationID(Integer conversationID) {
        this.conversationID = conversationID;
    }

    public String getstarterUserID() {
        return starterUserID;
    }

    public void setstarterUserID(String starterUserID) {
        this.starterUserID = starterUserID;
    }

    public String getreceiverUserID() {
        return receiverUserID;
    }

    public void setreceiverUserID(String receiverUserID) {
        this.receiverUserID = receiverUserID;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
