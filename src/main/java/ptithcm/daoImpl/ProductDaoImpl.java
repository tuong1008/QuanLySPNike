/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;

import java.util.List;

/**
 * @author Tuong
 */
@Transactional
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {

    @Override
    public List<Product> getAllProduct(Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product C";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Product> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalProduct() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Product C";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    @Override
    public Product findOne(long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product P where P.productId = :id";
        Transaction t = session.beginTransaction();

        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Product> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Product> getAllProductInStock(Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product C where C.unitInStock<>0";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Product> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Product> findAllProductByNameorCategory(String searchTerm, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product t WHERE t.productCategory LIKE :searchTerm OR t.productName LIKE :searchTerm";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Product> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalProductByNameorCategory(String string) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Product t WHERE t.productCategory LIKE :searchTerm OR t.productName LIKE :searchTerm";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(string));
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    @Override
    public List<Product> getAllProductByCategoryInStock(String category, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product t WHERE t.productCategory = :category and t.unitInStock<>0";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("category", category);
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Product> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalProductByCategoryInStock(String category) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Product t WHERE t.productCategory = :category and t.unitInStock<>0";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("category", category);
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    @Override
    public List<Product> findAllProductByNameInStock(String searchTerm, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product t WHERE t.productName LIKE :searchTerm and t.unitInStock<>0";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(pageNumber * 10); //đến 9

        List<Product> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalProductByNameInStock(String searchTerm) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select count(*) FROM Product t WHERE t.productName LIKE :searchTerm and t.unitInStock<>0";
        Transaction t = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }
}
