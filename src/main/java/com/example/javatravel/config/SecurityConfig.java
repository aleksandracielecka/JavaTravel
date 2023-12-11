package com.example.javatravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .cors(c -> c.disable())
                .authorizeHttpRequests((authorize) ->
//                        authorize.anyRequest().permitAll());
//                        authorize.anyRequest().authenticated()
                                authorize
                                        .requestMatchers(new AntPathRequestMatcher("/main_page")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/trip_details/{id}")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/trips")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/filter_trips")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/confirmation")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/purchase")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/final_price")).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
//                                        .requestMatchers(new AntPathRequestMatcher("")).hasAnyAuthority("ROLE_USER")

                                        .anyRequest().hasAnyAuthority("ROLE_ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/main_page")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));

    }
}

