package com.pocexample.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocexample.springboot.exception.ResourceNotFoundException;
import com.pocexample.springboot.model.User;
import com.pocexample.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CredsProducer credsProducer;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User user2 = userRepository.save(user);
		ObjectMapper Obj = new ObjectMapper();
		try {
			String credentials = Obj.writeValueAsString(user2);
			credsProducer.send(credentials);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2;
	}

	@KafkaListener(topics = "CredsTopic", groupId = "test-consumer-group")
	public void listen(String message) {
		System.out.println("Received Messasge in group - group-id: " + message);
	}

	@Override
	public User updateUser(User product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub

	}

}
