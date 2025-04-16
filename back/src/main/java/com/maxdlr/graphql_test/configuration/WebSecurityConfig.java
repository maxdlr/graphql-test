package com.maxdlr.graphql_test.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class WebSecurityConfig {

  @Bean
  SecurityFilterChain filters(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
        .cors(cors -> cors.configurationSource(
            _ -> {
              var corsConfiguration = new CorsConfiguration();
              corsConfiguration.setAllowedOriginPatterns(List.of("*"));
              corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
              corsConfiguration.setAllowedHeaders(List.of("Content-Type", "Accept"));
              corsConfiguration.setAllowCredentials(true);
              return corsConfiguration;
            }))
        .csrf(csrf -> csrf.ignoringRequestMatchers("/graph**"))
        .build();
  }
}
