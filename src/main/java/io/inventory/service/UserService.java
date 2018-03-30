package io.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inventory.model.User;
import io.inventory.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		ur.findAll().forEach(users::add);
		return users;
	}
	
	public Optional<User> getUser(Long id) {
		return ur.findById(id);
	}
	
	public void addUser(User user) {
		ur.save(user);
	}

	public void updateUser(User user) {
		ur.save(user);
	}

	public void deleteUser(long id) {
		ur.deleteById(id);
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		ur.deleteAll();
	}
	
}
