package ptithcm.service;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer findCustomerByUsername(String username);

    List<Customer> getAllCustomers();

    Customer getCustomerBycustomerId(long customerId);

    Customer findCustomerByusernameAndpassword(String username, String password);
}
