package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.ConversationPK;

public interface ConversationRepository extends JpaRepository<Conversation, ConversationPK> {
    // listar conversaciones
    @SuppressWarnings("null")
    List<Conversation> findAll();

    // buscar conversación por user
    List<Conversation> findConversationsByConversationPKReceiverUserID(Integer receiverUserID);

}
