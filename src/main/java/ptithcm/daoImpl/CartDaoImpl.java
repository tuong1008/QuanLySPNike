/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CartDao;
import ptithcm.entity.Cart;

import java.util.List;

/**
 * @author Tuong
 */
@Transactional
public class CartDaoImpl extends AbstractDao<Cart> implements CartDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Cart findOne(long cartId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Cart C WHERE C.cartId = :cartId";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("cartId", cartId);

        List<Cart> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
