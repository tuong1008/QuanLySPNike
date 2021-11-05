package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProduct(Integer pageNumber) {
        return productDao.getAllProduct(pageNumber);
    }

    @Override
    public long getTotalProduct() {
        return productDao.getTotalProduct();
    }

    @Override
    public String addProduct(Product prdct) {
        return productDao.save(prdct);
    }

    @Override
    public String updateProduct(Product prdct) {
        return productDao.update(prdct);
    }

    @Override
    public String deleteProduct(Product prdct) {
        return productDao.delete(prdct);
    }

    @Override
    public Product getProductById(long l) {
        return productDao.findOne(l);
    }
}
