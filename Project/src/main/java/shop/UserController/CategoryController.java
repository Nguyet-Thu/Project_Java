package shop.UserController;

import java.util.HashMap;
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
import shop.Entity.Bills;
import shop.Entity.Category;
import shop.Entity.Users;
import shop.Service.User.CategoryServiceImpl;
import shop.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController {

	@Autowired
	private CategoryServiceImpl categoryService;
    
	@Autowired
	private PaginateServiceImpl paginateService;
	
	private int totalProductsPage = 6;
	@RequestMapping(value = { "/Home/productList"})
	public ModelAndView GetAllProduct(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/product/productList");
		int totalData = categoryService.GetAllDataProduct().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("proInfo",paginateInfo);
		_mvShare.addObject("proAllPaginate", categoryService.GetDataAllProductPaginate( paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	@RequestMapping(value = "/Home/productList/{currentPage}")
	public ModelAndView GetAllProduct( @PathVariable String currentPage) {
		_mvShare.setViewName("user/product/productList");
		int totalData = categoryService.GetAllDataProduct().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("proInfo", paginateInfo);
		_mvShare.addObject("proAllPaginate", categoryService.GetDataAllProductPaginate(paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	@RequestMapping(value = "/Home/product/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/category");
		int totalDataPro = categoryService.GetAllDataProductById(Integer.parseInt(id)).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalDataPro, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/Home/product/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		_mvShare.setViewName("user/category");
		int totalDataPro = categoryService.GetAllDataProductById(Integer.parseInt(id)).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalDataPro, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductPaginate(Integer.parseInt(id) ,paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/AddCategory", method = RequestMethod.GET)
	public ModelAndView CreateAcc() {
		_mvShare.setViewName("admin/category/addCategory");
		_mvShare.addObject("cat", new Category());
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/AddCategory", method = RequestMethod.POST)
	public String CreateAcc(@ModelAttribute("AddCategory") Category cat) {
		int count = categoryService.AddCat(cat);
		if(count>0) {
			_mvShare.addObject("status","Thêm thành công");
		}else {
			_mvShare.addObject("status","Thêm thất bại");
		}
		_mvShare.setViewName("admin/category/listCategory");
		return "redirect:/Admin/ListCategory";
	}
	
	
	
	@RequestMapping(value = "/Admin/DeleteCat/{id}")
    public String deleteCard(@PathVariable Integer id,HttpSession session){
		int count = categoryService.DeleteCat(id);
		if(count>0) {
			_mvShare.addObject("status","Xoas thành công");
		}else {
			_mvShare.addObject("status","Thêm thất bại");
		}
		_mvShare.setViewName("admin/category/listCategory");
		return "redirect:/Admin/ListCategory";

    }
	
	@RequestMapping(value = "/Admin/EditCate/{id}")
	public ModelAndView EditCate( @PathVariable Integer id, HttpSession session ,Category cat) {
		Category catById = categoryService.GetCatById(id);
		_mvShare.addObject("cat", catById);
		if(catById!= null) {
			session.setAttribute("Id", catById.getId());
			session.setAttribute("NameCategory", catById.getNameCategory());
			session.setAttribute("Description", catById.getDescription());
			session.setAttribute("Status", catById.isStatus());
		}
		_mvShare.setViewName("admin/category/updateCategory");
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/EditCate/{id}",  method = RequestMethod.POST)
	public String EditCate(@ModelAttribute("edit") Category cat, @PathVariable Integer id,HttpSession session) {
		session.setAttribute("Id", cat.getId());
		int count = categoryService.UpdateCat(cat);
		if(count>0) {
			_mvShare.addObject("status","Sửa thành công");
		}else {
			_mvShare.addObject("status","Sửa thất bại");
		}
		_mvShare.setViewName("admin/category/updateCategory");
		return "redirect:/Admin/ListCategory";
	}
	@RequestMapping(value = { "/Admin/ListCategory"})
	public ModelAndView GetAllData(HttpServletRequest request) {
		_mvShare.addObject("listCat",categoryService.GetAllCate());
		_mvShare.setViewName("admin/category/listCategory");
		return _mvShare;
	}
}
