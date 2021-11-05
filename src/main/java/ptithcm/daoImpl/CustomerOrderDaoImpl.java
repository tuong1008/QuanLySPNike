/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.daoImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.dao.CustomerOrderDao;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.entity.CustomerOrder;

/**
 *
 * @author Tuong
 */
public class CustomerOrderDaoImpl extends AbstractDao<CustomerOrder> implements CustomerOrderDao{

    @Override
    public List<CustomerOrder> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CustomerOrder C";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);        
        List<CustomerOrder> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public CustomerOrder findOne(long customerOrderId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CustomerOrder C where C.customerOrderId = :customerOrderId";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);  
        query.setParameter("customerOrderId", customerOrderId);
        List<CustomerOrder> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
