package com.example.cardorderbycustomer.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig   {

    private  final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter authenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register").permitAll()

                .requestMatchers("/api/v1/auth/authenticate").authenticated()



                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v2/api-docs").permitAll()
                .requestMatchers( "/swagger-resources/**").permitAll()
                .requestMatchers("/swagger-ui.html").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/card-order-api/nofeign/**").authenticated()
                .requestMatchers("/card-order-api/feign/**").permitAll()

//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout()
//                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter , UsernamePasswordAuthenticationFilter.class)
               ;


        return http.build();
    }
}
