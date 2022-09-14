package com.opencourse.messaging.externalservices;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService{

    private RestTemplate restTemplate;
    private String baseUrl;

    public AuthService(){
        restTemplate=new RestTemplate();

    }

    public boolean validateToken(String token){
        //call remoteService
        return false;
    }

}