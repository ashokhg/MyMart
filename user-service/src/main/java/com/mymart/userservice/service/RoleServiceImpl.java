package com.mymart.userservice.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.userservice.dao.RolesDao;
import com.mymart.userservice.dto.RoleCreateDto;
import com.mymart.userservice.entity.Roles;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RolesDao rolesDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public RoleCreateDto createRole(RoleCreateDto roleCreateRequest) {
		
		return Optional.of(roleCreateRequest)
				.map(role -> modelMapper.map(role, Roles.class))
				.map(rolesDao::save)
				.map(savedRole -> modelMapper.map(savedRole, RoleCreateDto.class))
				.orElseThrow(() -> new RuntimeException("Failed to save role"));
		
	}

}
