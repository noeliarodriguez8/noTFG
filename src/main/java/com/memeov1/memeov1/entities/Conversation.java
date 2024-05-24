package com.memeov1.memeov1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "conversation")
public class Conversation {

    @EmbeddedId
    public ConversationPK conversationPK;

    @ManyToMany(mappedBy = "conversations")
    public List<User> users = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date created_at;

    @OneToMany(targetEntity = DirectMessage.class, mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<DirectMessage> directMessages;

    public Conversation() {

    }

    // al usar el constructor solo con la conversationPK
    // en la creación de dms al pasarle el json creaba una conversation nueva porque
    // accedía a ese constructor (?)
    // cuando ponías el conversationID de una que ya existía daba error
    public Conversation(ConversationPK conversationPK, List<DirectMessage> directMessages) {
        this.conversationPK = conversationPK;
        this.directMessages = directMessages;
        this.created_at = new Date();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public ConversationPK getConversationPK() {
        return conversationPK;
    }

    public void setConversationPK(ConversationPK conversationPK) {
        this.conversationPK = conversationPK;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("La lista de usuarios no puede ser nula");
        }
        this.users = users;
    }

    public List<DirectMessage> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }

}
