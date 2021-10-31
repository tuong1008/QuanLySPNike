package ptithcm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;


import ptithcm.dao.CustomerDao;
import ptithcm.entity.Customer;
import ptithcm.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{

        @Autowired
        private CustomerDao customerDao;
	
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}

	
	@Override
	public Customer findCustomerByUsername(String username) {
		
		return customerDao.findUserByusername(username);
	}

	
	@Override
	public List<Customer> getAllCustomers() {
		
//		return (List<Customer>) customerDao.findAll();
                return null;
	}

	
	@Override
	public Customer getCustomerBycustomerId(long customerId) {
		
//		return customerDao.findOne(customerId);
                return null;
	}

	
	@Override
	public Customer findCustomerByusernameAndpassword(String username, String password) {
		
		return customerDao.findCustomerByUsernameAndPassword(username, password);
	}

	
	
	
	
}
