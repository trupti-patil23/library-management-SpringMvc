package com.library.library_management.repository;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.library_management.exception.ResourceNotFoundException;

@Repository
public class BorrowRequestRepository {

	private JdbcTemplate jdbcTemplate;

	public BorrowRequestRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean createBorrowRequest(String studentEmail, int bookId) {		
		try {
			// Fetch student_id
			Object[] params = { studentEmail };
			int[] types = { Types.VARCHAR };
			String studentIdQuery = "SELECT student_id FROM Student WHERE email = ?";
			Integer studentId = jdbcTemplate.queryForObject(studentIdQuery, params, types, Integer.class);
			if (studentId == null) {
				throw new ResourceNotFoundException("Student not found with email: " + studentEmail);
			}
		
			// Insert borrow request
			String insertBorrowRequestQuery = "INSERT INTO BorrowRequest (student_id, book_id, status) VALUES (?, ?, 'Pending')";
			int rowInserted = jdbcTemplate.update(insertBorrowRequestQuery, studentId, studentId);
						
			// After borrowing successfully, Update status as "Borrowed" in Book table
			if (rowInserted > 0) {
				// Update book status
				String updateBookStatusQuery = "UPDATE BOOK SET status='Borrowed' WHERE book_id = ?";
				jdbcTemplate.update(updateBookStatusQuery, bookId);

			}
			return rowInserted > 0;
		} catch (ResourceNotFoundException e) {
			throw e; // Propagate custom exceptions
		} catch (Exception e) {
			throw new RuntimeException("Unexpected error occurred while creating Borrow Request: " + e.getMessage(), e);
		}
	}

}
