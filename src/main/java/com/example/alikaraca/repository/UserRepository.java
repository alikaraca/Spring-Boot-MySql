package com.example.alikaraca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.alikaraca.model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Integer>{
	User findByEmail(String email);
	//Optional<User> findById(Integer id);
}
