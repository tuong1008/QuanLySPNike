package ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.service.CustomerService;

@Controller
//@RequestMapping("/customer/")
public class ContactController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/contact")
    public String contact() {
        return "customer/contact";
    }
}
