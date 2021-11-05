package ptithcm.service;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomersByUsername(String username);

    Customer getCustomerById(long customerId);

    Customer findCustomerByUsernameAndpassword(String username, String password);

    List<Customer> getAllCustomers();
}
