package com.library.library_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_management.model.Book;
import com.library.library_management.repository.BookRepository;

@Service
public class StudentDashboardService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAvailableBooks() {		
		return bookRepo.getAvailableBooks();		
	}
}
