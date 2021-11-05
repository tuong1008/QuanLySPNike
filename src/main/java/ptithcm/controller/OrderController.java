package ptithcm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.entity.CustomerOrder;
import ptithcm.service.CartService;
import ptithcm.service.CustomerOrderService;
import ptithcm.service.CustomerService;

@Controller
public class OrderController{

	
	@Autowired
        private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
        @Autowired
	private CustomerOrderService customerOrderService;
        
        @Autowired
        private CartService cartservice;
	 
	@RequestMapping("/order/{cartId}.htm")
	public String createOrder(Model model, @PathVariable("cartId")long cartId, HttpServletRequest request){
	
		CustomerOrder customerOrder=new CustomerOrder();
		
		Cart cart=cartService.getCartById(cartId);
		customerOrder.setCart(cart);
                
                
		String username=request.getSession().getAttribute("username").toString();
		Customer customer=customerService.findCustomerByUsername(username);
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		
		
		
		
		customerOrderService.addCustomerOrder(customerOrder);
                //new cart after order successfully
                Cart newCart= new Cart();
                newCart.setGrandTotal(0);
			
		cartService.addCart(newCart);
			
                customer.setCart(newCart);
                customerService.updateCustomer(customer);
                model.addAttribute("message", "Order Successfully!");
		return "customer/success_page";
	}
	
	
	
	
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView modelAndView=new ModelAndView();
//		CustomError error=new CustomError();
//	
//		
//		error.setMessage("Your request is not valid.Please Enter a valid request.");
//		modelAndView.addObject("customError", error);
//		modelAndView.setViewName("error_page");
//		
//		return modelAndView;
//	}
}
