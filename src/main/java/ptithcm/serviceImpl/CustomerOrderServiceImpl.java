/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CustomerOrderDao;
import ptithcm.entity.CustomerOrder;
import ptithcm.service.CustomerOrderService;

import java.util.List;

/**
 * @author Tuong
 */
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderDao customerOrderDao;

    @Override
    public String addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDao.save(customerOrder);
    }

    @Override
    public CustomerOrder getCustomerOrderById(long l) {
        return customerOrderDao.findOne(l);
    }

    @Override
    public String removeCustomerOrder(CustomerOrder co) {
        return customerOrderDao.delete(co);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders(Integer intgr) {
        return customerOrderDao.getAllCustomerOrders(intgr);
    }

    @Override
    public long getTotalCustomerOrders() {
        return customerOrderDao.getTotalCustomerOrders();
    }

}
