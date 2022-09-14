package com.opencourse.messaging.dtos;

import lombok.Data;

@Data
public class SendMessageDto {
    private String text;
    private Long receiverId;
}
