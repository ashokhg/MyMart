package com.mymart.storeservice.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mymart.storeservice.entity.Branch;

@Repository
public interface BranchDao extends JpaRepository<Branch, Integer>{

	@Query("SELECT b FROM Branch b WHERE (:city IS NULL OR b.location.city = :city) AND (:pincode IS NULL OR b.location.pincode =:pincode)")
	List<Branch> searchBranches(String pincode, String city);
	
	@Query("SELECT b FROM Branch b WHERE (:city IS NULL OR b.location.city = :city) AND (:pincode IS NULL OR b.location.pincode =:pincode)")
	Page<Branch> searchBranchesWithPagination(Pageable pageable, String pincode, String city);
}
