package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DTO.ProductDTO;
import shop.Entity.Category;
@Service
public interface IHomeService {
	@Autowired
	public List<Category> GetDataCategory();
	public List<ProductDTO> getDataProduct();
}
