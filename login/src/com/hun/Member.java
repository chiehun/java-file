package com.hun;

import java.util.Date;
import java.util.Map;

public class Member {//각자 데이터를 선언하는 클래스

	private String id;
	private String name;
	private String password;
	private Date regDate;// 날짜 시간 언제 로그인 했는지 데이터를 남기는 것
	
	public Member(String id, String name, String password, Date regDate) {
		this.id=id;
		this.name= name;
		this.password= password;
		this.regDate= regDate;
	
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd); // 비밀번호 확인 코드
	}
	
	}

