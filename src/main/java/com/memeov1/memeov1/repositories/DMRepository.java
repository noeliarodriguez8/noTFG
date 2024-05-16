package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.DirectMessage;

public interface DMRepository extends JpaRepository<DirectMessage, Integer> {

    // listar mensajes de x conversación
    List<DirectMessage> findDirectMessagesByConversationConversationPKConversationID(Integer conversationID);

    // encontrar dm por ID
    public DirectMessage findByMessageID(Integer messageID);
}
