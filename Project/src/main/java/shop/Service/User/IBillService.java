package shop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DTO.CartDTO;
import shop.Entity.BillDetail;
import shop.Entity.Bills;
import shop.Entity.Category;
@Service
public interface IBillService {
	public int AddBill(Bills bill);
	public void AddBillDetail(HashMap<Long, CartDTO> cart);
	List<Bills> GetAllBills();
	public List<BillDetail> GetBDetailsByBill(int id);
}
