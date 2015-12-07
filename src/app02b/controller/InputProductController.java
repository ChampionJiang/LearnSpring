package app02b.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

public class InputProductController implements Controller {

	private static final Log logger = LogFactory.getLog(InputProductController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.info("InputProductController called");
		return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
	}

}
