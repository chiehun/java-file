package com.freeflux;

import java.util.Arrays;

public class PollItemBean {

	private int poll_list_num; // 설문 번호
	private int poll_item_num; // 아이템 번호
	private String[] poll_item; // 아이템 내용
	private int poll_count; // 투표수
	
	public PollItemBean() {
	}

	public String toString() {
		String str="";
		str+=this.poll_list_num+" : 설문 번호__";
		str+=this.poll_item_num+" : 아이템 번호__";
		str+=Arrays.toString(this.poll_item)+" : 아이템 내용__";
		str+=this.poll_count+" : 투표수__";

		return str;
	}

	public int getPoll_list_num() {
		return poll_list_num;
	}

	public void setPoll_list_num(int poll_list_num) {
		this.poll_list_num = poll_list_num;
	}

	public int getPoll_item_num() {
		return poll_item_num;
	}

	public void setPoll_item_num(int poll_item_num) {
		this.poll_item_num = poll_item_num;
	}

	public String[] getPoll_item() {
		return poll_item;
	}

	public void setPoll_item(String[] poll_item) {
		this.poll_item = poll_item;
	}

	public int getPoll_count() {
		return poll_count;
	}

	public void setPoll_count(int poll_count) {
		this.poll_count = poll_count;
	}
	
	
}