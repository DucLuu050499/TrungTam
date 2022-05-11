package bus;

import java.util.ArrayList;

import dao.DAO_TrinhDo;
import dto.DTO_TrinhDo;

public class BUS_TrinhDo {
	
	public DTO_TrinhDo[] getData() {
		ArrayList<DTO_TrinhDo> arr = DAO_TrinhDo.search(new DTO_TrinhDo());
		return arr.toArray(new DTO_TrinhDo[arr.size()]);
	}
	
	public DTO_TrinhDo[] getData(DTO_TrinhDo dto_TrinhDo) {
		ArrayList<DTO_TrinhDo> arr = DAO_TrinhDo.search(dto_TrinhDo);
		return arr.toArray(new DTO_TrinhDo[arr.size()]);
	}
	
	public int create(DTO_TrinhDo dto_TrinhDo) {
		return DAO_TrinhDo.create(dto_TrinhDo);
	}
	
	public int update(DTO_TrinhDo dto_TrinhDo, DTO_TrinhDo dto_TrinhDo2) {
		return DAO_TrinhDo.update(dto_TrinhDo, dto_TrinhDo2);
	}
	public int delete(DTO_TrinhDo dto_TrinhDo) {
		return DAO_TrinhDo.delete(dto_TrinhDo);
	}
}