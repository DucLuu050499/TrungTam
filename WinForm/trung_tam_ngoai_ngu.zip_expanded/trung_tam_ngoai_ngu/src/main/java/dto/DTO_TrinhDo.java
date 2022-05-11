package dto;

public class DTO_TrinhDo
{
	private int maTrinhDo;
	public int getmaTrinhDo()
	{
		return this.maTrinhDo;
	}
	public void setmaTrinhDo(int value)
	{
		this.maTrinhDo = value;
	}

	private String tenTrinhDo;
	public String gettenTrinhDo()
	{
		return this.tenTrinhDo;
	}
	public void settenTrinhDo(String value)
	{
		this.tenTrinhDo = value;
	}


	public DTO_TrinhDo(int maTrinhDo,String tenTrinhDo)
	{
		this.maTrinhDo = maTrinhDo;
		this.tenTrinhDo = tenTrinhDo;
	}
	
	public DTO_TrinhDo()
	{
		this.maTrinhDo = -1;
		this.tenTrinhDo = "";
	}
}
