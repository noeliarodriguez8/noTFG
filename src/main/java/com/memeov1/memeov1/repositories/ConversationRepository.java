package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    // listar conversaciones
    @SuppressWarnings("null")
    List<Conversation> findAll();

    // buscar conversación por user
    List<Conversation> findConversationsByReceiverUserIDContainsIgnoreCase(String receiverUserID);

}
