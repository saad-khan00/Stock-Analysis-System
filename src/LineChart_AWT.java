
import org.jfree.chart.ChartPanel;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class LineChart_AWT extends ApplicationFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LineChart_AWT( String applicationTitle , String chartTitle )
	 {
	      super(applicationTitle);
	      
	      ArrayList<StockDataItem> data= CSVReader.GetDataset();
	      
	      TimeSeries series = new TimeSeries("Closing",Day.class);
	      for (StockDataItem d : data) {
	    	  
	    	  series.add(new Day(d.GetDay(),d.GetMonth(),d.GetYear()),Double.parseDouble(d.Close));
		}

	      // Add the series to your data set
	      TimeSeriesCollection dataset = new TimeSeriesCollection();
	      dataset.addSeries(series);
	      
	      // Generate the graph
	      JFreeChart chart = ChartFactory.createTimeSeriesChart(
	    		  "Historical Data of Stock",
	    		  "Date",
	    		  "Closing",
	    		  dataset,
	    		  true,
	    		  true,
	    		  false);

	      
	      ChartPanel chartPanel = new ChartPanel( chart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	 }

//	 private DefaultCategoryDataset createDataset( )
//	 {
//	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
//	      ArrayList<StockDataItem> data= CSVReader.GetDataset();
//	      
//	      for (StockDataItem d : data) {
//			
//		      dataset.addValue( Double.parseDouble(d.Close) , "close" , d.Date );
//
//	    	  
//		}
//	      
////	      dataset.addValue( 15 , "schools" , "1970" );
////	      dataset.addValue( 30 , "schools" , "1980" );
////	      dataset.addValue( 60 , "schools" ,  "1990" );
////	      dataset.addValue( 120 , "schools" , "2000" );
////	      dataset.addValue( 240 , "schools" , "2010" );
////	      dataset.addValue( 300 , "schools" , "2014" );
//	      return dataset;
//	 }
//	   
	   
	 public static void main( String[ ] args ) 
	 {
	      LineChart_AWT chart = new LineChart_AWT(
	      "School Vs Years" ,
	      "Numer of Schools vs years");

	      chart.pack( );
	      RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible( true );
	 }
}
