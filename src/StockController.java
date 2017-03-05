import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.JFreeChart;

public class StockController {
	
	ArrayList<StockDataItem> sSMADataset;
	ArrayList<StockDataItem> lSMADataset;
	
	
	public JFreeChart GetStockChartByDateRange(String FromDate, String ToDate)
	{
		StockEntity stock=new StockEntity();
		
		ArrayList<StockDataItem> data= stock.GetDataByRange(FromDate,ToDate);
		
		Map<String, ArrayList<StockDataItem>> dataset=new HashMap<String, ArrayList<StockDataItem>>();

		dataset.put("Absolute Data", data);
		
		JFreeChart chart= GraphGenerator.Draw(dataset);
		
		return chart;
		
	}
	
	public JFreeChart DisplayChartWithSMA(String FromDate, String ToDate, String shortWindow, String longWindow)
	{
		StockAnalyzer movingAverageFinder=new StockAnalyzer();
		StockEntity stock=new StockEntity();
		
		
		stock.FetchHistoricalData();
		
		
		sSMADataset = movingAverageFinder.CalculateSMA(Integer.parseInt(shortWindow), stock.HistoricalData);
		lSMADataset= movingAverageFinder.CalculateSMA(Integer.parseInt(longWindow), stock.HistoricalData);
		
		Map<String, ArrayList<StockDataItem>> dataset=new HashMap<String, ArrayList<StockDataItem>>();

		ArrayList<StockDataItem> absData= stock.GetDataByRange(FromDate,ToDate);

		sSMADataset= StockEntity.FilterDataByRange(FromDate, ToDate, sSMADataset);
		lSMADataset= StockEntity.FilterDataByRange(FromDate, ToDate, lSMADataset);
		
		dataset.put("Absolute Data", absData);
		dataset.put("SMA("+shortWindow+")", sSMADataset);
		dataset.put("SMA("+longWindow+")", lSMADataset);
		
		JFreeChart chart= GraphGenerator.Draw(dataset);
		
		return chart;
	}
	
	public String DecideBuyOrSell(ArrayList<StockDataItem> shortSMA, ArrayList<StockDataItem> longSMA)
	{
		
		StockAnalyzer decider=new StockAnalyzer();
		String result=decider.MakeDecision(shortSMA, longSMA);
		
		return result;
	}
	

}
