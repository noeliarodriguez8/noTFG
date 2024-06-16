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
    public List<Conversation> findConversationsByUserID(@Param("userID") Integer userID);

    // buscar conversación por receiverUserID
    public List<Conversation> findConversationsByConversationPKReceiverUserIDIn(List<Integer> receiverUserIDs);

    // borrar conversation por conversationpk
    public String deleteByConversationPKConversationID(Integer conversationID);

    // encontrar conversation por conversationID
    public Conversation findConversationByConversationPKConversationID(Integer conversationID);

    // encontrar último id de las conversations
    @Query("SELECT MAX(c.conversationPK.conversationID) FROM Conversation c")
    public Integer findLastConversationID();

}
