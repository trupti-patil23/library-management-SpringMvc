package com.library.library_management.repository;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private JdbcTemplate jdbcTemplate;

	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean validateStudent(String email, String password) {
		Object[] params = { email, password };
		int[] types = { Types.VARCHAR, Types.VARCHAR };
		String sql = "SELECT COUNT(*) FROM Student WHERE email = ? AND password = ?";
		Integer count = jdbcTemplate.queryForObject(sql, params, types, Integer.class);
		return count != null && count > 0;
	}

	public boolean validateLibrarian(String email, String password) {
		Object[] params = { email, password };
		int[] types = { Types.VARCHAR, Types.VARCHAR };
		String sql = "SELECT COUNT(*) FROM Librarian WHERE email = ? AND password = ?";
		Integer count = jdbcTemplate.queryForObject(sql, params, types, Integer.class);
		return count != null && count > 0;
	}

}
