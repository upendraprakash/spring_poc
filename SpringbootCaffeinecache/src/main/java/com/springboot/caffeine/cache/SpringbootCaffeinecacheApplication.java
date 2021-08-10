package com.springboot.caffeine.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//lombok annotation
@Slf4j
//spring annotation
@SpringBootApplication
//caching
@EnableCaching
public class SpringbootCaffeinecacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCaffeinecacheApplication.class, args);
        log.info("Springboot caffeine cache application is started successfully");
    }
}
