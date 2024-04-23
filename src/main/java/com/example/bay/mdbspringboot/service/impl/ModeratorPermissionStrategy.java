package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.service.PermissionStrategy;

public class ModeratorPermissionStrategy implements PermissionStrategy {
    @Override
    public boolean hasPermission(String actionName) {
        return actionName.equals("createCommunity") || actionName.equals("updateCommunity") || actionName.equals("deleteCommunity") || actionName.equals("removeCitizen");
    }
}
