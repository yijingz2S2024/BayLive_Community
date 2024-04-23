package com.example.bay.mdbspringboot.DAO;

import com.example.bay.mdbspringboot.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageDAO extends MongoRepository<Message, String> {
    List<Message> findByCommunityId(String communityId);

    List<Message> findAllByCommunityId(String communityId);
}
