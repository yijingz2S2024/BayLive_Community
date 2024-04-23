package com.example.bay.mdbspringboot.DAO;

import com.example.bay.mdbspringboot.model.CommunityUserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CommunityUserRoleDAO  extends MongoRepository<CommunityUserRole, String> {
    Optional<CommunityUserRole> findByCommunityIdAndUserId(String communityId, String userId);

    List<CommunityUserRole> findByCommunityIdAndRole(String communityId, Integer role);

    List<CommunityUserRole> findByCommunityId(String communityId);

    List<CommunityUserRole> findByUserId(String userId);
}
