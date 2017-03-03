import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockDataItem {

	public Date Date;
	public String Open;
	public String High;
	public String Low;
	public String Close;
	public String Volume;
	public String AdjClose;
	
	
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
		
		this.Open=o;
		this.High=h;
		this.Low=l;
		this.Close=c;
		this.Volume=v;
		this.AdjClose=Ac;
		
	}
	

}
