package com.project.learnspringsecurity.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class JwtAuthenticationController {
    
    private final JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<JwtResponse> authenticate(Authentication authentication) {
        String token = this.jwtTokenService.createToken(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(token));
    }

}

record JwtResponse(String token) {}
