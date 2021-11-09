/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.interceptor;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import ptithcm.exceptions.PageNotFoundException;

@Transactional
public class LoggerInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * Nếu register.htm thì cho qua
         * Không vào được những trang cần login
         * Login rồi mà login nữa 
         * Đã đăng nhập và tiếp tục ấn đăng ký
         */
        System.out.println("LoggerIntercep preHandle");
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null){
            if (request.getRequestURI().contains("/register.htm")
                    ||request.getRequestURI().contains("/login.htm")){
                return true;
            }
            else {
                response.sendRedirect(request.getContextPath() + "/login.htm");
                return false;
            }
        }
        else if (request.getRequestURI().contains("/login.htm")
                ||request.getRequestURI().contains("/register.htm")){
            throw new PageNotFoundException("Logout Required!");
        }
        else{
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
