package com.example.bay.mdbspringboot.service;

public interface PermissionStrategy {
    boolean hasPermission(String actionName);
}
