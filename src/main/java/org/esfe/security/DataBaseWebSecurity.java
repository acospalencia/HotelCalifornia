package org.esfe.security;

import org.esfe.servicios.implementaciones.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DataBaseWebSecurity {

    private final CustomUserDetailsService userDetailsService;

    public DataBaseWebSecurity(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder encoder) {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(userDetailsService);
        p.setPasswordEncoder(encoder);
        return p;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, DaoAuthenticationProvider dao) throws Exception {
        http.authorizeHttpRequests(autorize -> autorize
                .requestMatchers("/assets/**", "/css/**", "/js/**").permitAll()
                .requestMatchers("/", "/privacy", "/terms").permitAll()

                .requestMatchers("/reservation/**").hasAnyAuthority("Administrador", "Usuario")
                .requestMatchers("/role/**").hasAnyAuthority("Administrador")
                .requestMatchers("/room/**").hasAnyAuthority("Administrador")
                .requestMatchers("/rooimage/**").hasAnyAuthority("Administrador")
                .requestMatchers("/roomtype/**").hasAnyAuthority("Administrador")
                .requestMatchers("/status/**").hasAnyAuthority("Administrador")
                .requestMatchers("/user/**").hasAnyAuthority("Administrador")

                .anyRequest().authenticated()
        );

        http.formLogin(form -> form.loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll());
        return http.build();
    }
}
