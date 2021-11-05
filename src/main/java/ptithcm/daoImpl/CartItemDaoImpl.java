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
import ptithcm.dao.CartItemDao;
import ptithcm.entity.CartItem;

/**
 *
 * @author Tuong
 */
@Transactional
public class CartItemDaoImpl extends AbstractDao<CartItem> implements CartItemDao{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List<CartItem> findByCartId(long cartId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CartItem C WHERE C.cart.cartId = :cartId";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("cartId", cartId);
        List<CartItem> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public CartItem findOne(long cartItemId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM CartItem C WHERE C.cartItemId = :cartItemId";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("cartItemId", cartItemId);
        List<CartItem> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
