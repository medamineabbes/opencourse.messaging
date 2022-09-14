package com.opencourse.messaging.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.opencourse.messaging.entities.Call;

public interface CallRepo extends MongoRepository<Call,String>{
    
}
