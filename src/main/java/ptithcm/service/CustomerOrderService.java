/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import java.util.List;
import ptithcm.entity.CustomerOrder;

/**
 *
 * @author Tuong
 */
public interface CustomerOrderService {
    String addCustomerOrder(CustomerOrder customerOrder);
    List<CustomerOrder> getAllCustomerOrder();
    CustomerOrder getCustomerOrderById(long customerOrderId);
    String removeCustomerOrder(CustomerOrder customerOrder);
}
