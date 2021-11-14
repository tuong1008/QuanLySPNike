package ptithcm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.entity.CartItem;
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
    public String adminPage() {

        return "admin/index";
    }


    @RequestMapping("/productManagement/{pageNumber}.htm")
    public String productManagement(@PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
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

    @RequestMapping("/customerManagement/{pageNumber}.htm")
    public String customerManagement(@PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Customer> customers = customerService.getAllCustomers(pageNumber);
        long totalCustomers = customerService.getTotalCustomers();

        int totalPages = (int) Math.ceil(totalCustomers / 10.0); //mỗi page có 10 dòng
        if (totalCustomers == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("customers", customers);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/customerMgmt";
    }

    @RequestMapping(value = "/customerManagement/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String customerManagementSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Customer> page = customerService.findAllCustomerByUsernameOrEmail(searchTerm, pageNumber);
        long totalProducts = customerService.getTotalCustomerByUsernameOrEmail(searchTerm);


        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("customers", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("search", "search");
        return "admin/customerMgmt";
    }

    @RequestMapping("/customerManagement/address/{customerId}")
    public String customerShippingBillingAddress(@PathVariable("customerId") long customerId, ModelMap model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "admin/customerAddr";
    }

    @RequestMapping("/customerOrder/{pageNumber}.htm")
    public String customerOrder(@PathVariable Integer pageNumber, ModelMap model) {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders(pageNumber);
        long totalCustomers = customerOrderService.getTotalCustomerOrders();

        int totalPages = (int) Math.ceil(totalCustomers / 10.0); //mỗi page có 10 dòng
        if (totalCustomers == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("orders", customerOrders);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        return "admin/orderList";
    }

    @RequestMapping(value = "/customerOrder/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String customerOrderSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<CustomerOrder> page = customerOrderService.findAllOrderByUsernameOrEmail(searchTerm, pageNumber);
        long totalProducts = customerOrderService.getTotalOrderByUsernameOrEmail(searchTerm);


        int totalPages = (int) Math.ceil(totalProducts / 10.0); //mỗi page có 10 dòng
        if (totalProducts == 0) totalPages = 1;

        int currentPageNumber = pageNumber;
        int beginIndex = Math.max(1, currentPageNumber - 6);
        int endIndex = Math.min(beginIndex + 10, totalPages);
        model.addAttribute("orders", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPageNumber", currentPageNumber);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);

        model.addAttribute("search", "search");
        return "admin/orderList";
    }

    @RequestMapping("/customerOrder/deleteOrder/{customerOrderId}.htm")
    public String deleteCustomerOrder(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
        List<CartItem> listItem = customerOrder.getCart().getCartItem();

        for (CartItem item : listItem) {
            Product product = item.getProduct();
            product.setUnitInStock(product.getUnitInStock() + item.getQuantity());
            productService.updateProduct(product);
            cartItemService.deleteCartItem(item);
        }

        customerOrderService.removeCustomerOrder(customerOrder);
        cartService.removeCart(customerOrder.getCart());
        shippingAddressService.removeShippingAddress(customerOrder.getShippingAddress());
        billingAddressService.removeBillingAddress(customerOrder.getBillingAddress());

        return "redirect:/admin/customerOrder/1.htm";
    }

    @RequestMapping("/customerOrder/productList/{customerOrderId}.htm")
    public String getCustomerOrderProduct(@PathVariable("customerOrderId") long customerOrderId, ModelMap model) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
        //List<CartItem> cartItems=customerOrder.getCart().getCartItems();
        model.addAttribute("order", customerOrder);

        return "admin/orderDetails";
    }

    @RequestMapping(value = "/productManagement/search/{pageNumber}.htm", method = RequestMethod.POST)
    public String productSearch(@RequestParam("searchTerm") String searchTerm, @PathVariable("pageNumber") Integer pageNumber, ModelMap model) {
        List<Product> page = productService.findAllProductByNameorCategory(searchTerm, pageNumber);
        long totalProducts = productService.getTotalProductByNameorCategory(searchTerm);


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

        model.addAttribute("search", "search");
        return "admin/productInventory";
    }
}
