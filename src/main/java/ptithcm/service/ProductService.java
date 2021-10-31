package ptithcm.service;

import java.util.List;

import ptithcm.entity.Product;

public interface ProductService {

	
	List<Product> getAllProduct(Integer pageNumber);
	
        long getTotalProduct();
        
        String addProduct(Product product);
        
        String updateProduct(Product prdct);
        
        String deleteProduct(Product product);
        
        Product getProductById(long id);
	
	
	
	
	
	
}
