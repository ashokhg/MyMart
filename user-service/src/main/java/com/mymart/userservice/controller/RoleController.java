package com.mymart.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.userservice.dto.RoleCreateDto;
import com.mymart.userservice.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping
	public ResponseEntity<String> index(){
		
		return ResponseEntity.ok().body("Working");
	}
	
	@PostMapping("/create")
	public ResponseEntity<RoleCreateDto> createRole(@RequestBody RoleCreateDto createRequest) {
		
	RoleCreateDto res =	roleService.createRole(createRequest);
	return ResponseEntity.ok().body(res);
	}
}
