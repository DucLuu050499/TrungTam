package dto;

public class DTO_ThiSinhDuThi
{
	private int maThiSinh;
	public int getmaThiSinh()
	{
		return this.maThiSinh;
	}
	public void setmaThiSinh(int value)
	{
		this.maThiSinh = value;
	}

	private String cmnd;
	public String getcmnd()
	{
		return this.cmnd;
	}
	public void setcmnd(String value)
	{
		this.cmnd = value;
	}

	private int maPhongThi;
	public int getmaPhongThi()
	{
		return this.maPhongThi;
	}
	public void setmaPhongThi(int value)
	{
		this.maPhongThi = value;
	}

	private int maBaiThi;
	public int getmaBaiThi()
	{
		return this.maBaiThi;
	}
	public void setmaBaiThi(int value)
	{
		this.maBaiThi = value;
	}

	private String sbd;
	public String getsbd()
	{
		return this.sbd;
	}
	public void setsbd(String value)
	{
		this.sbd = value;
	}
	
	private String hoTen;
	
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	private String sdt;
	
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	private String tenPhongThi;	
	public String getTenPhongThi() {
		return tenPhongThi;
	}
	public void setTenPhongThi(String tenPhongThi) {
		this.tenPhongThi = tenPhongThi;
	}
	public DTO_ThiSinhDuThi(int maThiSinh,String cmnd,int maPhongThi,int maBaiThi,String sbd)
	{
		this.maThiSinh = maThiSinh;
		this.cmnd = cmnd;
		this.maPhongThi = maPhongThi;
		this.maBaiThi = maBaiThi;
		this.sbd = sbd;
	}
	
	public DTO_ThiSinhDuThi(int maThiSinh,String cmnd,int maPhongThi,int maBaiThi,String sbd, String hoTen, String sdt, String tenPhongThi)
	{
		this.maThiSinh = maThiSinh;
		this.cmnd = cmnd;
		this.maPhongThi = maPhongThi;
		this.maBaiThi = maBaiThi;
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.tenPhongThi = tenPhongThi;
	}
	
	public DTO_ThiSinhDuThi()
	{
		this.maThiSinh = -1;
		this.cmnd = "";
		this.maPhongThi = -1;
		this.maBaiThi = -1;
		this.sbd = "";
		this.hoTen= "";
		this.sdt = "";
		tenPhongThi = "";
	}
	public String[] getTableData() {
		
		String[] result = {sbd, hoTen, cmnd, sdt, tenPhongThi};
		return result;
	}
}
