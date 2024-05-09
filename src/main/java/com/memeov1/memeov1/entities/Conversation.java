package com.memeov1.memeov1.entities;

//import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Conversation {

    @EmbeddedId
    public ConversationPK conversationPK;
    // public Integer starterUserID;
    // public Integer receiverUserID;
    // public Integer conversationID;

    @ManyToMany(mappedBy = "conversations")
    public List<User> users;

    public Date created_at;

    @OneToMany(targetEntity = DirectMessage.class)
    public List<DirectMessage> directMessages;

    public Conversation() {

    }

    public Conversation(Date created_at, List<DirectMessage> directMessages) {
        this.created_at = created_at;
        this.directMessages = directMessages;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
