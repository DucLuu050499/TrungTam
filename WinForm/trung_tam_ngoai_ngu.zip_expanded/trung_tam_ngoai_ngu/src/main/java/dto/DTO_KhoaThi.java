package dto;

public class DTO_KhoaThi
{
	private int maKhoaThi;
	public int getmaKhoaThi()
	{
		return this.maKhoaThi;
	}
	public void setmaKhoaThi(int value)
	{
		this.maKhoaThi = value;
	}

	private String tenKhoaThi;
	public String gettenKhoaThi()
	{
		return this.tenKhoaThi;
	}
	public void settenKhoaThi(String value)
	{
		this.tenKhoaThi = value;
	}

	private java.sql.Date ngayThi;
	public java.sql.Date getngayThi()
	{
		return this.ngayThi;
	}
	public void setngayThi(java.sql.Date value)
	{
		this.ngayThi = value;
	}


	public DTO_KhoaThi(int maKhoaThi,String tenKhoaThi,java.sql.Date ngayThi)
	{
		this.maKhoaThi = maKhoaThi;
		this.tenKhoaThi = tenKhoaThi;
		this.ngayThi = ngayThi;
	}
	
	public DTO_KhoaThi()
	{
		this.maKhoaThi = -1;
		this.tenKhoaThi = "";
		this.ngayThi = null;
	}
	
	public String[] getTableData() {
		String result[] = new String[2];
		result[0] = tenKhoaThi;
		result[1] = support.Method.Date2String(ngayThi);
		return result;
	}
}
