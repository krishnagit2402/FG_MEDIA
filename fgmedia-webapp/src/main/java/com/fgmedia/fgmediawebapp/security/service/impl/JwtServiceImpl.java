package com.fgmedia.fgmediawebapp.security.service.impl;

import com.fgmedia.fgmediawebapp.utils.CommonConstant;
import com.fgmedia.fgmediawebapp.security.service.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

	@Value("${jwt.token.secret.key}")
	private String jwtSecretKey;

	@Value("${jwt.token.validity.millis}")
	private Long tokenValidityInMillis;

//	public String generateToken(UserDetails userDetails) {
//		return Jwts.builder()
//				.setSubject(userDetails.getUsername())
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + tokenValidityInMillis))
//				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
//				.compact();
//	}

	public String extractUserName(String token) {
		Claims claims = extractClaim(token);
		return claims.getSubject();
	}

	private Key getSigningKey() {
		byte[] key = Decoders.BASE64.decode(this.jwtSecretKey);
		return Keys.hmacShaKeyFor(key);
	}

	private Claims extractClaim(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(this.getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	public Boolean isAuthenticatedToken(String token) {
		Claims claims = extractClaim(token);
		return claims.get(CommonConstant.AUTHENTICATED, Boolean.class);
	}

	private Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = this.extractClaim(token);
			created = new Date((Long) claims.get("created"));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	private Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.extractClaim(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public Boolean isTokenExpired(String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(new Date(System.currentTimeMillis()));
	}

//	@Override
//	public boolean validateToken(String jwtToken, UserDetails userDetails) {
//		final Date created = this.getCreatedDateFromToken(jwtToken);
//		final Date expiration = this.getExpirationDateFromToken(jwtToken);
//		final String username = this.extractUserName(jwtToken);
//
//		return (username.equals(userDetails.getUsername()) && !(this.isTokenExpired(jwtToken)));
//	}
}