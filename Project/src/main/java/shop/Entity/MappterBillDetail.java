package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MappterBillDetail implements RowMapper<BillDetail>{
	public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException{
		BillDetail billdetail = new BillDetail();
		billdetail.setId(rs.getInt("Id"));
		billdetail.setProductId(rs.getInt("ProductId"));
		billdetail.setBill_Id(rs.getInt("Bill_Id"));
		billdetail.setQuantity(rs.getInt("Quantity"));
		billdetail.setTotal(rs.getDouble("Total"));
		return billdetail;
	}
}
