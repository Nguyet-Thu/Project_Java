package shop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.DAO.CategoryDAO;
import shop.DAO.ProductDAO;
import shop.DTO.ProductDTO;
import shop.Entity.Category;
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductDTO> GetAllDataProduct() {
		return productDAO.GetAllProduct();
	}
	@Override
	public List<ProductDTO> GetAllDataProductById(int id) {
		return productDAO.GetProductCat(id);
	}

	
	public List<ProductDTO> GetDataAllProductPaginate(int start, int totalPage) {
		List<ProductDTO> products = productDAO.GetDataAllProPage(start, totalPage);
		return products;
	}
	@Override
	public List<ProductDTO> GetDataProductPaginate(int id, int start, int totalPage) {
		List<ProductDTO> products = productDAO.GetProPages(id,start, totalPage);
		return products;
	}

	@Override
	public List<Category> GetAllCate() {
		return categoryDAO.GetDataCategorys();
	}
	
	@Override
	public int AddCat(Category cat) {
		return categoryDAO.AddCategory(cat);

	}

	@Override
	public int DeleteCat(int id) {
		return categoryDAO.DeleteCatById(id);

	}

	@Override
	public Category GetCatById(int id) {
		List<Category> listcate = categoryDAO.GetCateById(id);
		return listcate.get(0);
	}
	@Override
	public int UpdateCat(Category cat) {
		
		return categoryDAO.UpdateCategory(cat);
	}

	@Override
	public Category GetNameById(int id) {
		List<Category> listcate =  categoryDAO.GetCateById(id);
		return listcate.get(0);
	}
}
