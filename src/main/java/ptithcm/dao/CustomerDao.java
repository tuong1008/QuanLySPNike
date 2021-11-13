package ptithcm.dao;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerDao extends GenericDao<Customer> {
    Customer findByUsername(String username);

    Customer findByUsernameAndPassword(String username, String password);

    Customer findById(long customerId);

    List<Customer> findAll();
    
    List<Customer> getAllCustomers(Integer pageNumber);
    
    long getTotalCustomers();
    
    List<Customer> findAllCustomerByUsernameOrEmail(String searchTerm, int pagaNumber);
    
    long getTotalCustomerByUsernameOrEmail(String searchTerm);
}
