package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_ThiSinhDuThi;
import dto.DTO_ThiSinhDuThi;

@RestController
public class API_ThiSinhDuThi {

	@PostMapping(value = "/thisinhduthi_search")
	@ResponseBody
	public DTO_ThiSinhDuThi[] search(@RequestBody DTO_ThiSinhDuThi thisinhduthi) {
		ArrayList<DTO_ThiSinhDuThi> arr = DAO_ThiSinhDuThi.search(thisinhduthi);
		return arr.toArray(new DTO_ThiSinhDuThi[arr.size()]);
	}
	
	@PostMapping(value = "/thisinhduthi_create")
	@ResponseBody
	public int create(@RequestBody DTO_ThiSinhDuThi thisinhduthi) {
		return DAO_ThiSinhDuThi.create(thisinhduthi);
	}
	
	@PostMapping(value = "/thisinhduthi_update")
	@ResponseBody
	public int update(@RequestBody DTO_ThiSinhDuThi[] thisinhduthi) {
		return DAO_ThiSinhDuThi.update(thisinhduthi[0], thisinhduthi[1]);
	}
	
	@PostMapping(value = "/thisinhduthi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_ThiSinhDuThi thisinhduthi) {
		return DAO_ThiSinhDuThi.delete(thisinhduthi);
	}
}