package com.mms.ssjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mms.ssjpa.model.AppUser;
import com.mms.ssjpa.model.User;

@Service
public class MUserDetailsService implements UserDetailsService {

	@Autowired IUserService iUserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = iUserService.findUser(username);
		
		return new AppUser(user);
	}
}
