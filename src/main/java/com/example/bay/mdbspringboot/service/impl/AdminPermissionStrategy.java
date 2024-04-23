package com.example.bay.mdbspringboot.service.impl;

import com.example.bay.mdbspringboot.service.PermissionStrategy;

public class AdminPermissionStrategy implements PermissionStrategy {
    @Override
    public boolean hasPermission(String actionName) {
        // Has permission to all interfaces
        return true;
    }
}
