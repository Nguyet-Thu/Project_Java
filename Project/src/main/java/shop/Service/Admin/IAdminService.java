package shop.Service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.Entity.Admin;
@Service
public interface IAdminService {
	
	@Autowired
	public Admin CheckAdmin(Admin admin);

}
