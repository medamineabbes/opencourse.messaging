package com.opencourse.messaging.dtos;

import lombok.Data;

@Data
public class MessageNotification {
    private String MessageId;
    private Long senderId;
}
