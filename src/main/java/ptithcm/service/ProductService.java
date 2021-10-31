package ptithcm.service;

import ptithcm.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProduct(Integer pageNumber);

    long getTotalProduct();

    String addProduct(Product product);

    String updateProduct(Product prdct);

    String deleteProduct(Product product);

    Product getProductById(long id);


}
