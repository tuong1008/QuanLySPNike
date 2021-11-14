/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.dao;

import ptithcm.entity.Cart;
import ptithcm.entity.Product;

/**
 * @author Tuong
 */

public interface CartDao extends GenericDao<Cart> {
    Cart findOne(long cartId);

    Product checkAndUpdateProductsInCart(Cart cart);
}
