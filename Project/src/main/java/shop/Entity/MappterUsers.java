package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class MappterUsers implements RowMapper<Users>{

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("Id"));
		user.setUserName(rs.getString("UserName"));
		user.setPassword(rs.getString("Password"));
		user.setFullName(rs.getString("FullName"));
		user.setEmail(rs.getString("Email"));
		user.setGender(rs.getString("Gender"));
		user.setAddress(rs.getString("Address"));
		user.setPhone(rs.getString("Phone"));
		return user;
	}
	
}
