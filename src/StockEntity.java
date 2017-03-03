import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StockEntity {

	String csvFile = "G:\\MEng\\SW Design Methodologies\\Project\\Sampledatashort.csv";
	
	public String name;
    public String filePath="";
	public ArrayList<StockDataItem> HistoricalData;
	
	public void FetchHistoricalData()
	{
		try 
		{
			CSVReader reader=new CSVReader();
			this.HistoricalData= reader.GetDataset(csvFile);
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

			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
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
	
}
