package shop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.DTO.ProductDTO;
import shop.DTO.ProductDTOMapper;
@Repository
public class ProductDAO {

	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	private String SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT TOP 8 * FROM Product ORDER BY Id");
		return sql.toString();
	}
	private String SqlNew() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT TOP 8 * FROM Product ORDER BY Id DESC");
		return sql.toString();
	}
	private StringBuffer ProductCat(int idCat) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT* FROM Product WHERE Category_Id = "+idCat);
		return sql;
	}
	private String SqlProPages(int id,int start,int totalPage) {
		StringBuffer  sql = ProductCat(id);
		sql.append(" SELECT * FROM Product ORDER BY Id OFFSET "+start+" ROWS FETCH FIRST "+ totalPage+" ROWS ONLY");
		return sql.toString();
	}
	
	public List<ProductDTO> GetDataAllProPage(int start,int totalPage) {
		String  sql = " SELECT * FROM Product ORDER BY Id OFFSET "+start+" ROWS FETCH FIRST "+ totalPage+" ROWS ONLY";
		List<ProductDTO> listproduct = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listproduct;
	}
	
	public List<ProductDTO> GetDataProduct() {
		String sql=SqlString();
		List<ProductDTO> listproduct = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listproduct;
	}
	public List<ProductDTO> GetProductNew() {
		String sql=SqlNew();
		List<ProductDTO> productsnew = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return productsnew;
	}
	public List<ProductDTO> GetProductCat(int idCat) {
		String sql=ProductCat(idCat).toString();
		List<ProductDTO> proCat = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return proCat;
	}
	public List<ProductDTO> GetProPages(int id,int start,int totalPage) {
		
		String sql=SqlProPages(id,start,totalPage);
		List<ProductDTO> propage = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return propage;
		
	}

	private StringBuffer SqlGetById(long Id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM Product WHERE Id= "+Id);
		return sql;
	}
	public List<ProductDTO> GetProductById(long id) {
		String sql=SqlGetById(id).toString();
		List<ProductDTO> product = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return product;
	}
	public ProductDTO FindProductByID(long id) {
		String sql=SqlGetById(id).toString();
		ProductDTO product = _jdbcTemplate.queryForObject(sql, new ProductDTOMapper());
		return product;
	}
	public List<ProductDTO> GetAllProduct(){
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM Product";
		list = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return list;
	} 
	public List<ProductDTO> findProductByName(String name){
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM Product where ProductName =N'"+name+"'";
		list = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return list;
	} 
	public int AddProduct(ProductDTO product) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO Product(ProductName,ProductContent,Description,Price,Image,Quantity,Category_Id,Status) ");
		sql.append("VALUES ");
		sql.append("(N' ");
		sql.append(""+product.getProductName()+"");
		sql.append("', ");
		sql.append("N' ");
		sql.append(""+product.getProductContent()+"");
		sql.append("', ");
		sql.append("N' ");
		sql.append(""+product.getDescription()+"");
		sql.append("', ");
		sql.append(""+product.getPrice()+"");
		sql.append(", ");
		sql.append("N'");
		sql.append(""+product.getImage()+"");
		sql.append("', ");
		sql.append(""+product.getQuantity()+"");
		sql.append(", ");
		sql.append(""+product.getCategory_Id()+"");
		sql.append(", ");
		sql.append("'"+product.isStatus()+"')");
	
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	private StringBuffer SqlDeleteById(int Id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("DELETE  Product WHERE Id = "+Id);
		return sql;
	}
	public int DeleteProductById(int id) {
		String sql=SqlDeleteById(id).toString();
		int product = _jdbcTemplate.update(sql.toString());
		return product;
	}
	
	public int UpdateProduct(ProductDTO product) {
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE Product SET ProductName= ");
		sql.append("N' ");
		sql.append(""+product.getProductName()+"");
		sql.append("', ProductContent=");
		sql.append("N' ");
		sql.append(""+product.getProductContent()+"");
		sql.append("', Description =");
		sql.append("N' ");
		sql.append(""+product.getDescription()+"");
		sql.append("', Price =");
		sql.append(""+product.getPrice()+"");
		sql.append(", Image =");
		sql.append("N'");
		sql.append(""+product.getImage()+"");
		sql.append("', Quantity = ");
		sql.append(""+product.getQuantity()+"");
		sql.append(", Category_Id =");
		sql.append(""+product.getCategory_Id()+"");
		sql.append(", Status =");
		sql.append("'"+product.isStatus()+"'");
		sql.append(" WHERE Id = ");
		sql.append(" "+product.getId()+"");	
		int update = _jdbcTemplate.update(sql.toString());
		return update;
	}
	
}
