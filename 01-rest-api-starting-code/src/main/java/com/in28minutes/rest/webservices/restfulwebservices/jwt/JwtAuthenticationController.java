package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;
    
    private final AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(@RequestBody JwtTokenRequest jwtTokenRequest) {
        
        var authenticationToken = new UsernamePasswordAuthenticationToken(
            jwtTokenRequest.username, 
            jwtTokenRequest.password);
        
        var authentication = authenticationManager.authenticate(authenticationToken);
        
        var token = tokenService.generateToken(authentication);
        
        return ResponseEntity.status(HttpStatus.OK).body(
            JwtTokenResponse.builder().token(token).build());
    }
    
}
