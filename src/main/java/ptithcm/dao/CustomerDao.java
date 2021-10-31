package ptithcm.dao;




import ptithcm.entity.Customer;

public interface CustomerDao extends GenericDao<Customer>{

	Customer findUserByusername(String username);
	
	Customer findCustomerByUsernameAndPassword(String username,String password);
	
}
