package shop.UserController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.DTO.PaginatesDTO;
import shop.DTO.ProductDTO;
import shop.Entity.BillDetail;
import shop.Entity.Category;
import shop.Service.User.CategoryServiceImpl;
import shop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
    
	@Autowired
	private ProductServiceImpl productService;
	
	
	
	@RequestMapping(value = { "/Home/product_detail/{id}"  })
	public ModelAndView Index(@PathVariable int id) {
		_mvShare.setViewName("user/product/product_detail");
		_mvShare.addObject("pdetails",productService.GetProductById(id));
		return _mvShare;
	}
	@RequestMapping(value = { "/Admin/ListProduct"})
	public ModelAndView GetAllData(HttpServletRequest request, HttpSession session) {
		List<ProductDTO> listProduct = productService.GetAllProduct();
		for (ProductDTO p : listProduct) {
			int idCat =p.getCategory_Id();
			Category cate = categoryService.GetCatById(idCat);
			p.setCategoryName(cate.getNameCategory());
		}
		_mvShare.addObject("listProduct",listProduct);
		_mvShare.setViewName("admin/product/listProduct");
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/DeleteProduct/{id}")
    public String deleteCard(@PathVariable Integer id,HttpSession session){
		int count = productService.DeleteProduct(id);
		if(count>0) {
			_mvShare.addObject("status","Xoas thành công");
		}else {
			_mvShare.addObject("status","Thêm thất bại");
		}
		_mvShare.setViewName("admin/category/listProduct");
		return "redirect:/Admin/ListProduct";

    }
	@RequestMapping(value = "/Admin/AddProduct", method = RequestMethod.GET)
	public ModelAndView CreateProduct() {
		_mvShare.addObject("category", categoryService.GetAllCate());
		_mvShare.setViewName("admin/product/addProduct");
		_mvShare.addObject("product", new ProductDTO());
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/AddProduct", method = RequestMethod.POST)
	public String CreateProduct(@ModelAttribute("AddProduct") ProductDTO product) {
		int count = productService.AddProduct(product);
		if(count>0) {
			_mvShare.addObject("status","Thêm thành công");
		}else {
			_mvShare.addObject("status","Thêm thất bại");
		}
		_mvShare.setViewName("admin/product/addProduct");
		return "redirect:/Admin/ListProduct";
	}
	@RequestMapping(value = "/Admin/EditProduct/{id}")
	public ModelAndView EditProduct( @PathVariable Integer id, HttpSession session ,ProductDTO product) {
		ProductDTO productById = productService.GetProductById(id);
		_mvShare.addObject("product", productById);
		if(productById!= null) {
			session.setAttribute("Id", productById.getId());
			session.setAttribute("productName", productById.getProductName());
			session.setAttribute("productContent", productById.getProductContent());
			session.setAttribute("description", productById.getDescription());
			session.setAttribute("price", productById.getPrice());
			session.setAttribute("image", productById.getImage());
			session.setAttribute("quantity", productById.getQuantity());
			session.setAttribute("category_Id", productById.getCategory_Id());
			session.setAttribute("Status", productById.isStatus());
		}
		
		_mvShare.setViewName("admin/product/updateProduct");
		return _mvShare;
	}
	@RequestMapping(value = "/Admin/EditProduct/{id}",  method = RequestMethod.POST)
	public String EditCate(@ModelAttribute("edit") ProductDTO product, @PathVariable Integer id,HttpSession session) {
		session.setAttribute("Id", product.getId());
		int count = productService.UpdateProduct(product);
		if(count>0) {
			_mvShare.addObject("status","Sửa thành công");
		}else {
			_mvShare.addObject("status","Sửa thất bại");
		}
		_mvShare.setViewName("admin/product/updateProduct");
		return "redirect:/Admin/ListProduct";
	}
	
}
