package shop.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDTOMapper implements RowMapper<ProductDTO>{

	@Override
	public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDTO products = new ProductDTO();
		products.setId(rs.getInt("Id"));
		products.setProductName(rs.getString("ProductName"));
		products.setProductContent(rs.getString("ProductContent"));
		products.setDescription(rs.getString("Description"));
		products.setPrice(rs.getDouble("Price"));
		products.setImage(rs.getString("Image"));
		products.setQuantity(rs.getInt("Quantity"));
		products.setCategory_Id(rs.getInt("Category_Id"));
		products.setStatus(rs.getBoolean("Status"));
		return products;
	}

}
