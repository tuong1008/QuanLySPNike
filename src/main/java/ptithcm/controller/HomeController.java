/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptithcm.entity.Customer;
import ptithcm.exceptions.PageNotFoundException;
import ptithcm.exceptions.UnauthorizedException;
import ptithcm.service.AuthoritiesService;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Tuong
 */
@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;

    @Autowired
    AuthoritiesService authoritiesService;

    @Autowired
    ProductService productService;

    @RequestMapping("/trang-chu.htm")
    public String homePage() {
        return "customer/index";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("customer", new Customer());
        return "customer/login";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(HttpServletRequest request, ModelMap model, @ModelAttribute("customer") Customer customer) throws ServletException {
        Customer temp = customerService.findCustomerByUsernameAndPassword(customer.getUsername(), customer.getPassword());
        if (temp != null) {
            request.getSession().setAttribute("username", customer.getUsername());
            String role = authoritiesService.getRole(customer.getUsername());
            if (role.equals("ROLE_USER") || role.isEmpty()) {
                return "redirect:/trang-chu.htm";
            } else {
                return "redirect:/admin/home.htm";
            }
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "customer/login";
        }
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request) throws ServletException {
        request.getSession().removeAttribute("username");
        return "redirect:/login.htm?logout";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error404() throws PageNotFoundException {
        throw new PageNotFoundException();
    }

    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String error401() throws UnauthorizedException {
        throw new UnauthorizedException();
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error500() throws Exception {
        throw new Exception();
    }
}
