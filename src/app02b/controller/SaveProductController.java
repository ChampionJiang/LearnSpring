package app02b.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import app02a.domain.Product;
import app02a.form.ProductForm;
import app02c.validator.ProductValidator;

public class SaveProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
			
			return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product", product);
		//} else {
		//	request.setAttribute("errors", errors);
		//	request.setAttribute("form", productForm);
		//	return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp", "errors", errors);
		//}
	}

}
