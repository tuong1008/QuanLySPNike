package ptithcm.service;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerByUsername(String username);

    Customer getCustomerById(long customerId);

    Customer findCustomerByUsernameAndPassword(String username, String password);

    List<Customer> getAllCustomers();

}
