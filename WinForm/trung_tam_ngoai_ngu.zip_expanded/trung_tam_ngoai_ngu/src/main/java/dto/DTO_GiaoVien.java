package dto;

public class DTO_GiaoVien
{
	private int maGiaoVien;
	public int getmaGiaoVien()
	{
		return this.maGiaoVien;
	}
	public void setmaGiaoVien(int value)
	{
		this.maGiaoVien = value;
	}

	private String tenGiaoVien;
	public String gettenGiaoVien()
	{
		return this.tenGiaoVien;
	}
	public void settenGiaoVien(String value)
	{
		this.tenGiaoVien = value;
	}


	public DTO_GiaoVien(int maGiaoVien,String tenGiaoVien)
	{
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
	}
	
	public DTO_GiaoVien()
	{
		this.maGiaoVien = -1;
		this.tenGiaoVien = "";
	}
	public String[] getTableData() {
		String[] result = {tenGiaoVien};
		return result;
	}
}
