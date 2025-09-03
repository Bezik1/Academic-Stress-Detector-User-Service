package com.userservice.userservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.userservice.userservice.model.Session;
import com.userservice.userservice.service.SessionService;

@Component("security")
public class SecurityExpressions {

    private final SessionService sessionService;

    public SecurityExpressions(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public boolean isUser(Authentication authentication) {
        return authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_USER"));
    }

    public boolean isOwner(Authentication authentication, Long userId) {
        if(!isUser(authentication)) return false;
        
        Long principalId = Long.valueOf(authentication.getPrincipal().toString());
        return principalId.equals(userId);
    }

    public boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    public boolean isSessionOwner(Authentication authentication, Long sessionId) {
        if (isAdmin(authentication)) return true;

        Long principalId = Long.valueOf(authentication.getPrincipal().toString());
        Session session = sessionService.getSessionById(sessionId);
        return session.getUser().getId().equals(principalId);
    }
}