package dto;

public class DTO_ThiSinh
{
	private String cmnd;
	public String getcmnd()
	{
		return this.cmnd;
	}
	public void setcmnd(String value)
	{
		this.cmnd = value;
	}

	private String ho;
	public String getho()
	{
		return this.ho;
	}
	public void setho(String value)
	{
		this.ho = value;
	}

	private String ten;
	public String getten()
	{
		return this.ten;
	}
	public void setten(String value)
	{
		this.ten = value;
	}

	private String gioiTinh;
	public String getgioiTinh()
	{
		return this.gioiTinh;
	}
	public void setgioiTinh(String value)
	{
		this.gioiTinh = value;
	}

	private java.sql.Date ngaySinh;
	public java.sql.Date getngaySinh()
	{
		return this.ngaySinh;
	}
	public void setngaySinh(java.sql.Date value)
	{
		this.ngaySinh = value;
	}

	private String noiSinh;
	public String getnoiSinh()
	{
		return this.noiSinh;
	}
	public void setnoiSinh(String value)
	{
		this.noiSinh = value;
	}

	private java.sql.Date ngayCap;
	public java.sql.Date getngayCap()
	{
		return this.ngayCap;
	}
	public void setngayCap(java.sql.Date value)
	{
		this.ngayCap = value;
	}

	private String noiCap;
	public String getnoiCap()
	{
		return this.noiCap;
	}
	public void setnoiCap(String value)
	{
		this.noiCap = value;
	}

	private String sdt;
	public String getsdt()
	{
		return this.sdt;
	}
	public void setsdt(String value)
	{
		this.sdt = value;
	}

	private String email;
	public String getemail()
	{
		return this.email;
	}
	public void setemail(String value)
	{
		this.email = value;
	}


	public DTO_ThiSinh(String cmnd,String ho,String ten,String gioiTinh,java.sql.Date ngaySinh,String noiSinh,java.sql.Date ngayCap,String noiCap,String sdt,String email)
	{
		this.cmnd = cmnd;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.sdt = sdt;
		this.email = email;
	}
	
	public DTO_ThiSinh()
	{
		this.cmnd = "";
		this.ho = "";
		this.ten = "";
		this.gioiTinh = "";
		this.ngaySinh = null;
		this.noiSinh = "";
		this.ngayCap = null;
		this.noiCap = "";
		this.sdt = "";
		this.email = "";
	}
	
	public String[] getTableData() {
		String result[] = new String[10];
		result[0] = ho;
		result[1] = ten;
		result[2] = gioiTinh;
		result[3] = support.Method.Date2String(ngaySinh);
		result[4] = noiSinh;
		result[5] = cmnd;
		result[6] = support.Method.Date2String(ngayCap);
		result[7] = noiCap;
		result[8] = sdt;
		result[9] = email;
		return result;
	}
}
