package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_TrinhDo;
import dto.DTO_TrinhDo;

@RestController
public class API_TrinhDo {

	@PostMapping(value = "/trinhdo_search")
	@ResponseBody
	public DTO_TrinhDo[] search(@RequestBody DTO_TrinhDo trinhdo) {
		ArrayList<DTO_TrinhDo> arr = DAO_TrinhDo.search(trinhdo);
		return arr.toArray(new DTO_TrinhDo[arr.size()]);
	}
	
	@PostMapping(value = "/trinhdo_create")
	@ResponseBody
	public int create(@RequestBody DTO_TrinhDo trinhdo) {
		return DAO_TrinhDo.create(trinhdo);
	}
	
	@PostMapping(value = "/trinhdo_update")
	@ResponseBody
	public int update(@RequestBody DTO_TrinhDo[] trinhdo) {
		return DAO_TrinhDo.update(trinhdo[0], trinhdo[1]);
	}
	
	@PostMapping(value = "/trinhdo_delete")
	@ResponseBody
	public int delete(@RequestBody DTO_TrinhDo trinhdo) {
		return DAO_TrinhDo.delete(trinhdo);
	}
}