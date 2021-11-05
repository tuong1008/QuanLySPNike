/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CustomerOrderDao;
import ptithcm.entity.CustomerOrder;
import ptithcm.service.CustomerOrderService;

/**
 *
 * @author Tuong
 */
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderDao customerOrderDao;
    
    @Override
    public String addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDao.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrder() {
        return customerOrderDao.findAll();
    }

    @Override
    public CustomerOrder getCustomerOrderById(long l) {
        return customerOrderDao.findOne(l);
    }

    @Override
    public String removeCustomerOrder(CustomerOrder co) {
        return customerOrderDao.delete(co);
    }
    
}
