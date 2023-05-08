package shop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.Entity.Admin;
import shop.Entity.MappterAdmin;

@Repository
public class AdminDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Admin> GetListAdmin() {
		
		List<Admin> list = new ArrayList<Admin>();
		String sql =" SELECT * FROM Admin";
		list = _jdbcTemplate.query(sql, new MappterAdmin());
		return list;

	}
	public Admin GetAdminByAcc(Admin admin) {
		String sql ="SELECT * FROM Admin WHERE AdminName='"+admin.getAdminName()+"'";
		Admin ad = _jdbcTemplate.queryForObject(sql, new MappterAdmin());
		return ad;
	}
	
}
