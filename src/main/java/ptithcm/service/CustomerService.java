package ptithcm.service;

import java.util.List;

import ptithcm.entity.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public Customer findCustomerByUsername(String username);
	
	List<Customer> getAllCustomers();
	
	public Customer getCustomerBycustomerId(long customerId);
	
	Customer findCustomerByusernameAndpassword(String username,String password);
}
