package com.memeov1.memeov1.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Embeddable
public class ConversationPK implements Serializable {

    @Column(name = "starterUserID")
    public Integer starterUserID;

    @Column(name = "receiverUserID")
    public Integer receiverUserID;

    @Column(name = "conversationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer conversationID;

    public ConversationPK() {

    }

    public ConversationPK(Integer starterUserID, Integer receiverUserID, Integer conversationID) {
        this.starterUserID = starterUserID;
        this.receiverUserID = receiverUserID;
        this.conversationID = conversationID;
    }

    public Integer getStarterUserID() {
        return starterUserID;
    }

    public void setStarterUserID(Integer starterUserID) {
        this.starterUserID = starterUserID;
    }

    public Integer getReceiverUserID() {
        return receiverUserID;
    }

    public void setReceiverUserID(Integer receiverUserID) {
        this.receiverUserID = receiverUserID;
    }

    public Integer getConversationID() {
        return conversationID;
    }

    public void setConversationID(Integer conversationID) {
        this.conversationID = conversationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ConversationPK that = (ConversationPK) o;
        return Objects.equals(starterUserID, that.starterUserID) &&
                Objects.equals(receiverUserID, that.receiverUserID) &&
                Objects.equals(conversationID, that.conversationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(starterUserID, receiverUserID, conversationID);
    }

}
