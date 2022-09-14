package com.opencourse.messaging.apis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencourse.messaging.dtos.MessageNotification;
import com.opencourse.messaging.dtos.SendMessageDto;
import com.opencourse.messaging.entities.Message;
import com.opencourse.messaging.services.MessagingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/messaging/message")
@AllArgsConstructor
public class MessageController {
    
    private final MessagingService service;
    private final SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void sendMessage(@Payload SendMessageDto message,SimpMessageHeaderAccessor sha){
        //get user from session
        String stringId=sha.getUser().getName();
        Long userId=Long.parseLong(stringId);

        //add message to database
        Message msg=service.SendMessage(message, userId);
        
        //send notofication
        MessageNotification notificaion=new MessageNotification();
        notificaion.setMessageId(msg.getId());
        notificaion.setSenderId(msg.getSenderId());
        template.convertAndSendToUser(message.getReceiverId().toString(),
        "/queue/messages", 
        notificaion);

    }

    @GetMapping
    public ResponseEntity<Page<Message>> getMessages(@RequestParam(required = true)int page,@RequestParam(required = true) Long user1){
        Long user2=15L;
        Pageable pageable=PageRequest.of(page, 15);

        Page<Message> messages=service.getMessages(user1, user2, pageable) ;
        return ResponseEntity.ok(messages);
        
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<Message> viewMessage(@PathVariable(required = true) String messageId){
        Message msg=service.viewMessage(messageId);
        return ResponseEntity.ok(msg);
    }

}
