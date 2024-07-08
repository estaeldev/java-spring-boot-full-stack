package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtTokenRequest {

    String username;
    String password;
    
}
