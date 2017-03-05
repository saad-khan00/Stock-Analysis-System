
import org.jfree.chart.ChartPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GraphGenerator{
	
	public static JFreeChart Draw(Map<String, ArrayList<StockDataItem>> datasetCollection)
	{
	      
	      TimeSeries series;
	      Calendar cal = Calendar.getInstance();
	      TimeSeriesCollection SeriesCollection = new TimeSeriesCollection();
	      
	      for (String datasetName : datasetCollection.keySet()) 
	      {
			
	    	  series=new TimeSeries(datasetName);
		      for (StockDataItem d : datasetCollection.get(datasetName)) 
		      {
		    	  cal.setTime(d.Date);
		  	      series.add(new Day(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR)),d.Close);
		      }
		      SeriesCollection.addSeries(series);
	      }

	      // Generate the graph
	      JFreeChart chart = ChartFactory.createTimeSeriesChart(
	    		  "Stock Record",
	    		  "Date",
	    		  "Closing Value",
	    		  SeriesCollection,
	    		  true,
	    		  true,
	    		  false);
	      
	      chart.setBackgroundPaint(Color.white);
	      
	      return chart;
	 }
	 
}
