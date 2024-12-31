package com.library.library_management.model;

public class Student {
	private int studentId;
	private String name;
	private String email;
	private String password;
	private boolean overdueStatus;
	
    public Student() {}

	public Student(int studentId, String name, String email, String password, boolean overdueStatus) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.overdueStatus = overdueStatus;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isOverdueStatus() {
		return overdueStatus;
	}

	public void setOverdueStatus(boolean overdueStatus) {
		this.overdueStatus = overdueStatus;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", overdueStatus=" + overdueStatus + "]";
	}

}
