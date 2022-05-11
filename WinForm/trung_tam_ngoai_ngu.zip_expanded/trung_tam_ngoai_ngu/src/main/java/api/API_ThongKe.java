package api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO_ThongKe;
import dto.DTO_ThongKe;

@RestController
public class API_ThongKe {

	@PostMapping(value = "/thongke_search")
	@ResponseBody
	public DTO_ThongKe[] search() {
		return DAO_ThongKe.getThongKe();
	}
}