package shop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.Entity.MappterUsers;
import shop.Entity.Users;
@Repository
public class UserDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int AddAcount(Users user) {
		StringBuffer  sql= new StringBuffer();
		sql.append("INSERT INTO Customer(UserName ,Password,FullName,Email ,Gender ,Address ,Phone) ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("'"+user.getUserName()+"', ");
		sql.append("'"+user.getPassword()+"', ");
		sql.append("N'"+user.getFullName()+"', ");
		sql.append("N'"+user.getEmail()+"', ");
		sql.append("'"+user.getGender()+"', ");
		sql.append("N'"+user.getAddress()+"', ");
		sql.append("'"+user.getPhone()+"' ");
		sql.append(")");	
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	public List<Users> GetAll() {
		
		List<Users> list = new ArrayList<Users>();
		String sql ="SELECT * FROM Customer";
		list = _jdbcTemplate.query(sql, new MappterUsers());
		return list;

	}
	public Users GetUSerByAcc(Users user) {
		String sql =" SELECT * FROM Customer WHERE UserName='"+user.getUserName()+"'";

		Users rs = _jdbcTemplate.queryForObject(sql, new MappterUsers());

		return rs;
	}
	public int DeleteCustomerById(int id) {
		String sql="DELETE  Customer WHERE Id = "+ id;
		int cat = _jdbcTemplate.update(sql.toString());
		return cat;
	}
}
