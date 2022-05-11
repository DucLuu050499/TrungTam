package bus;

import java.util.ArrayList;

import dao.DAO_GiaoVien;
import dto.DTO_GiaoVien;

public class BUS_GiaoVien {
	
	public DTO_GiaoVien[] getData() {
		ArrayList<DTO_GiaoVien> arr = DAO_GiaoVien.search(new DTO_GiaoVien());
		return arr.toArray(new DTO_GiaoVien[arr.size()]);
	}
	
	public DTO_GiaoVien[] getData(DTO_GiaoVien dto_GiaoVien) {
		ArrayList<DTO_GiaoVien> arr = DAO_GiaoVien.search(dto_GiaoVien);
		return arr.toArray(new DTO_GiaoVien[arr.size()]);
	}
	
	public int create(DTO_GiaoVien dto_GiaoVien) {
		return DAO_GiaoVien.create(dto_GiaoVien);
	}
	
	public int update(DTO_GiaoVien dto_GiaoVien, DTO_GiaoVien dto_GiaoVien2) {
		return DAO_GiaoVien.update(dto_GiaoVien, dto_GiaoVien2);
	}
	public int delete(DTO_GiaoVien dto_GiaoVien) {
		return DAO_GiaoVien.delete(dto_GiaoVien);
	}
}