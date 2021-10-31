/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.daoImpl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CustomerDao;
import ptithcm.entity.Customer;

/**
 *
 * @author Tuong
 */
@Transactional
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Customer findUserByusername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer C WHERE C.username = :username and C.password = :password";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Customer> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
