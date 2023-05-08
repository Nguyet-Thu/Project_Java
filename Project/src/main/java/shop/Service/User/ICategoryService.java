package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DTO.ProductDTO;
import shop.Entity.Category;
import shop.Entity.Users;
@Service
public interface ICategoryService {
	@Autowired
	public List<ProductDTO> GetAllDataProductById(int id);
	@Autowired
	public List<ProductDTO> GetDataProductPaginate(int id,int start,int totalPage);
	@Autowired
	public List<Category> GetAllCate();
	@Autowired
	public int AddCat(Category cat);
	public int DeleteCat(int id);
	public int UpdateCat(Category cat);
	Category GetCatById(int id);
	Category GetNameById(int id);
	List<ProductDTO> GetAllDataProduct();
	List<ProductDTO> GetDataAllProductPaginate(int start, int totalPage);
}
