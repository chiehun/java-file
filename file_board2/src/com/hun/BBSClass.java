package com.hun;

public class BBSClass {
	private int seqno = 0;
	private String title =null;
	private String content =null;
	private String writer  =null;
	
	public BBSClass() {
		// TODO Auto-generated constructor stub
	}
	
	public BBSClass(int seqno, String title, String content, String writer) {
		this.seqno=seqno;
		this.title=title;
		this.content=content;
		this.writer=writer;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}
