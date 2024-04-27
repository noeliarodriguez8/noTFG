package com.memeov1.memeov1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class Conversation {

    public @Id @GeneratedValue Integer conversation_id;
    public String starter_user_id;
    public String receiver_user_id;
    public Date created_at;

    Conversation(Integer conversation_id, String starter_user_id, String receiver_user_id, Date created_at) {
        this.conversation_id = conversation_id;
        this.starter_user_id = starter_user_id;
        this.receiver_user_id = receiver_user_id;
        this.created_at = created_at;
    }

    public Integer getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Integer conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getStarter_user_id() {
        return starter_user_id;
    }

    public void setStarter_user_id(String starter_user_id) {
        this.starter_user_id = starter_user_id;
    }

    public String getReceiver_user_id() {
        return receiver_user_id;
    }

    public void setReceiver_user_id(String receiver_user_id) {
        this.receiver_user_id = receiver_user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
