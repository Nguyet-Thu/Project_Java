package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.DAO.CategoryDAO;
import shop.DAO.ProductDAO;
import shop.DTO.ProductDTO;
import shop.Entity.Category;
@Service
@Transactional
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private CategoryDAO cateDao;
	
	@Autowired
	private ProductDAO proDAO;
	
	public  List<Category> GetDataCategory() {
		// TODO Auto-generated method stub
		return cateDao.GetDataCategorys() ;
	}
	
	public List<ProductDTO> getDataProduct() {
		List<ProductDTO> listproducts = proDAO.GetDataProduct(); 
		return listproducts;
	}
	public List<ProductDTO> getProductNew() {
		List<ProductDTO> productsnew = proDAO.GetProductNew(); 
		return productsnew;
	}

	

	

}
