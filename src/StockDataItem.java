import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockDataItem {

	public Date Date;
	public Double Open;
	public Double High;
	public Double Low;
	public Double Close;
	public Double Volume;
	public Double AdjClose;
	
	
	public StockDataItem(String d, String o, String h, String l, String c,String v,String Ac)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			this.Date = df.parse(d);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			this.Date= new Date(Long.MIN_VALUE);
		}
		
		this.Open=Double.parseDouble(o);
		this.High=Double.parseDouble(h);
		this.Low=Double.parseDouble(l);
		this.Close=Double.parseDouble(c);
		this.Volume=Double.parseDouble(v);
		this.AdjClose=Double.parseDouble(Ac);
		
	}
	
	public StockDataItem(Date d, double close)
	{
		this.Date=d;
		this.Close=close;
	}
	

}
