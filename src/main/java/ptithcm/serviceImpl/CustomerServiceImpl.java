package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CustomerDao;
import ptithcm.entity.Customer;
import ptithcm.service.CustomerService;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

//	@Autowired
//  private PasswordEncoder passwordEncoder;
    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            customerDao.update(customer);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerDao.findByUsername(username);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return customerDao.findByUsernameAndPassword(username, password);
    }

}
