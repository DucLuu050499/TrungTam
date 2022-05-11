package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_ChamThi;
import dto.DTO_ChamThi;

@RestController
public class API_ChamThi {

	@PostMapping(value = "/chamthi_search")
	@ResponseBody
	public DTO_ChamThi[] search(@RequestBody DTO_ChamThi chamthi) {
		ArrayList<DTO_ChamThi> arr = DAO_ChamThi.search(chamthi);
		return arr.toArray(new DTO_ChamThi[arr.size()]);
	}
	
	@PostMapping(value = "/chamthi_create")
	@ResponseBody
	public int create(@RequestBody DTO_ChamThi chamthi) {
		return DAO_ChamThi.create(chamthi);
	}
	
	@PostMapping(value = "/chamthi_update")
	@ResponseBody
	public int update(@RequestBody DTO_ChamThi[] chamthi) {
		return DAO_ChamThi.update(chamthi[0], chamthi[1]);
	}
	
	@PostMapping(value = "/chamthi_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_ChamThi chamthi) {
		return DAO_ChamThi.delete(chamthi);
	}
}