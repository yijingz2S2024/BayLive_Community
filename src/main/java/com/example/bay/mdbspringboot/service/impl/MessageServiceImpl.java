package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.DAO.MessageDAO;
import com.example.bay.mdbspringboot.model.Message;
import com.example.bay.mdbspringboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Service

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAO messageDAO;

    private static final String CURRENT_USER_ID = "111";
    private static final String CURRENT_USERNAME = "current_username";

    @Override
    public Message addMessage(Message message) {
        message.setSenderId(CURRENT_USER_ID);
        message.setSenderUsername(CURRENT_USERNAME);
        message.setTimestamp(Instant.now().toString());
        return messageDAO.save(message);
    }

    @Override
    public void removeAllMessagesFromCommunity(String communityId) {
        List<Message> messageList = messageDAO.findByCommunityId(communityId);

        messageDAO.deleteAll(messageList);
    }

    @Override
    public List<Message> getMessagesByCommunityId(String communityId) {
        List<Message> messageList = messageDAO.findAllByCommunityId(communityId);
        Collections.sort(messageList, Message.timestampComparator);
        return messageList;
    }
}
