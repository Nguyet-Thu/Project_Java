package shop.Service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DAO.AdminDAO;
import shop.Entity.Admin;
@Service
public class AdminService implements IAdminService{
	@Autowired
	AdminDAO adminDAO = new AdminDAO();
	
	
	
	@Override
	public Admin CheckAdmin(Admin admin) {
		String password= admin.getPassword();
		admin = adminDAO.GetAdminByAcc(admin);
		if(admin != null) {
			if(password.equals(admin.getPassword())) {
				return admin;
			}else {
				return null;
			}
		}
		return null;
	}



	


	

}
