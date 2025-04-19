package com.mymart.storeservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mymart.storeservice.dto.BranchCreateReq;
import com.mymart.storeservice.dto.BranchCreateRes;
import com.mymart.storeservice.dto.BranchUpdateReq;
import com.mymart.storeservice.dto.BranchUpdateRes;
import com.mymart.storeservice.entity.Branch;

public interface BranchService {

	public BranchCreateRes storeBranch(BranchCreateReq branchDto);

	public List<BranchCreateRes> getAllBranches();

	public BranchCreateRes getBranchbyId(String branchId);

	public BranchCreateRes updateBranch(BranchCreateReq branchDto, String branchId);

	public BranchUpdateRes updateBranchStatus(BranchUpdateReq branchUpdateReq, String branchId);

	public List<BranchCreateRes> searchBranchByPincodeOrCity(String city, String city2);

	public Page<BranchCreateRes> searchBranchByPincodeOrCityWithPagination(Pageable pageable, String pincode,
			String city);
}
