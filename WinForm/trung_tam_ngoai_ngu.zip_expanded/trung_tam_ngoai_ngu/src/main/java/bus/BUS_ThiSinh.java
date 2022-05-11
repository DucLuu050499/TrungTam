package bus;

import java.util.ArrayList;

import dao.DAO_ThiSinh;
import dto.DTO_ThiSinh;

public class BUS_ThiSinh {
	
	public DTO_ThiSinh[] getData() {
		ArrayList<DTO_ThiSinh> arr = DAO_ThiSinh.search(new DTO_ThiSinh());
		return arr.toArray(new DTO_ThiSinh[arr.size()]);
	}
	
	public DTO_ThiSinh[] getData(DTO_ThiSinh dto_ThiSinh) {
		ArrayList<DTO_ThiSinh> arr = DAO_ThiSinh.search(dto_ThiSinh);
		return arr.toArray(new DTO_ThiSinh[arr.size()]);
	}
	
	public int create(DTO_ThiSinh dto_ThiSinh) {
		return DAO_ThiSinh.create(dto_ThiSinh);
	}
	
	public int update(DTO_ThiSinh dto_ThiSinh, DTO_ThiSinh dto_ThiSinh2) {
		return DAO_ThiSinh.update(dto_ThiSinh, dto_ThiSinh2);
	}
	public int delete(DTO_ThiSinh dto_ThiSinh) {
		return DAO_ThiSinh.delete(dto_ThiSinh);
	}
}