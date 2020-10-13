package com.hun.dto;

import java.sql.Timestamp;

public class BoardVO {
private Integer num;
private String name;
private String email;
private String pass;
private String title;
private String content;
private Integer readcount;
private Timestamp writedate;
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		String str =this.num+"str_____";
		str =this.num+"str_____";
		str =this.name+"str_____";
		str =this.email+"str_____";
		str =this.pass+"str_____";
		str =this.title+"str_____";
		str =this.content+"str_____";
		str =this.readcount+"str_____";
		str = this.writedate+"str_____";
		return str;		
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getReadcount() {
		return readcount;
	}
	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	
}
