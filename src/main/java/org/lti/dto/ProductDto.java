package org.lti.dto;

import java.time.LocalDate;

public class ProductDto {

	private Integer id;
	private String decOrderByProductName;
	private String Category;
	private Integer Quantity;
	
	private String description;

	private Integer UnitPrice;
	
	private Total price;
	private Integer Rating;
	private String productId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String decOrderByProductName) {
		this.decOrderByProductName = decOrderByProductNametion;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer UnitPrice) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Total price) {
		this.price = price;
	}

	public Integer UnitPrice() {
		return UnitPrice;
	}
	public void setUseBeforeMonths(Integer TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public Integer getTotalPrice() {
		return TotalPrice;
	}
	public void setExpiryDate(Integer TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public void setExpiryProductRating(Interger Rating){
		this.Rating = Rating;
	}
}
