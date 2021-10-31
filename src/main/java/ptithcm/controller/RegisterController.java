package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import ptithcm.entity.Authorities;
import ptithcm.entity.BillingAddress;
import ptithcm.entity.Cart;
import ptithcm.entity.Customer;
import ptithcm.entity.ShippingAddress;
import ptithcm.service.AuthoritiesService;
import ptithcm.service.BillingAddressService;
import ptithcm.service.CartService;
import ptithcm.service.CustomerService;
import ptithcm.service.ShippingAddressService;




@Controller
public class RegisterController{

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BillingAddressService billingAddressService;
	
	@Autowired
	private ShippingAddressService shippingAddressService;
        
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/register.htm")
	public String registerCustomer(Model model){
		
		
		
		
		Customer customer=new Customer();
		BillingAddress billingAddress=new BillingAddress();
		ShippingAddress shippingAddress=new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		
		
		model.addAttribute("customer",customer);
		
		return "customer/registerCustomer";
	}
	
	
	
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String registerCustomerPost(@Valid@ModelAttribute("customer")Customer customer,BindingResult result, @RequestParam(name="update",required=false) String update,@RequestParam(name="oldUserId",required=false)Long oldUserId ,Model model,HttpServletRequest request){
		
	
		if (result.hasErrors()) {
			return "customer/registerCustomer";
		}
		
//		List<Customer> customerList=customerService.getAllCustomers();
//		
//		for (Customer customer2 : customerList) {
//			
//			if (customer2.getCustomerEmailAddress().equals(customer.getCustomerEmailAddress())) {
//				model.addAttribute("emailMsg","Email already exists");
//				return "registerCustomer";
//			}
//			
//			if (customer2.getUsername().equals(customer.getUsername())) {
//				model.addAttribute("usernameMsg","Username already exists");
//				return "registerCustomer";
//			}
//		}
		
		//System.out.println("--------------------------update:"+update+" ------------"+oldUserId);
		
		
		
		
		if (update!=null && update.equalsIgnoreCase("update")) {
			
			
			
			Customer oldCustomer=customerService.getCustomerBycustomerId(oldUserId);
			
			customer.getBillingAddress().setBillingAddressId(oldCustomer.getBillingAddress().getBillingAddressId());
			customer.getShippingAddress().setShippingAddressId(oldCustomer.getShippingAddress().getShippingAddressId());
			billingAddressService.addBillingAddress(customer.getBillingAddress());
			shippingAddressService.addShippingAddress(customer.getShippingAddress());
			
			
			String oldUsername=oldCustomer.getUsername();
			
			oldCustomer.setBillingAddress(customer.getBillingAddress());
			oldCustomer.setShippingAddress(customer.getShippingAddress());
			oldCustomer.setEnabled(true);
			oldCustomer.setBillingAddress(customer.getBillingAddress());
			oldCustomer.setShippingAddress(customer.getShippingAddress());
			oldCustomer.setUsername(customer.getUsername());
			oldCustomer.setPassword(customer.getPassword());
			oldCustomer.setCustomerEmailAddress(customer.getCustomerEmailAddress());
			oldCustomer.setCustomerName(customer.getCustomerName());
			oldCustomer.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
			
			
			customerService.addCustomer(oldCustomer);
			
			
			Authorities authorities=authoritiesService.findAuthoritiesByusername(oldUsername);
			authorities.setAuthorityType("ROLE_USER");
			authorities.setUsername(oldCustomer.getUsername());
			
			
			
			authoritiesService.addAuthorities(authorities);
			
			
			Cart cart=oldCustomer.getCart();
//			cart.setCustomer(oldCustomer);
			cart.setGrandTotal(0);
			
			cartService.addCart(cart);
			
			oldCustomer.setCart(cart);
			customerService.addCustomer(oldCustomer);
			
			autoLogin(oldCustomer,request);
			
			return "customer/updateCustomerSuccess";
					 
		}
		
		else {
			billingAddressService.addBillingAddress(customer.getBillingAddress());
			shippingAddressService.addShippingAddress(customer.getShippingAddress());
			
			customer.setEnabled(true);
			
			
			Authorities authorities=new Authorities();
			authorities.setAuthorityType("ROLE_USER");
			authorities.setUsername(customer.getUsername());
			
			
			
			authoritiesService.addAuthorities(authorities);
			
			
			Cart cart=new Cart();
//			cart.setCustomer(customer);
			cart.setGrandTotal(0);
			
			cartService.addCart(cart);
			
			customer.setCart(cart);
			customerService.addCustomer(customer);
			
			
			autoLogin(customer,request);
		}
		
		return "customer/registerCustomerSuccess";
	}



	private void autoLogin(Customer customer,HttpServletRequest request) {
            
	}
	
	
	
//	@RequestMapping("/customer/update")
//	public String customerUpdate(){
//		
//		return "updateCustomer";
//	}
//	
//	
//	@RequestMapping(value="/customer/update",method=RequestMethod.POST)
//	public String customerUpdatePost(@RequestParam("username")String username,@RequestParam("password")String password,Model model){
//		
//		Customer customer=customerService.findCustomerByusernameAndpassword(username, password);
//		
//		if (customer==null) {
//			
//			return "updateCustomer";
//		}
//		
//		model.addAttribute("customer",customer);
//		
//		
//		model.addAttribute("update","update");
//		return "registerCustomer";
//	}
//	
//	
//	
//	
//	
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
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.addValidators(passwordValidator);
//	}
}
