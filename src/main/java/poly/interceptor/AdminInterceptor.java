/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ptithcm.service.AuthoritiesService;

/**
 *
 * @author Tuong
 */
public class AdminInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    AuthoritiesService authoritiesService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Admin Intercep");
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if (username!=null){
            String role = authoritiesService.getRole(username.toString());
            if (role.equals("ROLE_ADMIN")){
                return true;
            }
        }
        // báo k có quyền
        return false;
    }
}
