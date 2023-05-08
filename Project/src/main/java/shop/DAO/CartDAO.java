package shop.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.DTO.CartDTO;
import shop.DTO.ProductDTO;
@Repository
public class CartDAO {
	@Autowired
	ProductDAO productDAO = new ProductDAO();
	public HashMap<Long,CartDTO> AddCart(long id ,HashMap<Long,CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductDTO product = productDAO.FindProductByID(id);
		if(product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		}else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			double totalPrice = product.getPrice()*1;
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long,CartDTO> UpdateCart(long id,int quantity ,HashMap<Long,CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		
		CartDTO itemCart = new CartDTO();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long,CartDTO> DeleteCart(long id,HashMap<Long,CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	public int TotalQuantity(HashMap<Long,CartDTO> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalQuantity +=itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	public double TotalPrice(HashMap<Long,CartDTO> cart) {
		double totalPrice = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalPrice +=itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
