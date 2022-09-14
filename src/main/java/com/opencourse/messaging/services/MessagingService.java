package com.opencourse.messaging.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.opencourse.messaging.dtos.SendMessageDto;
import com.opencourse.messaging.entities.Message;
import com.opencourse.messaging.exceptions.MessageNotFoundException;
import com.opencourse.messaging.repos.MessageRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessagingService {
    
    private final MessageRepo repo;
    
    public Message SendMessage(SendMessageDto dto,Long userId){
        Message msg=new Message();
        msg.setDate(LocalDateTime.now());
        msg.setReceiverId(dto.getReceiverId());
        msg.setSeen(false);
        msg.setSenderId(userId);
        msg.setText(dto.getText());
        
        //save message
        repo.save(msg);

        return msg;
    }

    public Page<Message> getMessages(Long user1,Long user2,Pageable pageable){

        return null;
    } 
    
    public Message viewMessage(String messageId){
        Message msg=repo.findById(messageId)
        .orElseThrow(()->new MessageNotFoundException(messageId));

        msg.setSeen(true);
        repo.save(msg);
        
        return msg;
    }
    
}
