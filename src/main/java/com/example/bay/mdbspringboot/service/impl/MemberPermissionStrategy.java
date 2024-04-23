package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.service.PermissionStrategy;

public class MemberPermissionStrategy implements PermissionStrategy {
    @Override
    public boolean hasPermission(String actionName) {
        return actionName.equals("joinCommunity") || actionName.equals("leaveCommunity");
    }
}
