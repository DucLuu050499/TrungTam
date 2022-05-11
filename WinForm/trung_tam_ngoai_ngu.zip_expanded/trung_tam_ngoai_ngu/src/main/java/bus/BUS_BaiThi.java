package bus;

import java.util.ArrayList;

import dao.DAO_BaiThi;
import dto.DTO_BaiThi;

public class BUS_BaiThi {
	
	public DTO_BaiThi[] getData() {
		ArrayList<DTO_BaiThi> arr = DAO_BaiThi.search(new DTO_BaiThi());
		return arr.toArray(new DTO_BaiThi[arr.size()]);
	}
	
	public DTO_BaiThi[] getData(DTO_BaiThi dto_BaiThi) {
		ArrayList<DTO_BaiThi> arr = DAO_BaiThi.search(dto_BaiThi);
		return arr.toArray(new DTO_BaiThi[arr.size()]);
	}
	
	public int create(DTO_BaiThi dto_BaiThi) {
		return DAO_BaiThi.create(dto_BaiThi);
	}
	
	public int update(DTO_BaiThi dto_BaiThi, DTO_BaiThi dto_BaiThi2) {
		return DAO_BaiThi.update(dto_BaiThi, dto_BaiThi2);
	}
	public int delete(DTO_BaiThi dto_BaiThi) {
		return DAO_BaiThi.delete(dto_BaiThi);
	}
}