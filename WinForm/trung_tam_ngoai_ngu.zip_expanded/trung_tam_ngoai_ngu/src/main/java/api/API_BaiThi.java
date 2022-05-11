package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_BaiThi;
import dto.DTO_BaiThi;

@RestController
public class API_BaiThi {

	@PostMapping(value = "/baithi_search")
	@ResponseBody
	public DTO_BaiThi[] search(@RequestBody DTO_BaiThi baithi) {
		ArrayList<DTO_BaiThi> arr = DAO_BaiThi.searchAPI(baithi);
		return arr.toArray(new DTO_BaiThi[arr.size()]);
	}
	
	@PostMapping(value = "/baithi_create")
	@ResponseBody
	public int create(@RequestBody DTO_BaiThi baithi) {
		return DAO_BaiThi.create(baithi);
	}
	
	@PostMapping(value = "/baithi_update")
	@ResponseBody
	public int update(@RequestBody DTO_BaiThi[] baithi) {
		return DAO_BaiThi.update(baithi[0], baithi[1]);
	}
	
	@PostMapping(value = "/baithi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_BaiThi baithi) {
		return DAO_BaiThi.delete(baithi);
	}
}