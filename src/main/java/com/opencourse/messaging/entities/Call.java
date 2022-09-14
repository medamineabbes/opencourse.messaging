package com.opencourse.messaging.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Call {
    
    @Id
    private String id;
    
    private LocalDateTime date;
    
    private Long mentorId;
    
    private List<Long> perticipants;

}
