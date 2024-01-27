package com.example.customerregistration.securityconfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader =  request.getHeader("Authorization");
        final String jwt;
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            System.out.println("header null");
            filterChain.doFilter(request ,response);
            return;
        }

        jwt = authHeader.substring(7);
        String userEmail=jwtService.extractUsername(jwt);

        if(userEmail!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            System.out.println("email not null");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if(jwtService.isValidToken(jwt ,userDetails) || jwtService.isTokenExpired(jwt)){
                System.out.println("jwt token");
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails ,null , userDetails.getAuthorities()
                );
                System.out.println("if-den cixdi");
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println("token auth");
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("security kecdi");
            }

        }
        System.out.println("burdayam heleki");
        filterChain.doFilter(request ,response);
        System.out.println("burdan cixa bilmedim ama");
    }
}
