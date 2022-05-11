package bus;

import java.util.ArrayList;

import dao.DAO_PhongThi;
import dto.DTO_PhongThi;

public class BUS_PhongThi {
	
	public DTO_PhongThi[] getData() {
		ArrayList<DTO_PhongThi> arr = DAO_PhongThi.search(new DTO_PhongThi());
		return arr.toArray(new DTO_PhongThi[arr.size()]);
	}
	
	public DTO_PhongThi[] getData(DTO_PhongThi dto_PhongThi) {
		ArrayList<DTO_PhongThi> arr = DAO_PhongThi.search(dto_PhongThi);
		return arr.toArray(new DTO_PhongThi[arr.size()]);
	}
	
	public int create(DTO_PhongThi dto_PhongThi) {
		return DAO_PhongThi.create(dto_PhongThi);
	}
	
	public int update(DTO_PhongThi dto_PhongThi, DTO_PhongThi dto_PhongThi2) {
		return DAO_PhongThi.update(dto_PhongThi, dto_PhongThi2);
	}
	public int delete(DTO_PhongThi dto_PhongThi) {
		return DAO_PhongThi.delete(dto_PhongThi);
	}
}