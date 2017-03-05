import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InvalidObjectException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


public class FirstClass extends JFrame{
	
	private JSplitPane splitPaneV;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField txtFromDate;
	private JTextField txtToDate;
	private JComboBox<String> cb1;
	private JComboBox<String> cb2;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker1;
	private JLabel recoLabel;
	private ArrayList<StockDataItem> sSMA;
	private ArrayList<StockDataItem> lSMA;
	private JButton button4;

	public FirstClass(){
	    setTitle( "Stock Analysis Application" );
	    setBackground( Color.gray );

	    JPanel topPanel = new JPanel();
	    topPanel.setLayout( new BorderLayout() );
	    getContentPane().add( topPanel );

	    // Create the panels
	    createPanel1();
	    //createPanel2();
	    createPanel3();

	    // Create a splitter pane
	    splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
	    topPanel.add( splitPaneV, BorderLayout.CENTER );
        splitPaneV.setLeftComponent( panel1 );
	    splitPaneV.setRightComponent( panel2 );
	}

	public void createPanel1(){
	    panel1 = new JPanel();
	    panel1.setLayout( new GridBagLayout() );
	    panel1.setMinimumSize( new Dimension( 100, 200 ) );//sets minimum size of upper split pane
	   
	    GridBagConstraints c=new GridBagConstraints();
	    c.weightx=1.;
	    c.fill=GridBagConstraints.HORIZONTAL;
	    
	    //Creating First label
	    JLabel label=new JLabel("Select stocks to display:");
	    label.setVisible(true);
	    c.gridx=0;
	    c.gridy=0;
	    c.insets=new Insets(10,10,10,10);
	    panel1.add(label,c);
	    
	    //add combobox for selecting given CSV file
	    String[] choices = { "GIVEN CSV FILE"};
	    final JComboBox<String> cb = new JComboBox<String>(choices);
	    c.gridx=1;
	    c.gridy=0;
	    cb.setVisible(true);
	    panel1.add(cb,c);
	    
	    //add first button
	    JButton button=new JButton("Display Graph");
	    button.addActionListener(action1);
	    button.setVisible(true);
	    c.gridx=2;
	    c.gridy=0;
	    panel1.add(button,c);
	    
	    //add second label
	    JLabel secondlabel=new JLabel("Select Date Range:");
	    secondlabel.setVisible(true);
	    c.gridx=0;
	    c.gridy=1;
	    panel1.add(secondlabel,c);
	    
	    //add second label
	    JLabel fromlabel=new JLabel("From");
	    fromlabel.setVisible(true);
	    c.gridx=1;
	    c.gridy=1;
	    panel1.add(fromlabel,c);
	    
	  //add first datepicker
		   
	    UtilDateModel model = new UtilDateModel();
	   
	    Properties p = new Properties();
	    p.put("text.today", "Today");
	    p.put("text.month", "Month");
	    p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    
	
	    c.gridx=2;
	    c.gridy=1;
	    
	   // c.weightx=2;
	    //c.weighty=2;
	    panel1.add(datePicker,c);
	   //String text= datePicker.getJFormattedTextField().getText();
	   /*if(text="2016-10-04" && "1962-01-02"){
		   System.out.println();
	   }*/
	    
	    //add third label
	    JLabel thirdlabel=new JLabel("To");
	    thirdlabel.setVisible(true);
	    c.gridx=3;
	    c.gridy=1;
	    panel1.add(thirdlabel,c);
	    
	  //add second datepicker
	    UtilDateModel model1 = new UtilDateModel();
		   
	    Properties p1 = new Properties();
	    p1.put("text.today", "Today");
	    p1.put("text.month", "Month");
	    p1.put("text.year", "Year");
	    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
	    datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
	    
	    
	    c.gridx=4;
	    c.gridy=1;
	    panel1.add( datePicker1 ,c);
	    
	    
	    //add second button
	    JButton button1=new JButton("Display Selected Interval");
	    button1.addActionListener(action2);
	    button1.setVisible(true);
	    c.gridx=5;
	    c.gridy=1;
	    panel1.add(button1,c);
	    
	    //add fourth label
	    JLabel fourthlabel=new JLabel("Select Moving Average:");
	    fourthlabel.setVisible(true);
	    c.gridx=0;
	    c.gridy=2;
	    panel1.add(fourthlabel,c);
	    
	    //add fifth label
	    JLabel fifthlabel=new JLabel("Short Term");
	    fifthlabel.setVisible(true);
	    c.gridx=1;
	    c.gridy=2;
	    panel1.add(fifthlabel,c);
	    
	    //add second combobox for selecting short term moving average
	    String[] shortMA = { "20","50"};
	    cb1 = new JComboBox<String>(shortMA);
	    c.gridx=2;
	    c.gridy=2;
	    cb.setVisible(true);
	    panel1.add(cb1,c);
	    
	  //add sixth label
	    JLabel sixthlabel=new JLabel("Long Term");
	    sixthlabel.setVisible(true);
	    c.gridx=3;
	    c.gridy=2;
	    panel1.add(sixthlabel,c);
	    
	  //add third combobox for selecting long term moving average
	    String[] longMA = { "100","200"};
	    cb2 = new JComboBox<String>(longMA);
	    c.gridx=4;
	    c.gridy=2;
	    cb.setVisible(true);
	    panel1.add(cb2,c);
	    
	    //add third button
	    JButton button3=new JButton("Display MA");
	    button3.addActionListener(action3);
	    button3.setVisible(true);
	    c.gridx=5;
	    c.gridy=2;
	    panel1.add(button3,c);
	    
	  //add fourth button
	    button4=new JButton("Take Suggestion");
	    button4.setVisible(true);
	    button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockAnalyzer decider=new StockAnalyzer();
				String result=decider.MakeDecision(sSMA, lSMA);
				recoLabel.setText(result);			
			}
		});
	    c.gridx=0;
	    c.gridy=3;
	    button4.setEnabled(false);
	    panel1.add(button4,c);
	    
	  //add recommendation label
	    recoLabel=new JLabel();
	    recoLabel.setVisible(true);
	    c.gridx=1;
	    c.gridy=3;
	   // recoLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	    recoLabel.setFont(new Font("Courier New", Font.ITALIC, 14));
	    recoLabel.setForeground(Color.BLUE);
	    panel1.add(recoLabel,c);
	   
	    
	}

	  public void createPanel3(){
		  
	    panel2 = new JPanel();
	    panel2.setLayout( new GridLayout() );
	    panel2.setPreferredSize( new Dimension( 400, 100 ) );
	    panel2.setMinimumSize( new Dimension( 100, 50 ) );

	   
	  }

	  ActionListener action1=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			StockEntity stock=new StockEntity();
			stock.FetchHistoricalData();
			Map<String, ArrayList<StockDataItem>> dataset=new HashMap<String, ArrayList<StockDataItem>>();

			dataset.put("Absolute Data", stock.HistoricalData);

			JFreeChart chart= GraphGenerator.Draw(dataset);
			
			ChartPanel cp= new ChartPanel(chart);	
			
			button4.setEnabled(false);
			recoLabel.setText("");
			panel2.removeAll();
			panel2.add(cp,BorderLayout.CENTER);
		    panel2.validate();
		}
	};
	
	ActionListener action2=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			boolean inputValid=true;
			StockEntity stock=new StockEntity();
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date fromDate;
			Date toDate;
			
			df.setLenient(false);

			panel2.removeAll();
			
			if(datePicker.getJFormattedTextField().getText().isEmpty() || datePicker1.getJFormattedTextField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Please provide From & To Dates.", "Invalid Date Format",
				        JOptionPane.ERROR_MESSAGE);
				inputValid=false;
			}
			else
			{
				try 
				{
					fromDate = df.parse(datePicker.getJFormattedTextField().getText());
					toDate = df.parse(datePicker1.getJFormattedTextField().getText());
					if(fromDate.compareTo(toDate)>0)
					{
						throw new InvalidObjectException("");
					}
				} 
				catch (ParseException e1) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select a valid date.", "Invalid Date Format",
					        JOptionPane.ERROR_MESSAGE);
					inputValid=false;
					
				}
				catch(InvalidObjectException e2)
				{
					JOptionPane.showMessageDialog(new JFrame(), "From Date cannot be greater than To Date.", "Invalid Dates",
					        JOptionPane.ERROR_MESSAGE);
					inputValid=false;
					
				}
			}
			
			if(inputValid)
			{
				ArrayList<StockDataItem> data= stock.GetDataByRange(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
				
				Map<String, ArrayList<StockDataItem>> dataset=new HashMap<String, ArrayList<StockDataItem>>();

				dataset.put("Absolute Data", data);
				
				JFreeChart chart= GraphGenerator.Draw(dataset);
				
				ChartPanel cp= new ChartPanel(chart);
	
				cp.setBackground(Color.red);
				
//				panel2.removeAll();
				panel2.add(cp,BorderLayout.CENTER);
			}
			
			button4.setEnabled(false);
			recoLabel.setText("");
		    panel2.validate();
			
		}
	};
	
	ActionListener action3=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			boolean inputValid=true;
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date fromDate;
			Date toDate;
			
			df.setLenient(false);

			panel2.removeAll();
			
			if(datePicker.getJFormattedTextField().getText().isEmpty() || datePicker1.getJFormattedTextField().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Please provide From & To Dates.", "Invalid Date Format",
				        JOptionPane.ERROR_MESSAGE);
				inputValid=false;
			}
			else
			{
				try 
				{
					fromDate = df.parse(datePicker.getJFormattedTextField().getText());
					toDate = df.parse(datePicker1.getJFormattedTextField().getText());
					if(fromDate.compareTo(toDate)>0)
					{
						throw new InvalidObjectException("");
					}
				} 
				catch (ParseException e1) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select a valid date.", "Invalid Date Format",
					        JOptionPane.ERROR_MESSAGE);
					inputValid=false;
					
				}
				catch(InvalidObjectException e2)
				{
					JOptionPane.showMessageDialog(new JFrame(), "From Date cannot be greater than To Date.", "Invalid Dates",
					        JOptionPane.ERROR_MESSAGE);
					inputValid=false;
					
				}
			}
			
			if(inputValid)
			{
				StockAnalyzer movingAverageFinder=new StockAnalyzer();
				StockEntity stock=new StockEntity();
				
				
				stock.FetchHistoricalData();
				
				String shortTermWindow= cb1.getSelectedItem().toString();
				String longTermWindow= cb2.getSelectedItem().toString();
				
				sSMA = movingAverageFinder.CalculateSMA(Integer.parseInt(shortTermWindow), stock.HistoricalData);
				lSMA = movingAverageFinder.CalculateSMA(Integer.parseInt(longTermWindow), stock.HistoricalData);
				
				Map<String, ArrayList<StockDataItem>> dataset=new HashMap<String, ArrayList<StockDataItem>>();
		
				ArrayList<StockDataItem> absData= stock.GetDataByRange(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
		
				sSMA= StockEntity.FilterDataByRange(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText(), sSMA);
				lSMA= StockEntity.FilterDataByRange(datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText(), lSMA);
				
				dataset.put("Absolute Data", absData);
				dataset.put("SMA("+shortTermWindow+")", sSMA);
				dataset.put("SMA("+longTermWindow+")", lSMA);
				
				JFreeChart chart= GraphGenerator.Draw(dataset);
				
				ChartPanel cp= new ChartPanel(chart);
		
				cp.setBackground(Color.red);
				
				button4.setEnabled(true);
				recoLabel.setText("");
				panel2.add(cp,BorderLayout.CENTER);
			    panel2.validate();
			}
		}
	};
	  	
	  
	  
	public static void main( String args[] ){
	    try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	    // Create an instance of the test application
	    FirstClass mainFrame = new FirstClass();
	    mainFrame.pack();
	    mainFrame.setLocationRelativeTo(null);
	    mainFrame.setVisible( true );
	    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
