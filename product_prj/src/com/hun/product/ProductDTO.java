package com.hun.product;

public class ProductDTO {
	private int code = 0;
	private String name = null;
	private int price = 0;
	private String description =null;
	private String pictureurl = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String str = "";
		str += this.code + "< 번호__"; // 설문 번호 num 중 가장 큰 값
		str += this.name + "< 제목"; // itemdml index
		str += this.price;
		return str;

	}
}
