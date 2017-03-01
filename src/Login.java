import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
	JButton SUBMIT;
	  JPanel panel;
	  JLabel label1,label2;
	  final JTextField  text1,text2;
	   Login()
	   {
	   label1 = new JLabel();
	   label1.setText("Username:");
	   text1 = new JTextField(35);
	 
	   label2 = new JLabel();
	   label2.setText("Password:");
	   text2 = new JPasswordField(35);
	  
	   SUBMIT=new JButton("SUBMIT");
	   
	   panel=new JPanel(new GridLayout(3,1));
	   panel.add(label1);
	   panel.add(text1);
	   panel.add(label2);
	   panel.add(text2);
	   panel.add(SUBMIT);
	   add(panel,BorderLayout.CENTER);
	   SUBMIT.addActionListener(this);
	   setTitle("LOGIN FORM");
	   }
	  public void actionPerformed(ActionEvent ae)
	   {
	   String value1=text1.getText();
	   String value2=text2.getText();
	   if (value1.equals("roseindia") && value2.equals("roseindia")) {
	   NextPage page=new NextPage();
	  // page.setSize(300,100);
	   page.pack();
	   page.setLocationRelativeTo(null);
	   
	   page.setVisible(true);
	   JLabel label = new JLabel("Welcome to Stock Analysis System");
	   page.getContentPane().add(label);
	   dispose();
	   }
	   else{
	   System.out.println("enter the valid username and password");
	   JOptionPane.showMessageDialog(this,"Incorrect login or password",
	   "Error",JOptionPane.ERROR_MESSAGE);
	   }
	 }
}
