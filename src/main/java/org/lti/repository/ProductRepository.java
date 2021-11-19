package org.lti.repository;

import java.util.List;

import org.lti.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	
	public List<Product> findAllByOrderByExpiryDateDesc();
	
	public Product findByDescription(String description);
}
