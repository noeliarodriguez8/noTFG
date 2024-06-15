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

    @Transactional
    public Conversation create(Conversation conversation) {
        Integer lastConversationID = conversationRepository.findLastConversationID();
        // si lo encuentra le suma 1, si no lo encuentra le asigna 1
        Integer newConversationID = lastConversationID != null ? lastConversationID +
                1 : 1;
        ConversationPK conversationPK = new ConversationPK(newConversationID,
                conversation.getConversationPK().getStarterUserID(),
                conversation.getConversationPK().getReceiverUserID());
        Conversation c = new Conversation(conversationPK);
        return conversationRepository.saveAndFlush(c);

        // intento de arreglar la inserción automática de la tabla de relación
        // user_conversations
        // User starterUser =
        // userRepository.findByUserID(conversation.getConversationPK().getStarterUserID());
        // User receiverUser =
        // userRepository.findByUserID(conversation.getConversationPK().getReceiverUserID());

        // Integer lastConversationID = conversationRepository.findLastConversationID();
        // // si lo encuentra le suma 1, si no lo encuentra le asigna 1
        // Integer newConversationID = lastConversationID != null ? lastConversationID +
        // 1 : 1;

        // ConversationPK conversationPK = new
        // ConversationPK(conversation.getConversationPK().getStarterUserID(),
        // conversation.getConversationPK().getReceiverUserID(), newConversationID);
        // Conversation c = new Conversation(conversationPK, null);

        // conversation.getUsers().add(starterUser);
        // conversation.getUsers().add(receiverUser);

        // starterUser.getConversations().add(c);
        // receiverUser.getConversations().add(c);

        // return conversationRepository.saveAndFlush(c);
    }

    // buscar conversaciones por id del username
    public List<Conversation> findConversationsByReceiverUsername(String username) {
        List<Integer> receiverUserIDs = userRepository.findUserIDsByUsernameContainsIgnoreCase(username);
        if (!receiverUserIDs.isEmpty()) {
            return conversationRepository.findConversationsByConversationPKReceiverUserIDIn(receiverUserIDs);
        }
        return List.of(); // devuelve una lista vacía si no se encuentran usuarios
    }

    // listar conversaciones por id de usuario registrado
    public List<Conversation> findConversationsByRegisteredUser(Integer userID) {
        return conversationRepository.findConversationsByUserID(userID);
    }

    // encontrar conversación por conversationID
    public Conversation findConversationByConversationID(Integer conversationID) {
        return conversationRepository.findConversationByConversationPKConversationID(conversationID);
    }

    // @Transactional
    // public Conversation updateConversation(Integer conversationID,
    // List<DirectMessage> dms) {
    // Conversation conversation = conversationRepository
    // .findConversationByConversationPKConversationID(conversationID);
    // conversation.setDirectMessages(dms);
    // return conversationRepository.saveAndFlush(conversation);
    // }

    @Transactional
    public Conversation updateConversation(Integer conversationID, DirectMessage dm) {
        Conversation conversation = conversationRepository
                .findConversationByConversationPKConversationID(conversationID);
        List<DirectMessage> dms = conversation.getDirectMessages();
        dms.add(dm);
        conversation.setDirectMessages(dms);
        return conversationRepository.saveAndFlush(conversation);
    }

    @Transactional
    public String delete(Integer conversationID) {
        Conversation conversation = conversationRepository
                .findConversationByConversationPKConversationID(conversationID);
        User user1 = userRepository.findByUserID(conversation.getConversationPK().getReceiverUserID());
        User user2 = userRepository.findByUserID(conversation.getConversationPK().getStarterUserID());
        conversationRepository.deleteByConversationPKConversationID(conversationID);
        return "Deleted conversation of users " + user1.getUsername() + " and " + user2.getUsername();
    }
}
