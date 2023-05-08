package shop.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.Entity.Users;
import shop.Service.User.AccountServiceImpl;
@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accService = new AccountServiceImpl();
	
	@RequestMapping(value = "/Home/Register", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/Home/Register", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") Users user) {
		int count = accService.AddAccount(user);
		if(count>0) {
			_mvShare.addObject("status","Đăng ký tài khoản thành công");
		}else {
			_mvShare.addObject("status","Đăng ký tài khoản thất bại");
		}
		_mvShare.setViewName("redirect:/Home/Login");
		return _mvShare;
	}
	
	@RequestMapping(value = "/Home/Login", method = RequestMethod.GET)
	public ModelAndView Login() {
		_mvShare.setViewName("user/account/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/Home/Login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") Users user) {
		user =accService.CheckAccount(user);
		if(user != null) {
			_mvShare.setViewName("redirect:/Home/");
			session.setAttribute("LoginInfor", user);
		}else {
			_mvShare.addObject("statusLogin","Đăng nhập thất bại");
		}
		
		return _mvShare;
	}

	@RequestMapping(value = "/Home/Logout", method = RequestMethod.GET)
	public String  Logout(HttpSession session,HttpServletRequest request) {
		session.removeAttribute("LoginInfor");
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = { "/Admin/ListAccountUser"})
	public ModelAndView GetAllData(HttpServletRequest request) {
		_mvShare.addObject("listCustomer",accService.GetAllUsers());
		_mvShare.setViewName("admin/customer/listCustomer");
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/DeleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id,HttpSession session){
		int count = accService.DeleteCustomer(id);
		if(count>0) {
			_mvShare.addObject("status","Xoas thành công");
		}else {
			_mvShare.addObject("status","Xóa thất bại");
		}
		_mvShare.setViewName("admin/customer/listCustomer");
		return "redirect:/Admin/ListAccountUser";

    }
}
