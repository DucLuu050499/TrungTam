package bus;

import java.util.ArrayList;

import dao.DAO_KhoaThi;
import dto.DTO_KhoaThi;

public class BUS_KhoaThi {
	
	public DTO_KhoaThi[] getData() {
		ArrayList<DTO_KhoaThi> arr = DAO_KhoaThi.search(new DTO_KhoaThi());
		return arr.toArray(new DTO_KhoaThi[arr.size()]);
	}
	
	public DTO_KhoaThi[] getData(DTO_KhoaThi dto_KhoaThi) {
		ArrayList<DTO_KhoaThi> arr = DAO_KhoaThi.search(dto_KhoaThi);
		return arr.toArray(new DTO_KhoaThi[arr.size()]);
	}
	
	public int create(DTO_KhoaThi dto_KhoaThi) {
		return DAO_KhoaThi.create(dto_KhoaThi);
	}
	
	public int update(DTO_KhoaThi dto_KhoaThi, DTO_KhoaThi dto_KhoaThi2) {
		return DAO_KhoaThi.update(dto_KhoaThi, dto_KhoaThi2);
	}
	public int delete(DTO_KhoaThi dto_KhoaThi) {
		return DAO_KhoaThi.delete(dto_KhoaThi);
	}
}