package test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadFile {
	
	private static final Log logger = LogFactory.getLog(UploadFile.class);
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.info("UploadFile called");
		return new ModelAndView("TableInfo");
	}

}
