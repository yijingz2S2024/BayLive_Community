package com.example.bay.mdbspringboot.service;

import com.example.bay.mdbspringboot.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    Message addMessage(Message message);

    void removeAllMessagesFromCommunity(String communityId);

    List<Message> getMessagesByCommunityId(String communityId);
}
