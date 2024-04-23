package com.example.bay.mdbspringboot.DAO;

import com.example.bay.mdbspringboot.model.Community;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommunityDAO extends MongoRepository<Community, String> {
    Optional<Community> findById(String communityId);

    List<Community> getCommunitiesByType(Integer type);

    @Query("{$or:[{'name': {$regex : ?0, $options: 'i'}}, {'description': {$regex : ?0, $options: 'i'}}]}")
    List<Community> getCommunitiesByContent(String content);
}
