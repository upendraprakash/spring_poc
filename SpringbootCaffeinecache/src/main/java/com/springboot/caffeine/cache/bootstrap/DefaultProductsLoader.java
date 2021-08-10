package com.springboot.caffeine.cache.bootstrap;

import com.github.javafaker.Faker;
import com.springboot.caffeine.cache.model.Commerce;
import com.springboot.caffeine.cache.service.CommerceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//lombok annotation
@Slf4j
//spring annotation
@Component
public class DefaultProductsLoader implements CommandLineRunner {

    @Autowired
    private CommerceService service;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        if (service.defaultsPresent()) {
            log.info("Skipping insert as default records are present");
        } else {
            service.saveAll(list());
        }
    }

    private List<Commerce> list() {
        final List<Commerce> commerce = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            commerce.add(create());
        }

        return commerce;
    }

    private Commerce create() {
        return Commerce.builder()
                .productName(faker.commerce().productName())
                .material(faker.commerce().material())
                .price(Double.parseDouble(faker.commerce().price()))
                .promotionCode(faker.commerce().promotionCode())
                .department(faker.commerce().department())
                .referenceId(UUID.randomUUID())
                .build();
    }
}
