/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import ptithcm.entity.Cart;
import ptithcm.entity.Product;

/**
 * @author Tuong
 */
public interface CartService {
    String addCart(Cart cart);

    String updateCart(Cart cart);

    String removeCart(Cart cart);

    Cart getCartById(long cartId);
    
    Product checkAndUpdateProductsInCart(Cart cart);
}
