package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MappterBills implements RowMapper<Bills> {
	public Bills mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bills bill = new Bills();
		bill.setId(rs.getInt("Id"));
		bill.setFullName(rs.getString("FullName"));
		bill.setPhone(rs.getString("Phone"));
		bill.setEmail(rs.getString("Email"));
		bill.setAddress(rs.getString("Address"));
		bill.setTotal(rs.getDouble("Total"));
		bill.setQuantity(rs.getInt("Quantity"));
		bill.setNote(rs.getString("Note"));
		return bill;
	}
}
