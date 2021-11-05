package ptithcm.controller.admin;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import ptithcm.entity.Cart;
import ptithcm.entity.CustomerOrder;

import ptithcm.entity.Product;
import ptithcm.service.BillingAddressService;
import ptithcm.service.CartItemService;
import ptithcm.service.CartService;
import ptithcm.service.CustomerOrderService;
import ptithcm.service.ProductService;
import ptithcm.service.ShippingAddressService;




@Controller
@RequestMapping("/admin")
public class AdminHome{

	@Autowired
	private ProductService productService;
        
        @Autowired
        private CartItemService cartItemService;
        
        @Autowired
        private CustomerOrderService customerOrderService;
        
        @Autowired
        private CartService cartService;
        
        @Autowired
        private ShippingAddressService shippingAddressService;
        
        @Autowired
        private BillingAddressService billingAddressService;
	
	@RequestMapping
	public String adminPage(){
		
		return "admin";
	}
	
	@RequestMapping("/productManagement/{pageNumber}.htm")
	public String productManagement(@PathVariable Integer pageNumber,Model model){
		
		
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
		
		return "admin/productInventory";
	}
	
	
	
	
//	@RequestMapping(value="/productManagement/search/{pageNumber}",method=RequestMethod.POST)
//	public String productSearch(@RequestParam("searchTerm")String searchTerm,@PathVariable Integer pageNumber,Model model){
//		
//		
//		Page<Product> page=productService.getAllProductByBrandOrModelOrCategory(pageNumber, searchTerm);
//		
//		int currentPageNumber=page.getNumber()+1;
//		int beginIndex=Math.max(1, currentPageNumber-6);
//		int endIndex=Math.min(beginIndex+10, page.getTotalPages());
//		
//		
//		
//      List<Product> products=new ArrayList<>();
//		
//		
//		
//		for (Product product : page) {
//			products.add(product);
//		}
//		
//		model.addAttribute("products",products);
//		model.addAttribute("totalPages",page.getTotalPages());
//		model.addAttribute("currentPageNumber",currentPageNumber);
//		model.addAttribute("beginIndex",beginIndex);
//		model.addAttribute("endIndex",endIndex);
//		
//		model.addAttribute("search","search");
//		return "productInventory";
//	}
//	
//	
//	
//	@RequestMapping("/customerManagement")
//	public String customerManagement(Model model){
//		
//		
//		List<Customer> customers=customerService.getAllCustomers();
//		model.addAttribute("customers",customers);
//		
//		return "customerManagement";
//	}
//	
//	
//	@RequestMapping("/customerManagement/address/{customerId}")
//	public String customerShippingBillingAddress(@PathVariable("customerId")long customerId,Model model){
//		
//		
//		 Customer customer=customerService.getCustomerBycustomerId(customerId);
//		
//		 model.addAttribute("customer",customer);
//		 
//		return "customerAddressDetail";
//	}
//	
//	
//	
	@RequestMapping("/customerOrder.htm")
	public String customerOrder(Model model){
		
		
		List<CustomerOrder> customerOrders=customerOrderService.getAllCustomerOrder();
		model.addAttribute("orders",customerOrders);
		return "admin/orderList";
	}
	
	
	
	@RequestMapping("/customerOrder/deleteOrder/{customerOrderId}.htm")
	public String deleteCustomerOrder(@PathVariable("customerOrderId")long customerOrderId,Model model){
		
		
		CustomerOrder customerOrder=customerOrderService.getCustomerOrderById(customerOrderId);
		
		customerOrderService.removeCustomerOrder(customerOrder);
		cartService.removeCart(customerOrder.getCart());
                shippingAddressService.removeShippingAddress(customerOrder.getShippingAddress());
                billingAddressService.removeBillingAddress(customerOrder.getBillingAddress());
		
		return "redirect:/admin/customerOrder.htm";
	}
	
	
	
	@RequestMapping("/customerOrder/productList/{customerOrderId}.htm")
	public String getCustomerOrderProduct(@PathVariable("customerOrderId")long customerOrderId,Model model){
		
		
		CustomerOrder customerOrder=customerOrderService.getCustomerOrderById(customerOrderId);
		
		
		//List<CartItem> cartItems=customerOrder.getCart().getCartItems();
		
		
		model.addAttribute("order",customerOrder);
		
		return "admin/orderDetails";
	}
//	
//	
//	
//	
//	@RequestMapping("/customerMessages/{pageNumber}")
//	public String customerMessage(@PathVariable Integer pageNumber,Model model){
//		
//		
//		
//		
//		
//		
//      Page<CustomerContact> page=customerContactService.getAllCustomerMessage(pageNumber);
//		
//		int currentPageNumber=page.getNumber()+1;
//		int beginIndex=Math.max(1, currentPageNumber-5);
//		int endIndex=Math.min(beginIndex+10, page.getTotalPages());
//		
//		
//		
//      List<CustomerContact> customerContacts=new ArrayList<>();
//		
//		
//		
//		for (CustomerContact contact : page) {
//			customerContacts.add(contact);
//		}
//		
//		
//		if (customerContacts.size()==0) {
//			model.addAttribute("msg","No Customer Message To show");
//		}
//		
//		model.addAttribute("customerContacts",customerContacts);
//		model.addAttribute("totalPages",page.getTotalPages());
//		model.addAttribute("currentPageNumber",currentPageNumber);
//		model.addAttribute("beginIndex",beginIndex);
//		model.addAttribute("endIndex",endIndex);
//		
//		
//		return "customerMessage";
//	}
//	
//	
//	@RequestMapping("/customerMessages/deleteMessage")
//	public String customerMessageDelete(@RequestParam("customerMessageId")int customerMessageId,@RequestParam("currentPageNumber")int currentPageNumber){
//		
//		
//		
//		
//		customerContactService.deleteMessageById(customerMessageId);
//		
//     
//		
//		
//		return "redirect:/admin/customerMessages/"+currentPageNumber;
//	}
//	
//	
//	@Override
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
}
