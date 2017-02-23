import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	
//	 public static void main(String[] args) {
	
	 public static ArrayList<StockDataItem> GetDataset(){	
	        String csvFile = "G:\\MEng\\SW Design Methodologies\\Project\\Sampledatashort.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        StockDataItem temp;
	        ArrayList<StockDataItem> Data= new ArrayList<StockDataItem>();
	        
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	            	String [] record= line.split(cvsSplitBy);
	            	if(!record[0].trim().equals("Date"))
	            	{
	            		temp=new StockDataItem(record[0].trim(), record[1].trim(), record[2].trim(), record[3].trim(), record[4].trim(), record[5].trim(), record[6].trim());
	            		Data.add(temp);
	            	}
	            	
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        return Data;

	    }
	

}
