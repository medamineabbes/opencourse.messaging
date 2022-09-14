package com.opencourse.messaging.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Message {
    @Id
    private String id;
    private Long senderId;
    private Long receiverId;
    private String text;
    private LocalDateTime date;
    private Boolean seen;
}
