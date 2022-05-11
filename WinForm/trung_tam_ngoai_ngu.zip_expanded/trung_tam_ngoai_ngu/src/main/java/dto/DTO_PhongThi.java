package dto;

public class DTO_PhongThi
{
	private int maPhongThi;
	public int getmaPhongThi()
	{
		return this.maPhongThi;
	}
	public void setmaPhongThi(int value)
	{
		this.maPhongThi = value;
	}

	private int maKhoaThi;
	public int getmaKhoaThi()
	{
		return this.maKhoaThi;
	}
	public void setmaKhoaThi(int value)
	{
		this.maKhoaThi = value;
	}

	private int maTrinhDo;
	public int getmaTrinhDo()
	{
		return this.maTrinhDo;
	}
	public void setmaTrinhDo(int value)
	{
		this.maTrinhDo = value;
	}

	private String tenPhongThi;
	public String gettenPhongThi()
	{
		return this.tenPhongThi;
	}
	public void settenPhongThi(String value)
	{
		this.tenPhongThi = value;
	}

	private int caThi;
	public int getcaThi()
	{
		return this.caThi;
	}
	public void setcaThi(int value)
	{
		this.caThi = value;
	}


	public DTO_PhongThi(int maPhongThi,int maKhoaThi,int maTrinhDo,String tenPhongThi,int caThi)
	{
		this.maPhongThi = maPhongThi;
		this.maKhoaThi = maKhoaThi;
		this.maTrinhDo = maTrinhDo;
		this.tenPhongThi = tenPhongThi;
		this.caThi = caThi;
	}
	
	public DTO_PhongThi()
	{
		this.maPhongThi = -1;
		this.maKhoaThi = -1;
		this.maTrinhDo = -1;
		this.tenPhongThi = "";
		this.caThi = -1;
	}
}