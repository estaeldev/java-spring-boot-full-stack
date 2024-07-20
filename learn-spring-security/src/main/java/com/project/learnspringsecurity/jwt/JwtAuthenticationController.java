package com.project.learnspringsecurity.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class JwtAuthenticationController {
    
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<JwtResponse> authenticate(@RequestBody final JwtRequest jwtRequest) {

        
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
            new UsernamePasswordAuthenticationToken(jwtRequest.username(), jwtRequest.password());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = this.jwtTokenService.createToken(authenticate);
        return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(token));

    }

}

record JwtResponse(String token) {}

record JwtRequest(String username, String password) {}
