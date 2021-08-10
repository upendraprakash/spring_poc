package com.springboot.caffeine.cache.service;

import com.springboot.caffeine.cache.model.Commerce;
import com.springboot.caffeine.cache.repository.CommerceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//lombok annotation
@Slf4j
//spring annotation
@Service
//cache configuration
//annotation streamlines the cache configuration
@CacheConfig(cacheNames = {"commerce"})
public class CommerceService {

    @Autowired
    private CommerceRepository repository;

    public boolean defaultsPresent() {
        return repository.count() > 0;
    }

    public void saveAll(final List<Commerce> commerce) {
        log.info("Saving products.");
        repository.saveAll(commerce);
    }

    //annotation specifies that method is cacheable
    @Cacheable
    public List<Commerce> getCommerceList() {
        log.info("Getting all products");
        return repository.findAll();
    }

    //annotation specifies that method is cacheable
    @Cacheable
    public Commerce getCommerceByRefId(final UUID refId) {
        log.info("Finding product by reference id = {}", refId);
        return repository.findByReferenceId(refId);
    }
}
