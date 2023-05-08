package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.DAO.ProductDAO;
import shop.DTO.ProductDTO;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	@Autowired
	 ProductDAO pdao = new ProductDAO();
	@Override
	public ProductDTO GetProductById(int id) {
		List<ProductDTO> listp = pdao.GetProductById(id);
		return listp.get(0);
	}
	
	@Override
	public List<ProductDTO> GetAllProduct() {
		return pdao.GetAllProduct();
	}
	@Override
	public int AddProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return pdao.AddProduct(product);
	}
	@Override
	public int DeleteProduct(int id) {
		return pdao.DeleteProductById(id);
	}
	@Override
	public int UpdateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return pdao.UpdateProduct(product);
	}
	 
	
}
