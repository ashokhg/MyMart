package com.mymart.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.userservice.entity.User;

public interface UsersDao extends JpaRepository<User, Long> {

	public User findByName(String userName);
}
