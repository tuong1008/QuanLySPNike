package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
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
        String hql = "FROM Customer C WHERE C.username = :username";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer C WHERE C.username = :username and C.password = :password";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public Customer findById(long customerId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer c WHERE c.customerId=:id";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", customerId);
        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer c";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Customer> getAllCustomers(Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer C where C.username<>'admin'";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(10); //đến 9

        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalCustomers() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Customer C";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    @Override
    public List<Customer> findAllCustomerByUsernameOrEmail(String searchTerm, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Customer t WHERE (t.username LIKE :searchTerm OR t.customerEmailAddress LIKE :searchTerm) and t.username<>'admin'";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Customer> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalCustomerByUsernameOrEmail(String searchTerm) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Customer t WHERE t.username LIKE :searchTerm OR t.customerEmailAddress LIKE :searchTerm";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }
}
