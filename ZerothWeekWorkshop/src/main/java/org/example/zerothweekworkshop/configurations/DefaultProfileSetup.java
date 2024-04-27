package org.example.zerothweekworkshop.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DefaultProfileSetup {
    @Bean
    @Profile("!dev & !test")
    public String defaultActiveProfile() {
        System.setProperty("spring.profiles.active", "dev");
        return "prod";
    }
}
