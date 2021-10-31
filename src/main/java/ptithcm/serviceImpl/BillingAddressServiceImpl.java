/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.BillingAddressDao;
import ptithcm.entity.BillingAddress;
import ptithcm.service.BillingAddressService;

/**
 * @author Tuong
 */
public class BillingAddressServiceImpl implements BillingAddressService {

    @Autowired
    BillingAddressDao billingAddressDao;

    @Override
    public String addBillingAddress(BillingAddress billingAddress) {
        return billingAddressDao.save(billingAddress);
    }

}
