package com.mymart.storeservice.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mymart.storeservice.exceptions.BranchCreationException;
import com.mymart.storeservice.exceptions.BranchNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BranchCreationException.class)
	public ResponseEntity<Map<String, Object>> handlerBranchCreationException(BranchCreationException ex){
		
		Map<String, Object> errorBody = new HashMap<>();
		errorBody.put("time", LocalDateTime.now());
		errorBody.put("error", "Branch creation failed");
		errorBody.put("message", ex.getMessage());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return ResponseEntity.internalServerError().body(errorBody);
		
	}
	
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handlerBranchNotFoundException(BranchNotFoundException ex){
		
		Map<String, Object> errorBody = new HashMap<>();
		errorBody.put("time", LocalDateTime.now());
		errorBody.put("error", "branch not found");
		errorBody.put("message", ex.getMessage());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return ResponseEntity.internalServerError().body(errorBody);
	}
	
	 @ExceptionHandler(RuntimeException.class)
     public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
	 
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("error", "server Error");
        errorBody.put("message", ex.getMessage());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
