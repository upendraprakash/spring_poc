package com.pocexample.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocexample.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
