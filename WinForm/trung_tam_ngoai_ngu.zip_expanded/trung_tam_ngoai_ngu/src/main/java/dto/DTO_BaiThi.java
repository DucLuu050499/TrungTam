package dto;

public class DTO_BaiThi
{
	private int maBaiThi;
	public int getmaBaiThi()
	{
		return this.maBaiThi;
	}
	public void setmaBaiThi(int value)
	{
		this.maBaiThi = value;
	}

	private int maCanhThi;
	public int getmaCanhThi()
	{
		return this.maCanhThi;
	}
	public void setmaCanhThi(int value)
	{
		this.maCanhThi = value;
	}

	private int maChamThi;
	public int getmaChamThi()
	{
		return this.maChamThi;
	}
	public void setmaChamThi(int value)
	{
		this.maChamThi = value;
	}

	private double diemNghe;
	public double getdiemNghe()
	{
		return this.diemNghe;
	}
	public void setdiemNghe(double value)
	{
		this.diemNghe = value;
	}

	private double diemNoi;
	public double getdiemNoi()
	{
		return this.diemNoi;
	}
	public void setdiemNoi(double value)
	{
		this.diemNoi = value;
	}

	private double diemDoc;
	public double getdiemDoc()
	{
		return this.diemDoc;
	}
	public void setdiemDoc(double value)
	{
		this.diemDoc = value;
	}

	private double diemViet;
	public double getdiemViet()
	{
		return this.diemViet;
	}
	public void setdiemViet(double value)
	{
		this.diemViet = value;
	}

	private String maThiSinh, sbd, hoTen, cmnd, tenPhongThi, tenKhoaThi;
	
	private int maPhongThi;
	

	public int getMaPhongThi() {
		return maPhongThi;
	}
	public void setMaPhongThi(int maPhongThi) {
		this.maPhongThi = maPhongThi;
	}
	private java.sql.Date ngayThi;
	private int caThi;
	
	public java.sql.Date getNgayThi() {
		return ngayThi;
	}
	public void setNgayThi(java.sql.Date ngayThi) {
		this.ngayThi = ngayThi;
	}
	public int getCaThi() {
		return caThi;
	}
	public void setCaThi(int caThi) {
		this.caThi = caThi;
	}
	public DTO_BaiThi(int maBaiThi, double diemNghe, double diemNoi, double diemDoc, double diemViet, String maThiSinh,
			String sbd, String hoTen, String cmnd, String tenPhongThi, String tenKhoaThi) {
		super();
		this.maBaiThi = maBaiThi;
		this.diemNghe = diemNghe;
		this.diemNoi = diemNoi;
		this.diemDoc = diemDoc;
		this.diemViet = diemViet;
		this.maThiSinh = maThiSinh;
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.tenPhongThi = tenPhongThi;
		this.tenKhoaThi = tenKhoaThi;
	}
	public DTO_BaiThi(int maBaiThi, double diemNghe, double diemNoi, double diemDoc, double diemViet, String maThiSinh,
			String sbd, String hoTen, String cmnd, String tenPhongThi, String tenKhoaThi, java.sql.Date ngayThi, int caThi) {
		super();
		this.maBaiThi = maBaiThi;
		this.diemNghe = diemNghe;
		this.diemNoi = diemNoi;
		this.diemDoc = diemDoc;
		this.diemViet = diemViet;
		this.maThiSinh = maThiSinh;
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.tenPhongThi = tenPhongThi;
		this.tenKhoaThi = tenKhoaThi;
		this.ngayThi = ngayThi;
		this.caThi = caThi;
	}
	private String sdt;
	
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public String getSbd() {
		return sbd;
	}
	public void setSbd(String sbd) {
		this.sbd = sbd;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTenPhongThi() {
		return tenPhongThi;
	}
	public void setTenPhongThi(String tenPhongThi) {
		this.tenPhongThi = tenPhongThi;
	}
	public String getTenKhoaThi() {
		return tenKhoaThi;
	}
	public void setTenKhoaThi(String tenKhoaThi) {
		this.tenKhoaThi = tenKhoaThi;
	}
	private int maKhoaThi;
	
	public int getMaKhoaThi() {
		return maKhoaThi;
	}
	public void setMaKhoaThi(int maKhoaThi) {
		this.maKhoaThi = maKhoaThi;
	}
	public DTO_BaiThi(int maBaiThi,int maCanhThi,int maChamThi,double diemNghe,double diemNoi,double diemDoc,double diemViet)
	{
		this.maBaiThi = maBaiThi;
		this.maCanhThi = maCanhThi;
		this.maChamThi = maChamThi;
		this.diemNghe = diemNghe;
		this.diemNoi = diemNoi;
		this.diemDoc = diemDoc;
		this.diemViet = diemViet;
	}
	
	public DTO_BaiThi()
	{
		this.maBaiThi = -1;
		this.maCanhThi = -1;
		this.maChamThi = -1;
		this.diemNghe = -1;
		this.diemNoi = -1;
		this.diemDoc = -1;
		this.diemViet = -1;
		this.maPhongThi = -1;
		this.maKhoaThi = -1;
		sdt = "";
	}
	
	public String[] getTableData() {
		String result[] = {sbd,hoTen, cmnd, tenPhongThi, tenKhoaThi,String.valueOf(diemNghe),String.valueOf(diemNoi),String.valueOf(diemDoc),String.valueOf(diemViet)};
		return result;
	}
}
