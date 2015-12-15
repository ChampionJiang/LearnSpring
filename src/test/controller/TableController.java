package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmss.connector.Connector;
import com.cmss.connector.ConnectorFactory;
import com.cmss.storage.ObjectAlreadyInitializedException;
import com.cmss.storage.RawTable;
import com.jsp.smart.SmartUploadException;

import test.service.TableService;
import test.service.TableServiceImpl;

@Controller
public class TableController {
	
	private static final Log logger = LogFactory.getLog(TableController.class);
	private TableService tableService = new TableServiceImpl();
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importFile()
	{
		return "import";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response, Model model) {
		// TODO Auto-generated method stub
		Connector connector = null;
		RawTable table = null;
		try {
			connector = ConnectorFactory.createConnectorFromRequest(request, response);
			table = connector.Transform();
			tableService.add(table);
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ObjectAlreadyInitializedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("table", table);
		model.addAttribute("tableNo", tableService.getTableCount());
		logger.info("UploadFile called");
		return new ModelAndView("TableInfo");
	}

}
