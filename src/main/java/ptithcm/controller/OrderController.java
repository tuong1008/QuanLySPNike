package ptithcm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.entity.CustomerOrder;
import ptithcm.service.CartService;
import ptithcm.service.CustomerOrderService;
import ptithcm.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import ptithcm.entity.CartItem;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

@Controller
public class OrderController {
    @Autowired
    ProductService productService;
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CartService cartservice;

    @RequestMapping("/order/{cartId}.htm")
    public String createOrder(Model model, @PathVariable("cartId") long cartId, HttpServletRequest request) {

        Cart cart = cartService.getCartById(cartId);
            
        Product productMakeError = cartService.checkAndUpdateProductsInCart(cart);
        if (productMakeError==null) {
            CustomerOrder customerOrder = new CustomerOrder();

            customerOrder.setCart(cart);
            String username = request.getSession().getAttribute("username").toString();
            Customer customer = customerService.findCustomerByUsername(username);

            customerOrder.setCustomer(customer);
            customerOrder.setBillingAddress(customer.getBillingAddress());
            customerOrder.setShippingAddress(customer.getShippingAddress());
            customerOrderService.addCustomerOrder(customerOrder);
            //new cart after order successfully
            Cart newCart = new Cart();
            newCart.setGrandTotal(0);

            cartService.addCart(newCart);

            customer.setCart(newCart);
            customerService.updateCustomer(customer);

            model.addAttribute("message", "Order Successfully!");
            return "customer/success_page";
        } else {
            model.addAttribute("error", "Error! Unit in stock "+productMakeError.getProductName()+" is "+productMakeError.getUnitInStock());
            return "customer/cart";
        }
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
