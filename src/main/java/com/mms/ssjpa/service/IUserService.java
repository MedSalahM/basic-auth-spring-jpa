package com.mms.ssjpa.service;

import com.mms.ssjpa.model.User;

public interface IUserService {

	
	User saveUser(User user);
	User findUser(Integer id);
	User findUser(String username);
	User updateUser(User user);
	void deleteUser(User user);
	
}
