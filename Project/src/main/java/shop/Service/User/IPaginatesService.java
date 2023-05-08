package shop.Service.User;

import org.springframework.stereotype.Service;

import shop.DTO.PaginatesDTO;

@Service
public interface IPaginatesService {
	public PaginatesDTO GetInfoPaginates(int totalData,int limit, int currentPage);
}
