package com.memeov1.memeov1.repositories;

import java.util.List;

import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.DirectMessage;

public interface DMRepository {
    // listar conversaciones
    List<Conversation> getConversations();

    // listar mensajes de x conversación
    List<DirectMessage> findDirectMessagesByConversationIDContainsIgnoreCase(Integer conversation_id);

    // buscar conversación por user
    List<Conversation> findConversationsByUsernameContainsIgnoreCase(String username);

}
