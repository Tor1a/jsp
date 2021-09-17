package com.jjang051.model;

public class MemberDto {
	private int no;
	private String id;
	private String password;
	private String name;
	private int zipCode;
	private String address;
	private String hp;
	private String email;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(int no, String id, String password, String name, int zipCode, String address,String hp, String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.email = email;
		this.hp = hp;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", zipCode="
				+ zipCode + ", address=" + address + ", email=" + email + "]";
	}
	

}
