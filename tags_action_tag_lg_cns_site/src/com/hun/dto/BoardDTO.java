package com.hun.dto;

import java.sql.Date;

public class BoardDTO {
	private int no = 0;
	private String subject = null;	//등록 일시
	private String writer = null;	//수정일
	private String contents = null;
	private int hit = 0;
	
	/** 아래의 변수들 선언후 , getter /setter 추가**/
	private String regdate;	//등록일시
	private String moddate ;	//수정일시
	
	private String pageNum ="1";	//페이지 번호
	private String searchType = "";	//검색 항목
	private String searchText = "";	//검색어
	private int listCount = 10;		//목록페이지 게시물 노출 수
	private int pagePerBlock = 10;	//목록 페이지 네비케이터 블록 

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		String str = "==> ";
		str += this.no + "__";
		str += this.subject + "__";
		str += this.writer + "__";
		str += this.contents + "__";
		str += this.hit + " <==";
		str += this.regdate+ "__";
		str += this.moddate+ " <==";
		str += this.pageNum+ " <==";
		str += this.searchType+ "__";
		str += this.searchText+ "__";
		return str;
	}
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	
}
