import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StockEntity {

	String csvFile = "Datasource/Sampledata.csv";
	
	public String name;
    public String filePath="";
	public ArrayList<StockDataItem> HistoricalData;
	
	public void FetchHistoricalData()
	{
		try 
		{
			DataAccess reader=new DataAccess();
			this.HistoricalData= reader.GetDataFromCSV(csvFile);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<StockDataItem> GetDataByRange(String StartDate, String EndDate)
	{
		ArrayList<StockDataItem> filteredData=new ArrayList<StockDataItem>();
		
		try 
		{
			if(this.HistoricalData == null)
			{
				FetchHistoricalData();
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fromDate = df.parse(StartDate);
			Date toDate = df.parse(EndDate);

			
			if(this.HistoricalData != null)
			{
				for (StockDataItem item : this.HistoricalData) {
					
					if(!fromDate.after(item.Date) && !toDate.before(item.Date))
					{
						filteredData.add(item);
					}
					
				}
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}

		return filteredData;
	}
	
	public static ArrayList<StockDataItem> FilterDataByRange(String StartDate, String EndDate, ArrayList<StockDataItem> inputData)
	{
		ArrayList<StockDataItem> filteredData=new ArrayList<StockDataItem>();
		
		try 
		{
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fromDate = df.parse(StartDate);
			Date toDate = df.parse(EndDate);

			
			if(inputData != null)
			{
				for (StockDataItem item : inputData) {
					
					if(!fromDate.after(item.Date) && !toDate.before(item.Date))
					{
						filteredData.add(item);
					}
					
				}
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}

		return filteredData;
	}
	
	
}
