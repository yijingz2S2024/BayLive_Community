package com.example.bay.mdbspringboot.service;

import com.example.bay.mdbspringboot.model.Community;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommunityService {
    List<Community> getRecommendedCommunitiesForUser(String userId);

    List<Community> getFilteredCommunties(String searchType, String searchValue);

    Community createCommunity(Community community);

    void uodateCommunity(Community community);

    void joinCommunity(String communityId);

    void leaveCommunity(String communityId);

    Optional<Community> getCommunityDetailsById(String communityId);

    void kickoutUserFromCommunity(String communityId, String userId);

    void deleteCommunity(String communityId);

    List<Community> getCurrentUserCommunities();
}
