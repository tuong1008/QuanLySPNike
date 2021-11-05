package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CustomerDao;
import ptithcm.entity.Customer;

import java.util.List;
@Transactional
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Customer findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Customer c where c.username=:username");

        return (Customer) query.list().get(0);
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "FROM Customer c WHERE c.username=:username AND c.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);

        return (Customer) query.list().get(0);
    }

    @Override
    public Customer findById(long customerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "FROM Customer c WHERE c.customerId=:id");
        query.setParameter("id", customerId);
        return (Customer) query.list().get(0);
    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "FROM Customer c");
        return query.list();
    }
}
