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

    // buscar conversación por user
    // CAMBIAR
    // necesitamos buscar por contains username
    // creamos un método en user que nos sirva para encontrar ids por username
    public List<Conversation> findConversationsByConversationPKReceiverUserIDIn(List<Integer> receiverUserIDs);

    // para hacerlo solo en un método
    // @Query("SELECT c FROM Conversation c JOIN c.users u WHERE u.username LIKE
    // %:username% AND c.conversationPK.receiverUserID = u.userID")
    // List<Conversation> findByReceiverUsernameContains(String username);
    // no uso este método porque necesito primero coger los ids de los users para
    // luego dárselo al método de encontrar conversaciones por id de receiverUSer

    // borrar conversation por conversationpk
    public String deleteByConversationPKConversationID(Integer conversationID);

    // encontrar conversation por conversationID
    // para el delete
    public Conversation findConversationByConversationPKConversationID(Integer conversationID);

    // encontrar último id de las conversations
    @Query("SELECT MAX(c.conversationPK.conversationID) FROM Conversation c")
    public Integer findLastConversationID();

}
