package com.mms.ssjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.ssjpa.ecxeption.UserNotFoundException;
import com.mms.ssjpa.model.User;
import com.mms.ssjpa.repo.UserRepository;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
	
		return userRepository.save(user);
	}

	@Override
	public User findUser(Integer id) {
		
		User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id.toString()));
		
		return user;
	}

@Override
public User updateUser(User user) {
	// TODO Auto-generated method stub
	return userRepository.save(user);
}

@Override
public void deleteUser(User user) {
	// TODO Auto-generated method stub
	 userRepository.delete(user);
}

@Override
public User findUser(String username) {
	User user=userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
	
	return user;
}

}
