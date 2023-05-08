package shop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MappterCategory implements RowMapper<Category>{
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException{
		Category category = new Category();
		category.setId(rs.getInt("Id"));
		category.setNameCategory(rs.getString("NameCategory"));
		category.setDescription(rs.getString("Description"));
		category.setStatus(rs.getBoolean("Status"));
		return category;
	}
}
