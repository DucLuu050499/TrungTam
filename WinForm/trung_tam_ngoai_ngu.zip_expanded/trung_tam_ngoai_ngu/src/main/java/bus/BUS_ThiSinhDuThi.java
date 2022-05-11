package bus;

import java.util.ArrayList;

import dao.DAO_ThiSinhDuThi;
import dto.DTO_ThiSinhDuThi;

public class BUS_ThiSinhDuThi {
	
	public DTO_ThiSinhDuThi[] getData() {
		ArrayList<DTO_ThiSinhDuThi> arr = DAO_ThiSinhDuThi.search(new DTO_ThiSinhDuThi());
		return arr.toArray(new DTO_ThiSinhDuThi[arr.size()]);
	}
	
	public DTO_ThiSinhDuThi[] getData(DTO_ThiSinhDuThi dto_ThiSinhDuThi) {
		ArrayList<DTO_ThiSinhDuThi> arr = DAO_ThiSinhDuThi.search(dto_ThiSinhDuThi);
		return arr.toArray(new DTO_ThiSinhDuThi[arr.size()]);
	}
	
	public int create(DTO_ThiSinhDuThi dto_ThiSinhDuThi) {
		return DAO_ThiSinhDuThi.create(dto_ThiSinhDuThi);
	}
	
	public int update(DTO_ThiSinhDuThi dto_ThiSinhDuThi, DTO_ThiSinhDuThi dto_ThiSinhDuThi2) {
		return DAO_ThiSinhDuThi.update(dto_ThiSinhDuThi, dto_ThiSinhDuThi2);
	}
	public int delete(DTO_ThiSinhDuThi dto_ThiSinhDuThi) {
		return DAO_ThiSinhDuThi.delete(dto_ThiSinhDuThi);
	}
}