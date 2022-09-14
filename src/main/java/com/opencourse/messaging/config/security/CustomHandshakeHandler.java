package com.opencourse.messaging.config.security;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.opencourse.messaging.exceptions.CustomAuthenticationException;
import com.opencourse.messaging.externalservices.AuthService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomHandshakeHandler extends DefaultHandshakeHandler{

    private final AuthService auth;

    @Override
    protected Principal determineUser(ServerHttpRequest request,
    WebSocketHandler handler,
    Map<String,Object> attributes){

        HttpServletRequest req=(HttpServletRequest)request;
        String token=req.getHeader("Authentication");
        
        //validate token
        if(!auth.validateToken(token))
        throw new CustomAuthenticationException();

        String id="get id from token";
        return new CustomPrincipal(id);
    }
}
