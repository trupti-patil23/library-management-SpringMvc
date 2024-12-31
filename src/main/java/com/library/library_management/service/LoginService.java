package com.library.library_management.service;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_management.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepo;

	public boolean authenticateUser(String userType, String email, String password) {
		if ("Student".equals(userType)) {
			return userRepo.validateStudent(email, password);
		} else if ("Librarian".equals(userType)) {
			return userRepo.validateLibrarian(email, password);
		}
		return false;
	}

}
