package shop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.Entity.Category;
import shop.Entity.MappterCategory;
import shop.Service.User.CategoryServiceImpl;

@Repository
public class CategoryDAO {

	@Autowired
	public JdbcTemplate _jdbcTemplate;
	public CategoryServiceImpl catservice;
	
	public List<Category> GetDataCategorys(){
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM Category";
		list = _jdbcTemplate.query(sql, new MappterCategory());
		return list;
	} 
	public int AddCategory(Category cat) {
		StringBuffer  sql= new StringBuffer();
		sql.append("INSERT INTO Category (NameCategory,Description,Status) ");
		sql.append(" VALUES( ");
		sql.append("N'"+cat.getNameCategory()+"', ");
		sql.append("N'"+cat.getDescription()+"', ");
		sql.append("N'"+cat.isStatus()+"'");
		sql.append(")");	
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	private StringBuffer SqlDeleteById(int Id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("DElETE  Category WHERE Id = "+Id);
		return sql;
	}
	public int DeleteCatById(int id) {
		String sql=SqlDeleteById(id).toString();
		int cat = _jdbcTemplate.update(sql.toString());
		return cat;
	}
	public List<Category> GetCateById(int Id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM Category WHERE Id= " + Id);
		String query=sql.toString();
		List<Category> cat = _jdbcTemplate.query(query, new MappterCategory());
		return cat;
	}
	public List<Category> GetNameCateById(int Id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT NameCategory FROM Category WHERE Id= " + Id);
		String query=sql.toString();
		List<Category> cat = _jdbcTemplate.query(query, new MappterCategory());
		return cat;
	}
	public int UpdateCategory(Category cat) {
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE Category SET NameCategory = N' ");
		sql.append(""+cat.getNameCategory()+ "");
		sql.append("' , ");
		sql.append("Description = N' ");
		sql.append(""+cat.getDescription()+ "");
		sql.append("', ");
		sql.append("Status = ");
		sql.append("N'"+cat.isStatus()+"'");
		sql.append("WHERE Id = ");
		sql.append(""+cat.getId()+"");	
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
}
