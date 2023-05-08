package shop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DAO.UserDAO;
import shop.Entity.Users;
@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	UserDAO usersDAO = new UserDAO();
	
	@Override
	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return usersDAO.AddAcount(user);
	}

	@Override
	public Users CheckAccount(Users user) {
		String pass= user.getPassword();
		user = usersDAO.GetUSerByAcc(user);
		if(user != null) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Users> GetAllUsers() {
		// TODO Auto-generated method stub
		return usersDAO.GetAll();
	}
	
	@Override
	public int DeleteCustomer(int id) {
		return usersDAO.DeleteCustomerById(id);

	}
	

}
