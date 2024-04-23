package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.DAO.CommunityDAO;
import com.example.bay.mdbspringboot.model.*;
import com.example.bay.mdbspringboot.service.CommunityService;
import com.example.bay.mdbspringboot.service.CommunityUserRoleService;
import com.example.bay.mdbspringboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityServiceImpl implements CommunityService {
    private static final String CURRENT_USER_ID = "111";

    private static final String CURRENT_USERNAME = "current_username";


    @Autowired
    private CommunityUserRoleService communityUserRoleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CommunityDAO communityDAO;
    @Override
    public List<Community> getRecommendedCommunitiesForUser(String userId) {
        //depends on what can be get through search history
        return communityDAO.findAll();
    }

    @Override
    public List<Community> getFilteredCommunties(String searchType, String searchValue) {
        List<Community> communityList = new ArrayList<>();
        switch(searchType){
            case "type":
                communityList = communityDAO.getCommunitiesByType(Integer.parseInt(searchValue));
                break;
            case "content":
                communityList = communityDAO.getCommunitiesByContent(searchValue);
                break;
        }

        List<CommunityUserRole> communities = communityUserRoleService.getAllByUserId(CURRENT_USER_ID);

        if (!communities.isEmpty()) {
            Set<String> communityIds = communities.stream()
                    .map(CommunityUserRole::getCommunityId)
                    .collect(Collectors.toSet());
            communityList.removeIf(community -> communityIds.contains(community.getId()));
        }

        return communityList;
    }

    @Override
    @Transactional
    public Community createCommunity(Community community) {
        community.setModeratorId(CURRENT_USER_ID);
        communityUserRoleService.addUserToCommunityBySpecificRole(community.getId(), CURRENT_USER_ID, CURRENT_USERNAME, CommunityUserRole.ROLE_TYPE.MODERATOR.getValue());

        return communityDAO.save(community);
    }

    @Override
    public void uodateCommunity(Community community) {
        Optional<Community> communityOptional = communityDAO.findById(community.getId());
        if (communityOptional.isPresent()) {
            community.setModeratorId(communityOptional.get().getModeratorId());
            communityDAO.save(community);
        }
    }
    @Override
    public void joinCommunity(String communityId) {
        communityUserRoleService.addUserToCommunityBySpecificRole(communityId, CURRENT_USER_ID, CURRENT_USERNAME, CommunityUserRole.ROLE_TYPE.MEMBER.getValue());
    }

    @Override
    public void leaveCommunity(String communityId) {
        communityUserRoleService.removeUserFromCommunity(communityId,CURRENT_USER_ID);
    }

    @Override
    public Optional<Community> getCommunityDetailsById(String communityId) {
        Optional<Community> communityOptional = communityDAO.findById(communityId);
        if (communityOptional.isPresent()) {
            Community community = communityOptional.get();
            List<CommunityUserRole> members = communityUserRoleService.getAllMembersByCommunityId(communityId);
            community.setMembers(members);
            List<Message> messages = messageService.getMessagesByCommunityId(communityId);
            community.setMessages(messages);
            return Optional.of(community);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void kickoutUserFromCommunity(String communityId, String userId) {
        communityUserRoleService.removeUserFromCommunity(communityId, userId);
    }

    @Override
    @Transactional
    public void deleteCommunity(String communityId) {
        communityDAO.deleteById(communityId);

        communityUserRoleService.removeAllUsersFromCommunity(communityId);

        messageService.removeAllMessagesFromCommunity(communityId);
    }

    @Override
    public List<Community> getCurrentUserCommunities() {
        List<CommunityUserRole> communityUserRoles = communityUserRoleService.getAllByUserId(CURRENT_USER_ID);
        return null;
    }


}
