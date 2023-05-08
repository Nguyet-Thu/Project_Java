package shop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.DAO.CartDAO;
import shop.DTO.CartDTO;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartDAO cartDAO = new CartDAO();

	@Override
	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDTO> UpdateCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.UpdateCart(id, quantity, cart);
	}

	@Override
	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuantity(HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.TotalQuantity(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.TotalPrice(cart);
	}
}
