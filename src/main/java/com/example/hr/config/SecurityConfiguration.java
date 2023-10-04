package com.example.hr.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.hr.User.Role.ADMIN;
import static com.example.hr.User.Role.MANAGER;
import static com.example.hr.User.Permission.ADMIN_CREATE;
import static com.example.hr.User.Permission.ADMIN_DELETE;
import static com.example.hr.User.Permission.ADMIN_READ;
import static com.example.hr.User.Permission.ADMIN_UPDATE;
import static com.example.hr.User.Permission.MANAGER_CREATE;
import static com.example.hr.User.Permission.MANAGER_DELETE;
import static com.example.hr.User.Permission.MANAGER_READ;
import static com.example.hr.User.Permission.MANAGER_UPDATE;


import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(
                "/api/mfa/auth/**",
                "/api/users/**",
                "/v2/api-docs",
                "/v3/api-docs",
                "/v3/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger-ui.html"
        )
          .permitAll()


        .requestMatchers("/api/mfa/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
        .requestMatchers("/api/mfa/orgchart/create/**").hasAnyRole(ADMIN.name(), MANAGER.name())
        .requestMatchers("/api/mfa/userprofile/create/**").hasAnyRole(ADMIN.name(), MANAGER.name())
            .requestMatchers("/api/mfa/user/get/**").hasAnyRole(ADMIN.name(), MANAGER.name())

        .requestMatchers(GET, "/api/mfa/user/get/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
        .requestMatchers(POST, "/api/mfa/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
        .requestMatchers(PUT, "/api/mfa/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
        .requestMatchers(DELETE, "/api/mfa/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())


       /* .requestMatchers("/api/mfa/admin/**").hasRole(ADMIN.name())

        .requestMatchers(GET, "/api/mfa/admin/**").hasAuthority(ADMIN_READ.name())
        .requestMatchers(POST, "/api/mfa/admin/**").hasAuthority(ADMIN_CREATE.name())
        .requestMatchers(PUT, "/api/mfa/admin/**").hasAuthority(ADMIN_UPDATE.name())
        .requestMatchers(DELETE, "/api/mfa/admin/**").hasAuthority(ADMIN_DELETE.name())*/


        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/mfa/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}