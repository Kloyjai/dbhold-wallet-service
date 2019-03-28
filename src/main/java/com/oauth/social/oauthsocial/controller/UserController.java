package com.oauth.social.oauthsocial.controller;

import com.oauth.social.oauthsocial.exception.ResourceNotFoundException;
import com.oauth.social.oauthsocial.entity.User;
import com.oauth.social.oauthsocial.repository.UserRepository;
import com.oauth.social.oauthsocial.security.CurrentUser;
import com.oauth.social.oauthsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
