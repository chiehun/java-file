package com.hun.dto;

public class GoodsDTO {
	private int code =0;
	private String product = null;
	private String content = null;
	private int quantity = 0;
	
	private int discount =0;	
	private int delivery_change = 0;
	private int price = 0;
	private String name = null;	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getDelivery_change() {
		return delivery_change;
	}
	public void setDelivery_change(int delivery_change) {
		this.delivery_change = delivery_change;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String str=getCode()+"__";
		str+=getProduct()+"__";
		str+=getContent()+"__";
		str+=getQuantity()+"__";
		str+=getDiscount()+"__";
		str+=getDelivery_change()+"__";
		str+=getPrice()+"__";
		str+=getName()+"__";
		
		
		return str;
	}
}
