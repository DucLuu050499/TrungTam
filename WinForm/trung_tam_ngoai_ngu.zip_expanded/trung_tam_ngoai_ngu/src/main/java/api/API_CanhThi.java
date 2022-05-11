package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_CanhThi;
import dto.DTO_CanhThi;

@RestController
public class API_CanhThi {

	@PostMapping(value = "/canhthi_search")
	@ResponseBody
	public DTO_CanhThi[] search(@RequestBody DTO_CanhThi canhthi) {
		ArrayList<DTO_CanhThi> arr = DAO_CanhThi.search(canhthi);
		return arr.toArray(new DTO_CanhThi[arr.size()]);
	}
	
	@PostMapping(value = "/canhthi_create")
	@ResponseBody
	public int create(@RequestBody DTO_CanhThi canhthi) {
		return DAO_CanhThi.create(canhthi);
	}
	
	@PostMapping(value = "/canhthi_update")
	@ResponseBody
	public int update(@RequestBody DTO_CanhThi[] canhthi) {
		return DAO_CanhThi.update(canhthi[0], canhthi[1]);
	}
	
	@PostMapping(value = "/canhthi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_CanhThi canhthi) {
		return DAO_CanhThi.delete(canhthi);
	}
}