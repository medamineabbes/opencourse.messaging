package com.opencourse.messaging.exceptions;

public class CustomAuthenticationException extends RuntimeException{
    public CustomAuthenticationException(){
        super("authentication arror accured");
    }
}
