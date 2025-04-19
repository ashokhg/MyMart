package com.mymart.storeservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mymart.storeservice.dao.BranchDao;
import com.mymart.storeservice.dto.BranchCreateReq;
import com.mymart.storeservice.dto.BranchCreateRes;
import com.mymart.storeservice.dto.BranchUpdateReq;
import com.mymart.storeservice.dto.BranchUpdateRes;
import com.mymart.storeservice.entity.Branch;
import com.mymart.storeservice.exceptions.BranchCreationException;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public BranchCreateRes storeBranch(BranchCreateReq branchDto) {
		
		//Imperative
//		Branch branch = modelMapper.map(branchDto, Branch.class);
//		branch = branchDao.save(branch);
//		BranchCreateRes branchResponseDto = modelMapper.map(branch, BranchCreateRes.class);
//		
//		return branchResponseDto;
		
		//Declarative
		return Optional.of(branchDto)
				.map(branch -> modelMapper.map(branch, Branch.class))
				.map(branchDao::save)
				.map(savedBranch -> modelMapper.map(savedBranch, BranchCreateRes.class))
				.orElseThrow(()-> new BranchCreationException("Failed to save branch"));
	}

	@Override
	public List<BranchCreateRes> getAllBranches() {
		
		List<Branch> branches = branchDao.findAll();
		if (branches.isEmpty()) {
	        return List.of();
	    }
		return branches.stream()
						.map(branch -> modelMapper.map(branch, BranchCreateRes.class))
						.collect(Collectors.toList());
	}

	@Override
	public BranchCreateRes getBranchbyId(String branchId) {
		
		Optional<Branch> branches = branchDao.findById(Integer.parseInt(branchId));
		
		if (branches.isEmpty()) {
	        return null;
	    }
		
//		Branch branch = branches.get();
//		BranchCreateRes branchResponseDto = modelMapper.map(branch, BranchCreateRes.class);
//		
//		return branchResponseDto;
		
		return branches.map(branch -> modelMapper.map(branch, BranchCreateRes.class)).orElse(null);
	}

	@Override
	public BranchCreateRes updateBranch(BranchCreateReq branchRequestDto, String branchId) {
		
//		Optional<Branch> branches = branchDao.findById(Integer.parseInt(branchId));	
//		Branch existingBranch = branches.get();

		Branch existingBranch = Optional.of(branchId)
				.map(id -> Integer.parseInt(id))
				.flatMap(branchDao::findById)
				.orElse(null);
		
		existingBranch = modelMapper.map(branchRequestDto, Branch.class);
		Branch updatedBranch = branchDao.save(existingBranch);		
		BranchCreateRes branchResponseDto = modelMapper.map(updatedBranch, BranchCreateRes.class);

		return branchResponseDto;
	}

	@Override
	public BranchUpdateRes updateBranchStatus(BranchUpdateReq branchUpdateReq, String branchId) {
		
		Branch branch = branchDao.findById(Integer.parseInt(branchId)).get();
		
		branch.setActive(branchUpdateReq.getActiveStatus());
		branchDao.save(branch);
		
		BranchUpdateRes branchUpdateRes = new BranchUpdateRes();
		branchUpdateRes.setUpdateMessage("Updated the branch active status to :"+branchUpdateReq.getActiveStatus());
		
		return branchUpdateRes;
		
	}

	@Override
	public List<BranchCreateRes> searchBranchByPincodeOrCity(String pincode, String city) {
		
		List<Branch> branches = branchDao.searchBranches(pincode, city);
		
		if(branches.isEmpty()) {
			return List.of();
		}
		
		return branches.stream()
				.map(branch -> modelMapper.map(branch, BranchCreateRes.class))
				.collect(Collectors.toList());
	}

	@Override
	public Page<BranchCreateRes> searchBranchByPincodeOrCityWithPagination(Pageable pageable, String pincode,
			String city) {
		
		Page<Branch> branches = branchDao.searchBranchesWithPagination(pageable, pincode, city);
		
		List<BranchCreateRes> branchList = branches.stream()
											.map(branch -> modelMapper.map(branch, BranchCreateRes.class))
											.collect(Collectors.toList());
		
		return new PageImpl<>(branchList, branches.getPageable(), branches.getTotalPages());
	}

}
