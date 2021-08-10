package com.springboot.caffeine.cache.repository;

import com.springboot.caffeine.cache.model.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommerceRepository extends JpaRepository<Commerce, Integer> {

    Commerce findByReferenceId(UUID refId);
}
