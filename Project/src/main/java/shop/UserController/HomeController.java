package shop.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/Home" })
	public ModelAndView Index() {
		_mvShare.addObject("products", _homeService.getDataProduct());
		_mvShare.addObject("productsnew", _homeService.getProductNew());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

	@RequestMapping(value = "/product")
	public ModelAndView Product() {
		_mvShare.setViewName("user/category");
		return _mvShare;
	}
	@RequestMapping(value = "/Home/product_detail")
	public ModelAndView ProductDetail() {
		_mvShare.setViewName("user/product_detail");
		return _mvShare;
	}
	@RequestMapping(value = "/Home/listcart")
	public ModelAndView ListCart() {
		_mvShare.setViewName("user/listCart");
		return _mvShare;
	}
	@RequestMapping(value = "/Home/Register")
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	@RequestMapping(value = "/Home/Login")
	public ModelAndView Login() {
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}
}
