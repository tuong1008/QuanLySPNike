/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import ptithcm.entity.BillingAddress;

/**
 * @author Tuong
 */
public interface BillingAddressService {
    String addBillingAddress(BillingAddress billingAddress);
    String removeBillingAddress(BillingAddress billingAddress);
}
