package com.freeflux.dto;
/** DTO 역할 **/
public class BoardModel {

	/** 외부 접근 불가능 : 값추출 : get~~() return /  값설정 : set~~~(매개변수) **/
	private int no = 0;
	private String subject = null;
	private String writer = null;
	private String contents = null;
	private int hit = 0;

	public BoardModel() {
	}

	/** Object.class의 toString() 재정의 : Override **/
	public String toString() {
		String str = "==> ";
		str += this.no + "__";
		str += this.subject + "__";
		str += this.writer + "__";
		str += this.contents + "__";
		str += this.hit + " <==";
		return str;
	}

	/** 아래는 private 변수들에 대한 getter/setter 들  **/
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
}
