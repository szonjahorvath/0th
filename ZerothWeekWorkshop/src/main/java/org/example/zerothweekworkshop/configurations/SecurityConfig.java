package org.example.zerothweekworkshop.configurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests //authorize which area can access to everyone
                        .requestMatchers("/", "/login").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()   // free to see everbody
                )
                .formLogin((form) -> form       // for everybody
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll()
                            .logoutSuccessUrl("/login?logout")
                );       //what happens if you logged out

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
