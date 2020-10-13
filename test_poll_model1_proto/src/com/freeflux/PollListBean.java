package com.freeflux;

public class PollListBean {
//설문주제, 설문 종료일, 시작인 날짜
	private int num; // 설문 번호
	private String question; // 설문 내용
	private String sdate; // 투표 시작 날짜
	private String edate; // 투표 종료 날짜
	private String wdate; // 설문 작성 날짜
	private int types; // 중복투표 허용 여부
	private int active; // 설문 활성화 여부

	public PollListBean() {
	}
	
	public String toString() {
		String str="";
		str+=this.num+" : 설문 번호__";
		str+=this.question+" : 설문 내용__";
		str+=this.sdate+" : 투표 시작 날짜__";
		str+=this.edate+" : 투표 종료 날짜__";
		str+=this.wdate+" : 설문 작성 날짜__";
		str+=this.types+" : 중복투표 허용 여부__";
		str+=this.active+" : 설문 활성화 여부__";
		return str;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}