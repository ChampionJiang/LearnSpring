package app02b.controller;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app02a.domain.Product;
import app02a.form.ProductForm;
import app02c.validator.ProductValidator;

@Controller
public class ProductController {

	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value = "/product_input", method = RequestMethod.GET)
	public ModelAndView inputProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.info("InputProductController called");
		return new ModelAndView("ProductForm");
	}

	@RequestMapping(value = "/product_save", method = RequestMethod.POST)
	public ModelAndView saveProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProductForm productForm = new ProductForm();
		
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		
		ProductValidator productValidator = new ProductValidator();
		
		//List<String> errors = productValidator.validate(productForm);
		
		//if (errors.isEmpty()) {
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			
			return new ModelAndView("ProductDetails", "product", product);
		//} else {
		//	request.setAttribute("errors", errors);
		//	request.setAttribute("form", productForm);
		//	return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp", "errors", errors);
		//}
	}
}
