package com.oasisoaksconciergemed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                /* Login configuration */
//                .formLogin((login) -> login
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/dashboard"))
//                /* Logout configuration */
//                .logout((logout) -> logout.logoutSuccessUrl("/login"))  //CHANGED THIS LINE, ADDED LOGOUT
//                .httpBasic(withDefaults())
                .authorizeHttpRequests((requests) -> requests
//                         Pages that require authentication

                                .requestMatchers(
                                        "/login"
                                )
                                .authenticated()

                                /* Pages that do not require authentication
                                 * anyone can visit the home page and view services */

                                .requestMatchers(
                                        "",
                                        "/"
                                ).permitAll()

                                // allow loading of static resources
                                .requestMatchers(
                                        "/css/**",
                                        "/js/**",
                                        "/img/**")
                                .permitAll()
                )
        ;
        return http.build();
    }
}
