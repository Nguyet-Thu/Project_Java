package shop.AdminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Admin;
import shop.Service.Admin.AdminService;
import shop.UserController.BaseController;
	
@Controller
public class AdminController extends BaseController{
	@Autowired
	AdminService adminservice = new AdminService();
	
	@RequestMapping(value = { "/Admin" })
	public ModelAndView Index() {
		_mvShare.setViewName("admin/index");
		return _mvShare;
	}
	
	@RequestMapping(value = "/LoginAdmin", method = RequestMethod.GET)
	public ModelAndView LoginAdmin() {
		_mvShare.setViewName("admin/login");
		_mvShare.addObject("admin", new Admin());
		return _mvShare;
	}
	
	@RequestMapping(value = "/LoginAdmin", method = RequestMethod.POST)
	public ModelAndView LoginAdmin(HttpSession session,@ModelAttribute("admin") Admin admin) {
		admin =adminservice.CheckAdmin(admin);
		if(admin != null) {
			_mvShare.setViewName("redirect:/Admin/");
			session.setAttribute("LoginAd", admin);
		}else {
			_mvShare.addObject("statusLogin","Đăng nhập thất bại");
		}
		
		return _mvShare;
	}
}
