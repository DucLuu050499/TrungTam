package bus;

import java.util.ArrayList;

import dao.DAO_CanhThi;
import dto.DTO_CanhThi;

public class BUS_CanhThi {
	
	public DTO_CanhThi[] getData() {
		ArrayList<DTO_CanhThi> arr = DAO_CanhThi.search(new DTO_CanhThi());
		return arr.toArray(new DTO_CanhThi[arr.size()]);
	}
	
	public DTO_CanhThi[] getData(DTO_CanhThi dto_CanhThi) {
		ArrayList<DTO_CanhThi> arr = DAO_CanhThi.search(dto_CanhThi);
		return arr.toArray(new DTO_CanhThi[arr.size()]);
	}
	
	public int create(DTO_CanhThi dto_CanhThi) {
		return DAO_CanhThi.create(dto_CanhThi);
	}
	
	public int update(DTO_CanhThi dto_CanhThi, DTO_CanhThi dto_CanhThi2) {
		return DAO_CanhThi.update(dto_CanhThi, dto_CanhThi2);
	}
	public int delete(DTO_CanhThi dto_CanhThi) {
		return DAO_CanhThi.delete(dto_CanhThi);
	}
}