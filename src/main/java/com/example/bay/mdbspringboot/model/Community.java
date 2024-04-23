package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "community")
public class Community {
    @Id
    private String id = UUID.randomUUID().toString();

    @Field("name")
    private String name;

    @Field("type")
    private Integer type;

    @Field("moderatorId")
    private String moderatorId;

    @Field("description")
    private String description;

    private List<CommunityUserRole> members;

    private List<Message> messages;

    public enum COMMUNITY_TYPE {
        DINING(1),
        LANDMARK(2),
        RECREATION(3),
        SHOPPING(4);

        private final int value;

        COMMUNITY_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}