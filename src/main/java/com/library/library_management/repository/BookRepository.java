package com.library.library_management.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.library.library_management.model.Book;

class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBook_id(rs.getInt("book_id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setIsbn(rs.getString("isbn"));
		book.setStatus(rs.getString("status"));
		return book;
	}

}

@Repository
public class BookRepository {

	private JdbcTemplate jdbcTemplate;

	public BookRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Book> getAvailableBooks() {
		 String sql = "SELECT * FROM Book WHERE status = 'Available'";
		 return jdbcTemplate.query(sql, new BookRowMapper());
	}

}
