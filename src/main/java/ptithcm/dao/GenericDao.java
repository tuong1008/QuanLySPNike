/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.dao;


/**
 *
 * @author Tuong
 */
public interface GenericDao<T> {
    String save(T product);
        
    String update(T product);
        
    String delete(T product);
}
