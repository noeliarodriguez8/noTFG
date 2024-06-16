package com.memeov1.memeov1.requests;

import java.util.List;

import com.memeov1.memeov1.entities.DirectMessage;
import com.memeov1.memeov1.entities.User;

public class ConversationRequest {

    public Integer starterUserID;
    public Integer receiverUserID;
    public Integer conversationID;
    public List<DirectMessage> directMessages;
    public List<User> users;

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

    public List<DirectMessage> getDirectMessages() {
        return directMessages;
    }

    public void setDirectMessages(List<DirectMessage> directMessages) {
        this.directMessages = directMessages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
