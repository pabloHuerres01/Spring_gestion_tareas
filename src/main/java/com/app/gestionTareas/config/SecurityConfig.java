package com.app.gestionTareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar protección CSRF (para desarrollo)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/tasks/**").permitAll() // Permitir acceso sin autenticación a los endpoints de tareas
                .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
            );

        return http.build();
    }
}
