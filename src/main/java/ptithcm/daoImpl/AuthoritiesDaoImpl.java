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
import ptithcm.dao.AuthoritiesDao;
import ptithcm.entity.Authorities;

/**
 *
 * @author Tuong
 */
public class AuthoritiesDaoImpl extends AbstractDao<Authorities> implements AuthoritiesDao{

    @Override
    public Authorities findOne(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Authorities A WHERE A.username = :username";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        List<Authorities> list= query.list();
        t.commit();
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
}
