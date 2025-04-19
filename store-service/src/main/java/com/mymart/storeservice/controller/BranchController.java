package com.mymart.storeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.storeservice.dao.BranchDao;
import com.mymart.storeservice.dto.BranchCreateReq;
import com.mymart.storeservice.dto.BranchCreateRes;
import com.mymart.storeservice.dto.BranchUpdateReq;
import com.mymart.storeservice.dto.BranchUpdateRes;
import com.mymart.storeservice.service.BranchService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/branch")
public class BranchController {

//	private static final Logger LOGGER =
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("/create-branch")
	public ResponseEntity<BranchCreateRes> createBranch(@RequestBody BranchCreateReq branchDto) {
				
		BranchCreateRes branchResponseDto = branchService.storeBranch(branchDto);
				
		return ResponseEntity.ok().body(branchResponseDto);
	}
	
	@GetMapping("/get-all-branches")
	public ResponseEntity<List<BranchCreateRes>> getAllBranches(HttpServletRequest request){
		
		List<BranchCreateRes> branches = branchService.getAllBranches();
		
		return ResponseEntity.ok().body(branches);
	}
	
	@GetMapping("/get/{branchId}")
	public ResponseEntity<BranchCreateRes> getBranchById(@PathVariable String branchId){
		
		BranchCreateRes branchResponseDto = branchService.getBranchbyId(branchId);
		
		return ResponseEntity.ok().body(branchResponseDto);
	}
	
	@PutMapping("/update/{branchId}")
	public ResponseEntity<BranchCreateRes> updateBranch(@PathVariable String branchId, @RequestBody BranchCreateReq branchDto){
		
		BranchCreateRes branchResponseDto = branchService.updateBranch(branchDto, branchId);
		
		return ResponseEntity.ok().body(branchResponseDto);
	}
	
	@PatchMapping("/update/status/{branchId}")
	public ResponseEntity<BranchUpdateRes> updateBranch(@PathVariable String branchId,
														@RequestBody BranchUpdateReq branchUpdateReq){
		
		BranchUpdateRes branchUpdateRes = branchService.updateBranchStatus(branchUpdateReq, branchId);
		
		return ResponseEntity.ok().body(branchUpdateRes);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<BranchCreateRes>> searchBranchByPincodeOrCity(
							@RequestParam(required = false) String pincode,
							@RequestParam(required = false) String city){
		
		List<BranchCreateRes> result = branchService.searchBranchByPincodeOrCity(pincode, city);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/search/with/pagination")
	public ResponseEntity<Page<BranchCreateRes>> searchBranchByPincodeOrCitywithPagination(
							@RequestParam(required = false) String pincode,
							@RequestParam(required = false) String city, 
							Pageable pageable ){
		
		Page<BranchCreateRes> result = branchService.searchBranchByPincodeOrCityWithPagination(pageable, pincode, city);
		
		return ResponseEntity.ok().body(result);
	}
}
