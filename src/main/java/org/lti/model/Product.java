package org.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Product {

	
	@Id
	private Integer id;
	@Column(name="description",nullable = false)
	private String description;
	@Column(name="Category")
	private Integer Category;
	@Column(name="quantity")
	private Integer qty;
	@Column(name="Unitprice")
	private unitprice;
	@Column(name="Totalprice")
	private Totalprice;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCategory() {
		return Category;
	}
	public void getCategory(Integer Category) {
		this.Category = Category;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void getQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}
	public Integer getunitprice() {
		return price;
	}
	public void setunitprice{
		this.unitprice = unitprice;
	}
	
	public Interger TotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice {
		this.expiryDate = TotalPrice;
	}
	@Override
	public String toString() {
		return "Product [Productid=" + Productid + ", description=" + description + ", Quantity=" + Quantity + ", Unitprice=" + Unitprice
				+ ", TotalPrice=" + TotalPrice + "]";
	}
	public Product() {
		super();
	}

	
}
