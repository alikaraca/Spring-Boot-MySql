package com.example.alikaraca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alikaraca.model.User;
import com.example.alikaraca.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> userList() {
		List<User> user = new ArrayList<>();
		userRepository.findAll().forEach(user::add); 
        return user;
	}

	@Override
	public User guncelle(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public Optional<User> findUserById(Integer id) {
		Optional<User> recipeOptional = userRepository.findById(id);

       /* if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }*/

        return recipeOptional;
		//return userRepository.findById(id);
	}	
}
