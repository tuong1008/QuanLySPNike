package ptithcm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.entity.Customer;
import ptithcm.entity.CustomerOrder;
import ptithcm.entity.Product;
import ptithcm.service.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

        @Autowired
        private CustomerService customerService;
    
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
	
	@RequestMapping("/home.htm")
	public String adminPage(){
		
		return "admin/index";
	}
	

    @RequestMapping("/productManagement/{pageNumber}.htm")
    public String productManagement(@PathVariable Integer pageNumber, ModelMap model) {
        List<Product> page = productService.getAllProduct(pageNumber);
        long totalProducts = productService.getTotalProduct();

        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("products", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/productInventory";
    }

    @RequestMapping("/customerManagement.htm")
    public String customerManagement(ModelMap model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);

        return "admin/customerMgmt";
    }

    @RequestMapping("/customerManagement/address/{customerId}")
    public String customerShippingBillingAddress(@PathVariable("customerId") long customerId, ModelMap model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "admin/customerAddr";
    }

    @RequestMapping("/customerOrder.htm")
    public String customerOrder(ModelMap model) {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrder();
        model.addAttribute("orders", customerOrders);
        return "admin/orderList";
    }

    @RequestMapping("/customerOrder/deleteOrder/{customerOrderId}.htm")
    public String deleteCustomerOrder(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);

        customerOrderService.removeCustomerOrder(customerOrder);
        cartService.removeCart(customerOrder.getCart());
        shippingAddressService.removeShippingAddress(customerOrder.getShippingAddress());
        billingAddressService.removeBillingAddress(customerOrder.getBillingAddress());

        return "redirect:/admin/customerOrder.htm";
    }
    @RequestMapping("/customerOrder/productList/{customerOrderId}.htm")
    public String getCustomerOrderProduct(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
        //List<CartItem> cartItems=customerOrder.getCart().getCartItems();
        model.addAttribute("order", customerOrder);

        return "admin/orderDetails";
    }
}
