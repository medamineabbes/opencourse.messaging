package com.opencourse.messaging.config.security;

import java.security.Principal;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomPrincipal implements Principal{

    private String name;

    @Override
    public String getName() {
        return name;
    }
    
}
