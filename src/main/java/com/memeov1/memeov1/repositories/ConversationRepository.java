package com.memeov1.memeov1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.ConversationPK;

public interface ConversationRepository extends JpaRepository<Conversation, ConversationPK> {
    // listar conversaciones del usuario registrado actualmente
    @Query("SELECT c FROM Conversation c WHERE c.conversationPK.starterUserID = :userID OR c.conversationPK.receiverUserID = :userID")
    List<Conversation> findConversationsByUserID(@Param("userID") Integer userID);

    // buscar conversación por user
    List<Conversation> findConversationsByConversationPKReceiverUserID(Integer receiverUserID);

}
