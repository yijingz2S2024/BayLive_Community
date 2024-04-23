package com.example.bay.mdbspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Comparator;
import java.util.UUID;

@Data
@Document(collection = "message")
public class Message {
    @Id
    private String id = UUID.randomUUID().toString();

    @Field("communityId")
    private String communityId;

    @Field("senderId")
    private String senderId;

    @Field("senderUsername")
    private String senderUsername;

    @Field("content")
    private String content;

    @Field("timestamp")
    private String timestamp;

    public static Comparator<Message> timestampComparator = new Comparator<Message>() {
        @Override
        public int compare(Message message1, Message message2) {
            Instant instant1 = Instant.parse(message1.getTimestamp());
            Instant instant2 = Instant.parse(message2.getTimestamp());
            return instant1.compareTo(instant2);
        }
    };
}
