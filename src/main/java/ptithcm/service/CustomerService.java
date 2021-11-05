package ptithcm.service;

import java.util.List;

import ptithcm.entity.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);
        
        public String updateCustomer(Customer customer);
        
	public Customer findCustomerByUsername(String username);
	
	List<Customer> getAllCustomers();
	
	public Customer getCustomerBycustomerId(long customerId);
	
	Customer findCustomerByusernameAndpassword(String username,String password);
}
