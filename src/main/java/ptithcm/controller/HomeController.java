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
import org.springframework.web.bind.annotation.RequestMethod;
import ptithcm.entity.Customer;
import ptithcm.entity.Product;
import ptithcm.exceptions.PageNotFoundException;
import ptithcm.service.AuthoritiesService;
import ptithcm.service.CustomerService;
import ptithcm.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

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
	public String homePage(HttpServletRequest request,
                HttpServletResponse response,
                ModelMap model){
		int pageNumber=1;
               List<Product> page=productService.getAllProduct(pageNumber);
		long totalProducts=productService.getTotalProduct();

                int totalPages=(int) Math.ceil(totalProducts/10.0); //mỗi page có 10 dòng
                if (totalProducts==0) totalPages=1;
                
		int currentPageNumber=pageNumber;
		int beginIndex=Math.max(1, currentPageNumber-6);
		int endIndex=Math.min(beginIndex+10, totalPages);
		
		
                model.addAttribute("products",page);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
                return "customer/productList";
    }
    @RequestMapping(value="/login.htm", method = RequestMethod.GET)
   public String login(ModelMap model){
           model.addAttribute("customer", new Customer());
       return "customer/login";
   }
   @RequestMapping(value="/login.htm", method = RequestMethod.POST)
   public String login(HttpServletRequest request, ModelMap model, @ModelAttribute("customer") Customer customer) throws ServletException{
       Customer temp = customerService.findCustomerByUsernameAndPassword(customer.getUsername(), customer.getPassword());
       if (temp!=null){
           request.getSession().setAttribute("username", customer.getUsername());
           String role = authoritiesService.getRole(customer.getUsername());
           if (role.equals("ROLE_USER")){
               return "redirect:/trang-chu.htm";
           }
           else{
               return "redirect:/admin/home.htm";
           }
       }
       else{
           model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
           return "customer/login";
       }
   }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request) throws ServletException {
        request.getSession().removeAttribute("username");
        return "redirect:/login.htm?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error404(HttpServletRequest request) throws PageNotFoundException {
        throw new PageNotFoundException();
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error500(HttpServletRequest request) throws Exception {
        throw new Exception();
    }
}
