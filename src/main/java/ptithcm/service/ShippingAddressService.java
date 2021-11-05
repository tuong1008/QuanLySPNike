/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import ptithcm.entity.ShippingAddress;

/**
 * @author Tuong
 */
public interface ShippingAddressService {
    String addShippingAddress(ShippingAddress shippingAddress);
    String removeShippingAddress(ShippingAddress shippingAddress);
}
