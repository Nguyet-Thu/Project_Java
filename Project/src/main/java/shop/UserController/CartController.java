package shop.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.DTO.CartDTO;
import shop.Entity.Bills;
import shop.Entity.Users;
import shop.Service.User.BillServiceImpl;
import shop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceImpl cartService  = new CartServiceImpl();
	
	@Autowired
	private BillServiceImpl billService  = new BillServiceImpl();
	
	@RequestMapping(value = {"Home/List-cart","product/List-cart","product_detail/List-cart","List-cart"})
	public ModelAndView Index() {
		_mvShare.addObject("products", _homeService.getDataProduct());
		_mvShare.addObject("productsnew", _homeService.getProductNew());
		_mvShare.setViewName("user/listCart");
		return _mvShare;
	}
	
	@RequestMapping(value ="AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value ="Home/EditCart/{id}/{quantity}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id,@PathVariable int quantity) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.UpdateCart(id,quantity,cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value ="/Home/DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value ="Home/Checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bill = new Bills();
		Users loginInfor = (Users) session.getAttribute("LoginInfor");
		if(loginInfor != null) {
			bill.setFullName(loginInfor.getFullName());
			bill.setPhone(loginInfor.getPhone());
			bill.setEmail(loginInfor.getEmail());
			bill.setAddress(loginInfor.getAddress());
			
		}
		_mvShare.addObject("bill",bill);
		return _mvShare;
	}
	@RequestMapping(value ="Home/Checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request,HttpSession session,@ModelAttribute("bill") Bills bill) {
		bill.setQuantity(Integer.parseInt(session.getAttribute("TotalQuantity").toString()));
		bill.setTotal(Double.parseDouble( session.getAttribute("TotalPrice").toString()));
		if(billService.AddBill(bill) >0) {
			HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
			billService.AddBillDetail(cart);
		}
		session.removeAttribute("Cart");
		
		return "redirect:List-cart";
	}
}
