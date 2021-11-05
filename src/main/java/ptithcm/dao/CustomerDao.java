package ptithcm.dao;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerDao extends GenericDao<Customer> {
    Customer findByUsername(String username);

    Customer findByUsernameAndPassword(String username, String password);

    Customer findById(long customerId);

    List<Customer> findAll();
}
