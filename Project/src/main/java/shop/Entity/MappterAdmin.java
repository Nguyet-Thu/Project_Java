package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MappterAdmin implements RowMapper<Admin>{

	
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("Id"));
		admin.setAdminName(rs.getString("AdminName"));
		admin.setPassword(rs.getString("Password"));
		admin.setEmail(rs.getString("Email"));
		admin.setAddress(rs.getString("Address"));
		admin.setPhone(rs.getString("Phone"));
		admin.setStatus(rs.getBoolean("Status"));
		return admin;
	}
	
}
