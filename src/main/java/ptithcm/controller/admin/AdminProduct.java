package ptithcm.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/admin")
public class AdminProduct {

    private Path path;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/addProduct.htm", method = RequestMethod.GET)
    public String addProduct(Model model) {


        Product product = new Product();
        product.setProductStatus("Brand New");
        model.addAttribute("product", product);
        model.addAttribute("categoryList", product.getCategoryList());
        return "admin/addProduct";
    }


    @RequestMapping(value = "/product/addProduct.htm", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request) {

        try {
            if (result.hasErrors()) {
                model.addAttribute("categoryList", product.getCategoryList());
                return "admin/addProduct";
            }
            productService.addProduct(product);

            MultipartFile productImage = product.getProductImage();
            String rootDir = request.getSession().getServletContext().getRealPath("/");
            path = Paths.get(rootDir + "\\resources\\images\\" + product.getProductId() + ".png");

            if (productImage != null && !productImage.isEmpty()) {
                try {
                    productImage.transferTo(new File(path.toString()));

                    //System.out.println("IMage Save at:"+path.toString());
                } catch (Exception e) {

                    e.printStackTrace();
                    throw new RuntimeException("Product image saving failed", e);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }


        return "redirect:/admin/productManagement/1.htm";
    }


    @RequestMapping("/product/updateProduct/{productId}.htm")
    public String updateProduct(@PathVariable("productId") long productId, Model model) {

        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);
        model.addAttribute("categoryList", product.getCategoryList());
        return "admin/updateProduct";


    }


    @RequestMapping(value = "/product/updateProduct.htm", method = RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {

            return "admin/addProduct";
        }


        MultipartFile productImage = product.getProductImage();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\resources\\images\\" + product.getProductId() + ".png");


        if (productImage != null && !productImage.isEmpty()) {

            //System.out.println("OKKKK--------------------");
            try {


                productImage.transferTo(new File(path.toString()));

                //System.out.println("IMage Save at:"+path.toString());
            } catch (Exception e) {

                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }


        productService.updateProduct(product);


        return "redirect:/admin/productManagement/1.htm";
    }


    @RequestMapping("/product/deleteProduct/{productId}.htm")
    public String deleteProduct(@PathVariable("productId") long productId, Model model, HttpServletRequest request) throws Exception {

        try {
            String rootDir = request.getSession().getServletContext().getRealPath("/");
            path = Paths.get(rootDir + "\\resources\\images\\" + productId + ".png");

            if (Files.exists(path)) {

                try {
                    Files.delete(path);
                } catch (IOException e) {

                    e.printStackTrace();


                }
            }


            Product productToDel = productService.getProductById(productId);

            productService.deleteProduct(productToDel);
        } catch (Exception e) {

            System.out.println("------------------------------------------------------------------");
            model.addAttribute("messsage", e.getMessage());
        }

        return "redirect:/admin/productManagement/1.htm";


    }
//	
//
//
//
//	
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView modelAndView=new ModelAndView();
//		CustomError error=new CustomError();
//		if (ex instanceof DatabaseForeignKeyException) {
//			
//			
//			
//			error.setMessage("You can not delete a product until you clear customer order.In customer order this product exist.");
//			modelAndView.addObject("customError", error);
//			modelAndView.setViewName("error_page");
//			return modelAndView;
//		}
//		
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
//		binder.addValidators(productFormValidator);
//	}
}
