package shop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import shop.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<Long,CartDTO> AddCart(long id ,HashMap<Long,CartDTO> cart);
	public HashMap<Long,CartDTO> UpdateCart(long id,int quantity ,HashMap<Long,CartDTO> cart);
	public HashMap<Long,CartDTO> DeleteCart(long id,HashMap<Long,CartDTO> cart);
	public int TotalQuantity(HashMap<Long,CartDTO> cart);
	public double TotalPrice(HashMap<Long,CartDTO> cart);
}
