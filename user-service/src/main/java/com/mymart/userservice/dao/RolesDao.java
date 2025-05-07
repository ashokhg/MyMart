package com.mymart.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.userservice.entity.Roles;

public interface RolesDao extends JpaRepository<Roles, Long>{

}
