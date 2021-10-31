package ptithcm.dao;

import ptithcm.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {

    List<Product> getAllProduct(Integer pageNumber);

    Product findOne(long id);

    long getTotalProduct();


//	@Query("SELECT t FROM Product t WHERE t.productCategory = :category AND t.productModel LIKE %:searchTerm%  OR  t.productCategory = :category AND t.productBrand LIKE %:searchTerm%")
//	Page<Product> findAllProductByBrandOrModel(@Param("searchTerm")String searchTerm,@Param("category")String category,Pageable pageable);
//	
//	
//	@Query("SELECT t FROM Product t WHERE t.productCategory = :searchTerm OR t.productModel LIKE %:searchTerm%  OR   t.productBrand LIKE %:searchTerm%")
//	Page<Product> findAllProductByBrandOrModelorCategory(@Param("searchTerm")String searchTerm,Pageable pageable);
}
