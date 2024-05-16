package com.memeov1.memeov1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.memeov1.memeov1.entities.DirectMessage;
import com.memeov1.memeov1.repositories.DMRepository;

@Service
public class DMService {

    public final DMRepository dmRepository;

    public DMService(DMRepository dmRepository) {
        this.dmRepository = dmRepository;
    }

    public DirectMessage create(DirectMessage dm) {
        return dmRepository.saveAndFlush(dm);
    }

    public List<DirectMessage> getDMsFromConversation(Integer conversationID) {
        return dmRepository.findDirectMessagesByConversationConversationPKConversationID(conversationID);
    }

    public String delete(Integer dmID) {
        DirectMessage dm = dmRepository.findByMessageID(dmID);
        dmRepository.deleteById(dmID);
        return "Deleted direct message: " + dm.getText_content();
    }

}
