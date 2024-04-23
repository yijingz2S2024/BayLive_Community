package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.DAO.CommunityUserRoleDAO;
import com.example.bay.mdbspringboot.model.CommunityUserRole;
import com.example.bay.mdbspringboot.service.CommunityUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityUserRoleServiceImpl  implements CommunityUserRoleService {
    @Autowired
    private CommunityUserRoleDAO communityUserRoleDAO;
    @Override
    public void addUserToCommunityBySpecificRole(String communityId, String userId, String username,Integer role) {
        CommunityUserRole communityUserRole = new CommunityUserRole();
        communityUserRole.setCommunityId(communityId);
        communityUserRole.setUserId(userId);
        communityUserRole.setUsername(username);
        communityUserRole.setRole(role);
        communityUserRoleDAO.save(communityUserRole);
    }

    @Override
    public void removeUserFromCommunity(String communityId, String userId) {
        Optional<CommunityUserRole> userRoleOptional = communityUserRoleDAO.findByCommunityIdAndUserId(communityId, userId);
        userRoleOptional.ifPresent(communityUserRoleDAO::delete);
    }

    @Override
    public List<CommunityUserRole> getAllMembersByCommunityId(String communityId) {
        return communityUserRoleDAO.findByCommunityIdAndRole(communityId, CommunityUserRole.ROLE_TYPE.MEMBER.getValue());
    }

    @Override
    public void removeAllUsersFromCommunity(String communityId) {
        List<CommunityUserRole> userRolesInCommunity = communityUserRoleDAO.findByCommunityId(communityId);

        communityUserRoleDAO.deleteAll(userRolesInCommunity);
    }

    @Override
    public List<CommunityUserRole> getAllByUserId(String userId) {
        return communityUserRoleDAO.findByUserId(userId);
    }
}
