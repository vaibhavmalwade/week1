package org.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.lti.dto.ProductDto;
import org.lti.exception.ItemNotFoundException;
import org.lti.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	
	
	public Product save(ProductDto  dto);
	
	public ProductDto getByid(Integer id);
	
	public List<Product>getAllProduct()throws ItemNotFoundException;
	
	public LocalDate calcalulateExpiryDate(Integer id);
	
	public Integer deleteExpiredProduct();
	
	public List<Product> decOrderByExpiryDate();
	
    public ProductDto getByDescrption(String desc)throws ItemNotFoundException;	
    
    public Integer discount();
    

}
