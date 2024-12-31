package com.library.library_management.model;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String isbn;
    private String status;

    // Constructors
    public Book() {}

	public Book(int book_id, String title, String author, String isbn, String status) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.status = status;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", status="
				+ status + "]";
	}

	
}
