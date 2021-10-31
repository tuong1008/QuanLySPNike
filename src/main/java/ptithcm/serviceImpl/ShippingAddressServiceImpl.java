/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.ShippingAddressDao;
import ptithcm.entity.ShippingAddress;
import ptithcm.service.ShippingAddressService;

/**
 * @author Tuong
 */
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    ShippingAddressDao shippingAddressDao;

    @Override
    public String addShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressDao.save(shippingAddress);
    }

}
