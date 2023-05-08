package shop.Service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DAO.BillsDAO;
import shop.DTO.CartDTO;
import shop.DTO.ProductDTO;
import shop.DTO.ProductDTOMapper;
import shop.Entity.BillDetail;
import shop.Entity.Bills;
import shop.Entity.Category;
@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillsDAO billsDAO;
	
	@Override
	public List<Bills> GetAllBills() {
		return billsDAO.GetAllBills();
	}
	
	@Override
	public int AddBill(Bills bill) {
		// TODO Auto-generated method stub
		return billsDAO.AddBills(bill);
	}

	@Override
	public void AddBillDetail(HashMap<Long, CartDTO> cart) {
		int idBills = billsDAO.GetIdLastBill();
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			BillDetail billdetail = new BillDetail();
			billdetail.setBill_Id(idBills);
			billdetail.setProductId(itemCart.getValue().getProduct().getId());
			billdetail.setQuantity(itemCart.getValue().getQuantity());
			billdetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDAO.AddBillDetail(billdetail);
		}
		
	}

	@Override
	public List<BillDetail> GetBDetailsByBill(int id) {
		// TODO Auto-generated method stub
		return billsDAO.GetBillsDetailByBillId(id);
	}
	
}
