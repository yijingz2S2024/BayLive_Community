package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@Document(collection = "communityUserRole")
public class CommunityUserRole {
    @Id
    private String id = UUID.randomUUID().toString();

    @Field("communityId")
    private String communityId;

    @Field("userId")
    private String userId;

    @Field("username")
    private String username;

    @Field("role")
    private Integer role;

    public enum ROLE_TYPE {
        ADMIN(0),
        MODERATOR(1),
        MEMBER(2);

        private final int value;

        ROLE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}