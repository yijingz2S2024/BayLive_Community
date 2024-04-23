package com.example.bay.mdbspringboot.service;

import com.example.bay.mdbspringboot.model.CommunityUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityUserRoleService {
    void addUserToCommunityBySpecificRole(String communityId, String userId, String username, Integer role);

    void removeUserFromCommunity(String communityId, String userId);

    List<CommunityUserRole> getAllMembersByCommunityId(String communityId);

    void removeAllUsersFromCommunity(String communityId);

    List<CommunityUserRole> getAllByUserId(String currentUserId);
}
