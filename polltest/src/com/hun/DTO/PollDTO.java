package com.hun.DTO;

public class PollDTO {
private int num=0;
private String question = null;
private String sdate= null;
private String edate= null;
private String wdate= null;
private String type= null;
private int active= 0;
private int listnum=0;
private int itemnum =0;
private String item =null;
private int count =0;

	public PollDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String str = "==> ";
		str += this.num + "__";
		str += this.question + "__";
		str += this.sdate + "__";
		str += this.edate + "__";
		str += this.wdate + " <==";
		str += this.type + " <==";
		str += this.active + " <==";
		str += this.listnum + " <==";
		str += this.itemnum + " <==";
		str += this.item + " <==";
		str += this.count + " <==";
		
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getListnum() {
		return listnum;
	}
	public void setListnum(int listnum) {
		this.listnum = listnum;
	}
	public int getItemnum() {
		return itemnum;
	}
	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
