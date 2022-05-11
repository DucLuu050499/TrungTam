package dto;

public class DTO_ThongKe {
	String trinhDo;
	int khoaThi, phongThi, thiSinh;
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public int getKhoaThi() {
		return khoaThi;
	}
	public void setKhoaThi(int khoaThi) {
		this.khoaThi = khoaThi;
	}
	public int getPhongThi() {
		return phongThi;
	}
	public void setPhongThi(int phongThi) {
		this.phongThi = phongThi;
	}
	public int getThiSinh() {
		return thiSinh;
	}
	public void setThiSinh(int thiSinh) {
		this.thiSinh = thiSinh;
	}
	public DTO_ThongKe(String trinhDo, int khoaThi, int phongThi, int thiSinh) {
		super();
		this.trinhDo = trinhDo;
		this.khoaThi = khoaThi;
		this.phongThi = phongThi;
		this.thiSinh = thiSinh;
	}
	
	
}
