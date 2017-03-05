import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


public class StockAnalyzer {
	
	private Queue<StockDataItem> que;
	
	public ArrayList<StockDataItem> CalculateSMA(int windowSize, ArrayList<StockDataItem> dataset)
	{
		Collections.sort(dataset, new Comparator<StockDataItem>() {

			@Override
			public int compare(StockDataItem obj1, StockDataItem obj2) {
				// TODO Auto-generated method stub
				return obj1.Date.compareTo(obj2.Date);
			}
		});
		
		que= new LinkedList<StockDataItem>();
		
		ArrayList<StockDataItem> movingAverages=new ArrayList<StockDataItem>();
		
		for(int i=0;i<windowSize;i++)
		{
			que.add(dataset.get(i));
		}
		int count =windowSize;

		double avg= CalculateAverage();
		
		movingAverages.add(new StockDataItem(dataset.get(count-1).Date,avg));
		
		while(count<dataset.size())
		{
			que.remove();
			que.add(dataset.get(count));
			avg=CalculateAverage();
			movingAverages.add(new StockDataItem(dataset.get(count).Date,avg));
			count++;		
		}
		
		return movingAverages;
		
	}
	
	private double CalculateAverage()
	{
		double sum=0;
		
		for (StockDataItem qItem : que) {
			
			sum+= qItem.Close;
		}
		
		return (sum/que.size());

	}
	
	public String MakeDecision(ArrayList<StockDataItem> shortTerm, ArrayList<StockDataItem> longTerm)
	{
		Comparator<StockDataItem> myComparator=new Comparator<StockDataItem>() {
			
			@Override
			public int compare(StockDataItem o1, StockDataItem o2) {
				// TODO Auto-generated method stub
				return o2.Date.compareTo(o1.Date);
			}
		};
		
		Collections.sort(shortTerm, myComparator);
		Collections.sort(longTerm, myComparator);

		String result="";
		
		if(longTerm.get(0).Close>shortTerm.get(0).Close)
		{
			result= "Buy";
		}
		else
			result="Sell";
		
		
		return result;
	}
}
