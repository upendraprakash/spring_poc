package com.springboot.caffeine.cache.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

//spring annotation
@Configuration
public class FakerConfig {

    @Bean
    public Faker faker() {
        return new Faker(Locale.ENGLISH);
    }
}
