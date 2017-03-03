
import org.jfree.chart.ChartPanel;

import java.util.ArrayList;
import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GraphGenerator{
	
	public static JFreeChart Draw(ArrayList<StockDataItem> data)
	{
	      
	      TimeSeries series = new TimeSeries("Closing",Day.class);
	      Calendar cal = Calendar.getInstance();
	      
	      for (StockDataItem d : data) 
	      {
	    	  cal.setTime(d.Date);
	  	      series.add(new Day(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR)),Double.parseDouble(d.Close));
	      }

	      // Add the series to your data set
	      TimeSeriesCollection dataset = new TimeSeriesCollection();
	      dataset.addSeries(series);
	      
	      // Generate the graph
	      JFreeChart chart = ChartFactory.createTimeSeriesChart(
	    		  "Stock Record",
	    		  "Date",
	    		  "Closing",
	    		  dataset,
	    		  true,
	    		  true,
	    		  false);

	      
	      return chart;
	 }
	 
}
