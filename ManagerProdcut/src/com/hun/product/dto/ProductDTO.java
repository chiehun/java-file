package com.hun.product.dto;

public class ProductDTO {
	private String name = null;
	private Integer pseq = 0;
	private Integer price = 0;
	private String indate = null;
	private String content = null;

	public ProductDTO() {
		
	}
	public String toString() {
		String str = this.getPseq()+"_____";
				str=this.getContent() + "_______";
				str=this.getIndate()+ "_______";
				str=this.getName()+ "_______";
				str=this.getContent()+ "_______";
				return str;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPseq() {
		return pseq;
	}

	public void setPseq(Integer pseq) {
		this.pseq = pseq;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
