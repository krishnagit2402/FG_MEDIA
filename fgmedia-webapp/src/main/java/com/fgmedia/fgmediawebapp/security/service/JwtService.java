package com.fgmedia.fgmediawebapp.security.service;

//import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUserName(String token);

//    String generateToken(UserDetails userDetails);

    Boolean isAuthenticatedToken(String token);

//    boolean validateToken(String jwtToken, UserDetails userDetails);

}
