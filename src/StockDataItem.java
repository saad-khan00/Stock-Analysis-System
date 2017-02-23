
public class StockDataItem {

	public String Date;
	public String Open;
	public String High;
	public String Low;
	public String Close;
	public String Volume;
	public String AdjClose;
	
	
	public StockDataItem(String d, String o, String h, String l, String c,String v,String Ac)
	{
		this.Date=d;
		this.Open=o;
		this.High=h;
		this.Low=l;
		this.Close=c;
		this.Volume=v;
		this.AdjClose=Ac;
		
	}
	
	public int GetDay()
	{
		try
		{
			return Integer.parseInt(this.Date.split("/")[1]);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return 0;
	}
	public int GetMonth()
	{
		return Integer.parseInt(this.Date.split("/")[0]);
		
	}
	public int GetYear()
	{
		return Integer.parseInt(this.Date.split("/")[2]);
		
	}

}
