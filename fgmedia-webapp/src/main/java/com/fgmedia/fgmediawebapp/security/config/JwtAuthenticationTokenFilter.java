package com.fgmedia.fgmediawebapp.security.config;

import com.fgmedia.fgmediawebapp.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
//
//	@Autowired
//	private JwtService jwtService;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
//		try {
//			String jwtToken = getJwtFromRequest(request);
//			String username = jwtService.extractUserName(jwtToken);
//
//			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//				if (jwtService.validateToken(jwtToken, userDetails)) {
//					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//					SecurityContextHolder.getContext().setAuthentication(authentication);
//				}
//			}
//		} catch (Exception ex) {
//			logger.error("Could not set user authentication in security context", ex);
//		}
//
//		filterChain.doFilter(request, response);
//	}
//
//	private String getJwtFromRequest(HttpServletRequest request) {
//		String bearerToken = request.getHeader("Authorization");
//		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//			return bearerToken.substring(7);
//		}
//		return null;
//	}
//}