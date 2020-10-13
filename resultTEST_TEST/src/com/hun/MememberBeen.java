package com.hun;

public class MememberBeen {
private String name;
private String email;
private String address;
	public MememberBeen() {
		System.out.println("memberBeen 객체 생성");
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
