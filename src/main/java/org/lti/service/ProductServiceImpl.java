package org.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.lti.dto.ProductDto;
import org.lti.exception.ItemNotFoundException;
import org.lti.model.Product;
import org.lti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepository repo;

	

	@Override
	public ProductDto getByid(Integer id) {
		ProductDto dto=new ProductDto();
		Product p=repo.getOne(id);
		if(p!=null) {
			dto.setId(p.getId());
			dto.setDescription(p.getDescription());
			dto.setExpiryDate(p.getExpiryDate());
			dto.setPrice(p.getPrice());
			dto.setQty(p.getQty());
			dto.setUseBeforeMonths(p.getUseBeforeMonths());
			dto.setManufactureDate(p.getManufactureDate());
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct()  {
     List<Product>productList=repo.findAll();
		try {
			if(productList.isEmpty()!=true) 
				return productList;
				else
					throw new ItemNotFoundException("Product Not Founds");
         } catch (Exception e) {
	
            }
		return null;
	}


	//1 Reqr
	@Override
	public LocalDate calcalulateExpiryDate(Integer id) {

		Product p=repo.getOne(id);
		if(p!=null) {
			LocalDate ExpiryDate=p.getManufactureDate().plusMonths(p.getUseBeforeMonths());
			p.setExpiryDate(ExpiryDate);
			Product pp=	repo.save(p);		
			if(pp!=null) {
				return pp.getExpiryDate();
			}
		}
		return null;
	}



	@Override
	public Integer deleteExpiredProduct() {
		List<Product>productList=repo.findAll();
		if(productList.size()>0){
			Integer count=0;
			LocalDate today
			= LocalDate.now();
			for(Product p:productList) {
				if(p.getExpiryDate().isAfter(today)) {
					repo.delete(p);
					count++;
				}
			}
			return count;
		}
		return null;
	}



	@Override
	public List<Product> decOrderByExpiryDate() {
		List<Product>decOrder=repo.findAll(Sort.by(Sort.Direction.DESC, "expiryDate"));

		return decOrder;
	}

	@Override
	public ProductDto getByDescrption(String desc) {
		
		try {
			Product p=repo.findByDescription(desc);
			if(p==null)
				throw new ItemNotFoundException("Product Not Found");

			ProductDto d=new ProductDto();
			d.setId(p.getId());
			d.setDescription(p.getDescription());
			d.setPrice(p.getPrice());
			d.setManufactureDate(p.getManufactureDate());
			d.setQty(p.getQty());
			d.setExpiryDate(p.getExpiryDate());
			d.setUseBeforeMonths(p.getUseBeforeMonths());
			return d;
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return null;
	}

	@Override
	public Product save(ProductDto dto) {
		Product p=new Product();
		p.setId(dto.getId());
		p.setPrice(dto.getPrice());
		p.setQty(dto.getQty());
		p.setDescription(dto.getDescription());
		LocalDate today
		= LocalDate.now();
		p.setManufactureDate(today);
		p.setUseBeforeMonths(dto.getUseBeforeMonths());
		
		Product SavedProduct=repo.save(p);
		return SavedProduct;
	}

	@Override
	public Integer discount() {
  List<Product>listProduct=repo.findAll();
  Integer dis=0;
    try {
    	
		if(listProduct!=null) {
			if(listProduct.size()>0) {
				LocalDate today
				= LocalDate.now();
				for(Product p:listProduct) {
					
					if(today.isAfter(p.getExpiryDate().minusMonths(6))){
			//  if(p.getExpiryDate().minusMonths(6).isAfter(today)) {
				  double discount=p.getPrice()-((((double) 20) / 100) * p.getPrice());
				  System.out.println("id ="+p.getId());
	                 System.out.println(p.getPrice());
	                 System.out.println("discountPrice="+discount);
				    p.setPrice(discount);
				    repo.save(p);
				    dis++;  
			  }
			   
				}
				
			}
		}
	} catch (Exception e) {
		
		
	}
	return dis;
		
	}

	



}