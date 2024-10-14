package com.app.gestionTareas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/tareas/**").permitAll() // Permitir acceso sin autenticación a los endpoints de tareas
            .anyRequest().authenticated(); // Otros endpoints requieren autenticación
    }
}
