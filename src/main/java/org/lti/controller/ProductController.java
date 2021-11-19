package org.lti.controller;

import java.time.LocalDate;
import java.util.List;

import org.lti.dto.ProductDto;
import org.lti.exception.ResourceNotFoundException;
import org.lti.model.Product;
import org.lti.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ProductDto product) {
	  Product p=service.save(product);	
	  if(p==null) {
		  return new ResponseEntity<String>("Product Not Saved",HttpStatus.FAILED_DEPENDENCY);
	  }
	  return new ResponseEntity<Product>(p,HttpStatus.CREATED); 
	}
	
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<?>getallProducts() throws ResourceNotFoundException{
		System.out.println("getAllProduct");
		List<Product>productId=service.getAllProduct();
		if(!productId.isEmpty()) {
			return new ResponseEntity<List<Product>>(productId,HttpStatus.OK);
		}else
			 throw new ResourceNotFoundException("Product ID Not Found In DataBase");
		
		  //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/getproductByProductNameDec")
   public ResponseEntity<?>getProductsByProductNameDec() throws ResourceNotFoundException{
	
	   List<Product>productId=service.decOrderByProductName();
	   if(productId.isEmpty()) 
		   throw new ResourceNotFoundException("Product Not Found");
	   
	   return new ResponseEntity<List<Product>>(productId,HttpStatus.OK);
	   
   }
    @GetMapping("/Category/{id}")
	private ResponseEntity<?> setExpiryProductCategory(@PathVariable("id")Integer id) throws ResourceNotFoundException {
	  LocalDate Category=service.Category(id);
	  
		if(Category!=null) {
			return new ResponseEntity<>(Category,HttpStatus.OK);
		}else
			throw new ResourceNotFoundException("Product Not Found");
	}
  @GetMapping("/Quantity/")
	private ResponseEntity<?> setExpiryProductQuantity(@PathVariable("id")Integer id) throws ResourceNotFoundException {
	  LocalDate Quantity=service.Quantity(id);
	  
		if(Quantity!=null) {
			return new ResponseEntity<>(Quantity,HttpStatus.OK);
		}else
			throw new ResourceNotFoundException("Product Not Found");
	}
	@GetMapping("/UnitPrice/")
	private ResponseEntity<?> setExpiryProductUnitPrice(@PathVariable("id")Integer id) throws ResourceNotFoundException {
	  LocalDate UnitPrice=service.UnitPrice(id);
	  
		if(UnitPrice!=null) {
			return new ResponseEntity<>(UnitPrice,HttpStatus.OK);
		}else
			throw new ResourceNotFoundException("Product Not Found");
	}
   
      
   @GetMapping("/TotalPrice/")
	private ResponseEntity<?> setExpiryProductTotalPrice(@PathVariable("id")Integer id) throws ResourceNotFoundException {
	  LocalDate TotalPrice=service.TotalPrice(id);
	  
		if(TotalPrice!=null) {
			return new ResponseEntity<>(TotalPrice,HttpStatus.OK);
		}else
			throw new ResourceNotFoundException("Product Not Found");
	}

   
}

    @GetMapping("/Rating/")
	private ResponseEntity<?> setExpiryProductRating(@PathVariableInteger) throws ResourceNotFoundException {
	  LocalDate Rating=service.Rating;
	  
		if(Rating!=null) {
			return new ResponseEntity<>(Rating,HttpStatus.OK);
		}else
			throw new ResourceNotFoundException("Product Not Found");
	}

   
}
