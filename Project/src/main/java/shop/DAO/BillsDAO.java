package shop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import shop.Entity.BillDetail;
import shop.Entity.Bills;
import shop.Entity.MappterBillDetail;
import shop.Entity.MappterBills;
@Repository
public class BillsDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Bills> GetAllBills() {
		
		List<Bills> list = new ArrayList<Bills>();
		String sql =" SELECT * FROM Bills";
		list = _jdbcTemplate.query(sql, new MappterBills());
		return list;

	}
	public int AddBills(Bills bills) {
		StringBuffer  sql= new StringBuffer();
		sql.append("INSERT INTO Bills(FullName ,Email,Address ,Phone,Total,Quantity,Note) ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("N'"+bills.getFullName()+"', ");
		sql.append("N'"+bills.getEmail()+"', ");
		sql.append("N'"+bills.getAddress()+"', ");
		sql.append("'"+bills.getPhone()+"', ");
		sql.append(""+bills.getTotal()+", ");
		sql.append(""+bills.getQuantity()+", ");
		sql.append("N'"+bills.getNote()+"' ");
		sql.append(")");	
		int insertbill = _jdbcTemplate.update(sql.toString());
		return insertbill;
	}
	
	public int GetIdLastBill() {
		StringBuffer  sql= new StringBuffer();
		sql.append("Select MAX(Id) from Bills");
		int id = _jdbcTemplate.queryForObject(sql.toString(),new Object[] {},Integer.class);
		return id ;
	}
	
	public int AddBillDetail(BillDetail billdetail) {
		StringBuffer  sql= new StringBuffer();
		sql.append("INSERT INTO BillDetail(ProductId ,Bill_Id,Quantity,Total) ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append(""+billdetail.getProductId()+", ");
		sql.append(""+billdetail.getBill_Id()+", ");
		sql.append(""+billdetail.getQuantity()+", ");
		sql.append(""+billdetail.getTotal()+"");
		sql.append(")");	
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	private StringBuffer SqlGetById(long id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM BillDetail WHERE Bill_Id = "+id);
		return sql;
	}
	public List<BillDetail> GetBillsDetailByBillId(long id) {
		String sql=SqlGetById(id).toString();
		List<BillDetail> billdetails = _jdbcTemplate.query(sql, new MappterBillDetail());
		return billdetails;
	}
}
