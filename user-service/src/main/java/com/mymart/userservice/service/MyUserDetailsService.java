package com.mymart.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mymart.userservice.dao.UserPrinciple;
import com.mymart.userservice.dao.UsersDao;
import com.mymart.userservice.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = usersDao.findByName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found 404");
		}
		return new UserPrinciple(user);
	
	}
}
