//모든 필드를 한꺼번에 채울 수 있는 MemberDto

package com.jjang051.model;

public class MemberDto {
	private int no;
	private String id;
	private String name;
	private String password;
	private int zipcode;
	private String address;
	private String hp;
	private String email;
	

	public MemberDto(int no, String id, String name, String password, int zipcode, String address, String hp,
			String email) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.zipcode = zipcode;
		this.address = address;
		this.hp = hp;
		this.email = email;
	}
	public MemberDto() {
		super();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
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
		return "MemberDto [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", zipcode="
				+ zipcode + ", address=" + address + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
	
	//getter / setter,  생성자,  toString
}
