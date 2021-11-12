/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import ptithcm.entity.CustomerOrder;

import java.util.List;

/**
 * @author Tuong
 */
public interface CustomerOrderService {
    String addCustomerOrder(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrderById(long customerOrderId);

    String removeCustomerOrder(CustomerOrder customerOrder);
    
    List<CustomerOrder> getAllCustomerOrders(Integer pageNumber);
    
    long getTotalCustomerOrders();
}
