package com.dto;

public class hairVO {
	//회원 관리 dto
private String id;
private String pw;
private String name;
private String phoneNumber;
private String address;
private String enroll;

//예약 테이블
private String rsv_date;
private String rsv_time;
private String rsv_status;
private String p_type;

//관리자 테이블 
private String workerid;
private String workerpw;
	public hairVO() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		String str =this.id ;
		str=str+this.pw;
		str=str+this.name;
		str=str+this.phoneNumber;
		str=str+this.address;
		str=str+this.enroll;
		str=str+this.rsv_date;
		str=str+this.rsv_time;
		str=str+this.rsv_status;
		str=str+this.p_type;
		str=str+this.workerid;
		str=str+this.workerpw;
		return str;		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phone) {
		this.phoneNumber = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEnroll() {
		return enroll;
	}
	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}
	public String getRsv_date() {
		return rsv_date;
	}
	public void setRsv_date(String rsv_date) {
		this.rsv_date = rsv_date;
	}
	public String getRsv_time() {
		return rsv_time;
	}
	public void setRsv_time(String rsv_time) {
		this.rsv_time = rsv_time;
	}
	public String getRsv_status() {
		return rsv_status;
	}
	public void setRsv_status(String rsv_status) {
		this.rsv_status = rsv_status;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getWorkerpw() {
		return workerpw;
	}
	public void setWorkerpw(String workerpw) {
		this.workerpw = workerpw;
	}
	
	
}
