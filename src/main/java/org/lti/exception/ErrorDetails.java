package org.lti.exception;

import java.util.Date;

public class ErrorDetails {

	
	private Integer productId;
	private String Name;
	private String Category;
	public ErrorCategory(Integer productId, String Name, String Category) {
		super();
		this.productId = productId;
		this.Name = Name;
		this.Category = Category;
	}
	public Integer getproductId() {
		return productId;
	}
	public void setproductId(Date productId) {
		this.productId = productId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getCategory() {
		return Category;
	}
	
	
	
}
