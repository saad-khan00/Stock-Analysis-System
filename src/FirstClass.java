import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.RefineryUtilities;

public class FirstClass extends JFrame{
	
	private JSplitPane splitPaneV;
	private JPanel panel1;
	private JPanel panel2;


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
	    
	    //add first textfield
	    JTextField textfield=new JTextField();
	    
	    textfield.setVisible(true);
	    //textfield.setMinimumSize(textfield.getPreferredSize());
	   // textfield.setMinimumSize(new Dimension( 70, 10 ));
	    c.gridx=2;
	    c.gridy=1;
	    
	   // c.weightx=2;
	    //c.weighty=2;
	    panel1.add(textfield,c);
	    
	    //add third label
	    JLabel thirdlabel=new JLabel("To");
	    thirdlabel.setVisible(true);
	    c.gridx=3;
	    c.gridy=1;
	    panel1.add(thirdlabel,c);
	    
	    //add first textfield
	    JTextField textfield1=new JTextField();
	    textfield1.setVisible(true);
	    //textfield.setSize(70,10);
	    c.gridx=4;
	    c.gridy=1;
	    panel1.add( textfield1,c);
	    
	    //add second button
	    JButton button1=new JButton("Display Graph");
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
	    final JComboBox<String> cb1 = new JComboBox<String>(shortMA);
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
	    final JComboBox<String> cb2 = new JComboBox<String>(longMA);
	    c.gridx=4;
	    c.gridy=2;
	    cb.setVisible(true);
	    panel1.add(cb2,c);
	    
	    //add third button
	    JButton button3=new JButton("Display MA");
	    button3.setVisible(true);
	    c.gridx=5;
	    c.gridy=2;
	    panel1.add(button3,c);
	    
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
			JFreeChart chart= GraphGenerator.Draw(stock.HistoricalData);
			
			ChartPanel cp= new ChartPanel(chart);	
			
			panel2.removeAll();
			panel2.add(cp,BorderLayout.CENTER);
		    panel2.validate();
		}
	};
	
	ActionListener action2=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			StockEntity stock=new StockEntity();
			ArrayList<StockDataItem> data= stock.GetDataByRange("9/18/2016", "10/4/2016");
			
			JFreeChart chart= GraphGenerator.Draw(data);
			
			ChartPanel cp= new ChartPanel(chart);

			panel2.removeAll();
			panel2.add(cp,BorderLayout.CENTER);
		    panel2.validate();
			
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
