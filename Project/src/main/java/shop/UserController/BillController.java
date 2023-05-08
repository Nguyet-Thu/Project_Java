package shop.UserController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.DTO.CartDTO;
import shop.DTO.PaginatesDTO;
import shop.DTO.ProductDTO;
import shop.Entity.BillDetail;
import shop.Entity.Bills;
import shop.Entity.Category;
import shop.Entity.Users;
import shop.Service.User.BillServiceImpl;
import shop.Service.User.CategoryServiceImpl;
import shop.Service.User.PaginateServiceImpl;
import shop.Service.User.ProductServiceImpl;

@Controller
public class BillController extends BaseController {

	@Autowired
	private BillServiceImpl billService;
	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = { "/Admin/ListBill"})
	public ModelAndView GetAllData(HttpServletRequest request) {
		_mvShare.addObject("listBill",billService.GetAllBills());
		_mvShare.setViewName("admin/bills/listBills");
		return _mvShare;
	}
	
	@RequestMapping(value = { "/Admin/BillDetails/{id}"  })
	public ModelAndView GetBillDetailByIdBill(@PathVariable String id) {
		List<BillDetail> listBillDetails = billService.GetBDetailsByBill(Integer.parseInt(id));
		for (BillDetail b : listBillDetails) {
			int idProduct =b.getProductId();
				ProductDTO nameproduct = productService.GetProductById(idProduct);
				b.setProductName(nameproduct.getProductName());
		}
		
		_mvShare.addObject("bdetails",listBillDetails);
		
		_mvShare.setViewName("admin/bills/billdetails");
		return _mvShare;
	}
	
}
