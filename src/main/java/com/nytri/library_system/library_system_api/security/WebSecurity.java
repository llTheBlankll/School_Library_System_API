package com.nytri.library_system.library_system_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsManager configure_credentials (BCryptPasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("librarian")
                .password(encoder.encode("snusnu"))
                .roles("Librarian")
                .build());

        manager.createUser(User.withUsername("Administrator")
                .password(encoder.encode("50925092"))
                .roles("Administrator")
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                .disable()
                .authorizeHttpRequests()

                // * REQUEST MATCHERS
                .requestMatchers("/api/administrator")
                .hasRole("Administrator")
                .requestMatchers(HttpMethod.DELETE)
                .hasRole("Librarian")
                .requestMatchers(HttpMethod.PUT)
                .hasRole("Librarian")
                .requestMatchers("/api/librarian")
                .hasRole("Librarian")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return httpSecurity.build();
    }
}
