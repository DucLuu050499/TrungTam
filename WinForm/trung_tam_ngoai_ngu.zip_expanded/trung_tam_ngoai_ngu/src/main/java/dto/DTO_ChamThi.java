package dto;

public class DTO_ChamThi
{
	private int maChamThi;
	public int getmaChamThi()
	{
		return this.maChamThi;
	}
	public void setmaChamThi(int value)
	{
		this.maChamThi = value;
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


	public DTO_ChamThi(int maChamThi,int maGiaoVien1,int maGiaoVien2)
	{
		this.maChamThi = maChamThi;
		this.maGiaoVien1 = maGiaoVien1;
		this.maGiaoVien2 = maGiaoVien2;
	}
	
	public DTO_ChamThi()
	{
		this.maChamThi = -1;
		this.maGiaoVien1 = -1;
		this.maGiaoVien2 = -1;
	}
}
