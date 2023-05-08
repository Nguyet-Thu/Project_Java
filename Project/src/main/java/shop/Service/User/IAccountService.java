package shop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DTO.ProductDTO;
import shop.Entity.Category;
import shop.Entity.Users;
@Service
public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
	@Autowired
	public List<Users> GetAllUsers();
	@Autowired
	public Users CheckAccount(Users user);
	int DeleteCustomer(int id);
}
