package com.memeov1.memeov1.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memeov1.memeov1.entities.Conversation;
import com.memeov1.memeov1.entities.ConversationPK;
import com.memeov1.memeov1.entities.DirectMessage;
import com.memeov1.memeov1.entities.User;
import com.memeov1.memeov1.repositories.ConversationRepository;
import com.memeov1.memeov1.repositories.UserRepository;

@Service
public class ConversationService {

    public final ConversationRepository conversationRepository;
    public final UserRepository userRepository;

    public ConversationService(ConversationRepository conversationRepository, UserRepository userRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }

    public Conversation create(Conversation conversation) {
        Integer lastConversationID = conversationRepository.findLastConversationID();
        // si lo encuentra le suma 1, si no lo encuentra le asigna 1
        Integer newConversationID = lastConversationID != null ? lastConversationID + 1 : 1;
        ConversationPK conversationPK = new ConversationPK(conversation.getConversationPK().getStarterUserID(),
                conversation.getConversationPK().getReceiverUserID(), newConversationID);
        Conversation c = new Conversation(conversationPK, null);
        return conversationRepository.saveAndFlush(c);
    }

    // encontrar conversaciones por id del username
    public List<Conversation> findConversationsByReceiverUsername(String username) {
        List<Integer> receiverUserIDs = userRepository.findUserIDsByUsernameContainsIgnoreCase(username);
        if (!receiverUserIDs.isEmpty()) {
            return conversationRepository.findConversationsByConversationPKReceiverUserIDIn(receiverUserIDs);
        }
        return List.of(); // devuelve una lista vacía si no se encuentran usuarios
    }

    public Conversation updateConversation(Integer conversationID, List<DirectMessage> dms) {
        Conversation conversation = conversationRepository
                .findConversationByConversationPKConversationID(conversationID);
        conversation.setDirectMessages(dms);
        return conversationRepository.saveAndFlush(conversation);
    }

    @Transactional
    public String delete(Integer conversationID) {
        Conversation conversation = conversationRepository
                .findConversationByConversationPKConversationID(conversationID);
        User user = userRepository.findByUserID(conversation.getConversationPK().getReceiverUserID());
        conversationRepository.deleteByConversationPKConversationID(conversationID);
        return "Deleted conversation with user " + user.getUsername();
    }
}
