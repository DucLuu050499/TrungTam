package dto;

public class DTO_CanhThi
{
	private int maCanhThi;
	public int getmaCanhThi()
	{
		return this.maCanhThi;
	}
	public void setmaCanhThi(int value)
	{
		this.maCanhThi = value;
	}

	private int maGiaoVien1;
	public int getmaGiaoVien1()
	{
		return this.maGiaoVien1;
	}
	public void setmaGiaoVien1(int value)
	{
		this.maGiaoVien1 = value;
	}

	private int maGiaoVien2;
	public int getmaGiaoVien2()
	{
		return this.maGiaoVien2;
	}
	public void setmaGiaoVien2(int value)
	{
		this.maGiaoVien2 = value;
	}


	public DTO_CanhThi(int maCanhThi,int maGiaoVien1,int maGiaoVien2)
	{
		this.maCanhThi = maCanhThi;
		this.maGiaoVien1 = maGiaoVien1;
		this.maGiaoVien2 = maGiaoVien2;
	}
	
	public DTO_CanhThi()
	{
		this.maCanhThi = -1;
		this.maGiaoVien1 = -1;
		this.maGiaoVien2 = -1;
	}
}
