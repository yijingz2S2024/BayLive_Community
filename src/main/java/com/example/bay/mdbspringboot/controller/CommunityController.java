package com.example.bay.mdbspringboot.controller;

import com.example.bay.mdbspringboot.model.Community;
import com.example.bay.mdbspringboot.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/communities")
@CrossOrigin(origins = "http://localhost:3000")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping
    public Community addCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    @PutMapping
    public String updateCommunity(@RequestBody Community community) {
        communityService.uodateCommunity(community);
        return "Community updated successfully";
    }

    @GetMapping("/recommended/{userId}")
    public List<Community> getRecommendedCommunities(@PathVariable String userId) {
        return communityService.getRecommendedCommunitiesForUser(userId);
    }

    @GetMapping("/searchType/{searchType}/searchValue/{searchValue}")
    public List<Community> getRecommendedCommunities(@PathVariable String searchType, @PathVariable String searchValue) {
        return communityService.getFilteredCommunties(searchType,searchValue);
    }

    @DeleteMapping("/{communityId}")
    public String deleteCommunity(@PathVariable String communityId) {
        communityService.deleteCommunity(communityId);
        return "Community deleted successfully";
    }

    @PutMapping("/{communityId}/join")
    public String joinCommunity(@PathVariable String communityId) {
        communityService.joinCommunity(communityId);
        return "Community joined successfully";
    }

    @PutMapping("/{communityId}/leave")
    public String leaveCommunity(@PathVariable String communityId) {
        communityService.leaveCommunity(communityId);
        return "Community leaved successfully";
    }

    @GetMapping("/{communityId}")
    public Optional<Community> getCommunityById(@PathVariable String communityId) {
        return communityService.getCommunityDetailsById(communityId);
    }

    @GetMapping("/{userId}/kickOut/{communtyId}")
    public String kickoutUser(@PathVariable String userId, @PathVariable String communtyId) {
         communityService.kickoutUserFromCommunity(communtyId, userId);
        return "user kicked out successfully";

    }

    @GetMapping("/currentUser")
    public List<Community> getCurrentUserCommunities() {
        return communityService.getCurrentUserCommunities();
    }
}
