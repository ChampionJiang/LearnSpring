package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.domain.Product;
import test.form.ProductForm;
import test.service.ProductService;
import test.validator.ProductValidator;

@Controller
public class ProductController {

	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product_input", method = RequestMethod.GET)
	public ModelAndView inputProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.info("InputProductController called");
		return new ModelAndView("ProductForm");
	}

	@RequestMapping(value = "/product_save", method = RequestMethod.POST)
	public String saveProduct(ProductForm productForm,
			RedirectAttributes redirectAttributes) {
		// TODO Auto-generated method stub
		logger.info("saveProduct called");
		
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch(NumberFormatException e) {
			
		}
		
		Product savedProduct = productService.add(product);
		redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
		return "redirect:/product_view/"+savedProduct.getId();
		
	}
	
	@RequestMapping(value="/product_view/{id}")
	public String viewProduct(@PathVariable Long id, Model model) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "ProductView";
		
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importFile()
	{
		return "import";
	}
}
