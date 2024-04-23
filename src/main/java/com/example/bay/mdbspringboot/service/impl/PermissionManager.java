package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.service.PermissionStrategy;

public class PermissionManager {
    private PermissionStrategy permissionStrategy;

    public boolean checkPermission(int userId, int communityId, String actionName) {
        //0 if user is administrator
//        Integer role = communityUserService.getRoleForUserInCommunity(userId, communityId);

//        switch (role) {
//            case 0:
//                permissionStrategy = new AdminPermissionStrategy();
//                break;
//            case 1:
//                permissionStrategy = new ModeratorPermissionStrategy();
//                break;
//            default:
//                permissionStrategy = new MemberPermissionStrategy();
//                break;
//        }

        return permissionStrategy.hasPermission(actionName);
    }
}
