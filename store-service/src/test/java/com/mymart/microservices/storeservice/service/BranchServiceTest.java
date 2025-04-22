package com.mymart.microservices.storeservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mymart.storeservice.dao.BranchDao;
import com.mymart.storeservice.dto.BranchCreateReq;
import com.mymart.storeservice.dto.BranchCreateRes;
import com.mymart.storeservice.entity.Branch;
import com.mymart.storeservice.service.BranchServiceImpl;

@ExtendWith(SpringExtension.class)
class BranchServiceTest {

	@MockBean
	private BranchDao branchDao;
	
	@MockBean
	private ModelMapper modelMapper;
	
	@InjectMocks
	private BranchServiceImpl branchService;
	
	@Test
	void testStoreBranch_success() {
		
		BranchCreateReq req = new BranchCreateReq(); // Set properties
        Branch branchEntity = new Branch(); // Set properties
        Branch savedBranch = new Branch(); // Simulate persisted branch
        BranchCreateRes res = new BranchCreateRes(); // Set expected response

        // Mock behavior
        Mockito.when(modelMapper.map(req, Branch.class)).thenReturn(branchEntity);
        Mockito.when(branchDao.save(branchEntity)).thenReturn(savedBranch);
        Mockito.when(modelMapper.map(savedBranch, BranchCreateRes.class)).thenReturn(res);

        // Act
        BranchCreateRes result = branchService.storeBranch(req);

        // Assert
        assertNotNull(result);
        assertEquals(res, result);
	}
}
