package com.opencourse.messaging.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opencourse.messaging.entities.Message;

public interface MessageRepo extends MongoRepository<Message,String>{
    
}
