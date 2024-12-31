package com.library.library_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_management.exception.ResourceNotFoundException;
import com.library.library_management.repository.BorrowRequestRepository;

@Service
public class BorrowRequestService {
	
	@Autowired
	private BorrowRequestRepository borrowRequestRepo;
	
	public boolean createBorrowRequest(String studentEmail, int bookId) {
		try {
			return borrowRequestRepo.createBorrowRequest(studentEmail, bookId);
		} catch (ResourceNotFoundException e) {
            // Log the error and throw
            System.err.println("Resource not found: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            // Log unexpected errors and throw as generic exception
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("An error occurred while processing the borrow request.");
        }
	}

}
