package com.example.alikaraca.service;


import java.util.List;
import java.util.Optional;

import com.example.alikaraca.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	void deleteUser(Integer id);
	List<User> userList();
	User guncelle(User user);
	public Optional<User> findUserById(Integer id);
}
