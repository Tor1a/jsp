package com.jjang051.model;

public class BoardDto {
	//필드....
	private int no;
	private String name;
	private String email;
	private String subject;
	private String password;
	private String contents;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int no, String name, String email, String subject, String password, String contents) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.password = password;
		this.contents = contents;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", name=" + name + ", email=" + email + ", subject=" + subject + ", password="
				+ password + ", contents=" + contents + "]";
	}
}
