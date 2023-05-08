package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DTO.ProductDTO;
import shop.Entity.Category;

@Service
public interface IProductService {
	@Autowired
	public ProductDTO GetProductById(int id);
	@Autowired
	public List<ProductDTO> GetAllProduct();
	@Autowired
	public int AddProduct(ProductDTO product);
	public int DeleteProduct(int id);
	public int UpdateProduct(ProductDTO product);
}
