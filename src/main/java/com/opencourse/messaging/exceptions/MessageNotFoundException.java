package com.opencourse.messaging.exceptions;

public class MessageNotFoundException extends RuntimeException{
    
    public MessageNotFoundException(String id){
        super("message with id : " + id + " not found");
    }   
}
