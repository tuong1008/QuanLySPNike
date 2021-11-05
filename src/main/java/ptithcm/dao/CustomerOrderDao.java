/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.dao;

import java.util.List;
import ptithcm.entity.Cart;
import ptithcm.entity.CustomerOrder;

/**
 *
 * @author Tuong
 */
public interface CustomerOrderDao extends GenericDao<CustomerOrder>{
    List<CustomerOrder> findAll();
    CustomerOrder findOne(long customerOrderId);    
}
