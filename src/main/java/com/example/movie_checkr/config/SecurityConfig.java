package com.example.movie_checkr.config;

import com.example.movie_checkr.filter.JwtAuthenticationFilter;
import com.example.movie_checkr.service.ShowsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final ShowsService showsService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(ShowsService showsService, JwtAuthenticationFilter authenticationFilter) {
        this.showsService = showsService;
        this.jwtAuthenticationFilter = authenticationFilter;
    }

    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.requestMatchers("/api/shows/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .userDetailsService((UserDetailsService) showsService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
