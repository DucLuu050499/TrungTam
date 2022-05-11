package bus;

import java.util.ArrayList;

import dao.DAO_ChamThi;
import dto.DTO_ChamThi;

public class BUS_ChamThi {
	
	public DTO_ChamThi[] getData() {
		ArrayList<DTO_ChamThi> arr = DAO_ChamThi.search(new DTO_ChamThi());
		return arr.toArray(new DTO_ChamThi[arr.size()]);
	}
	
	public DTO_ChamThi[] getData(DTO_ChamThi dto_ChamThi) {
		ArrayList<DTO_ChamThi> arr = DAO_ChamThi.search(dto_ChamThi);
		return arr.toArray(new DTO_ChamThi[arr.size()]);
	}
	
	public int create(DTO_ChamThi dto_ChamThi) {
		return DAO_ChamThi.create(dto_ChamThi);
	}
	
	public int update(DTO_ChamThi dto_ChamThi, DTO_ChamThi dto_ChamThi2) {
		return DAO_ChamThi.update(dto_ChamThi, dto_ChamThi2);
	}
	public int delete(DTO_ChamThi dto_ChamThi) {
		return DAO_ChamThi.delete(dto_ChamThi);
	}
}