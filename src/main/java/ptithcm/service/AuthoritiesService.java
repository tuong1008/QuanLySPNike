/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.service;

import ptithcm.entity.Authorities;

/**
 *
 * @author Tuong
 */
public interface AuthoritiesService {
    String addAuthorities(Authorities authorities);
    
    Authorities findAuthoritiesByusername(String username);
    
    String getRole(String username);
}
