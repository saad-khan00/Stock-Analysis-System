import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {
	
	  JButton SUBMIT;
	  JPanel panel,panel1;
	  JLabel label1,label2;
	  final JTextField  txtUserName,txtPassword;
	  LoginWindow()
	  {
		   label1 = new JLabel();
		   label1.setText("Username:");
		   txtUserName = new JTextField(35);
		 
		   label2 = new JLabel();
		   label2.setText("Password:");
		   txtPassword = new JPasswordField(35);
		  
		   SUBMIT=new JButton("SUBMIT");
		   
		   panel=new JPanel(new GridLayout(3,1));
		   panel.add(label1);
		   panel.add(txtUserName);
		   panel.add(label2);
		   panel.add(txtPassword);
		   panel.add(SUBMIT);
		   add(panel,BorderLayout.CENTER);
		   SUBMIT.addActionListener(this);
		   setTitle("Stock Analysis Software User Authenticator");
	  }
	   
	   
	   public void actionPerformed(ActionEvent ae)
	   {
	   String value1=txtUserName.getText();
	   String value2=txtPassword.getText();
	   if ((value1.equals("user1") || value1.equals("user2") || value1.equals("roseindia")) && (value2.equals("roseindia") || value2.equals("123456")))
	   {
		   MainWindow f=new MainWindow();
		   f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		   f.setUndecorated(false);
		   f.setVisible(true);
		   dispose();
	   }
	   else
	   {
		   System.out.println("enter the valid username and password");
		   JOptionPane.showMessageDialog(this,"Incorrect login or password",
		   "Error",JOptionPane.ERROR_MESSAGE);
	   }
	 }
	   
	   public static void main(String args[])
	   {
	   try
	   {
	   LoginWindow frame=new LoginWindow();
	   frame.setSize(300,100);
	   frame.pack();
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
	   }
	   catch(Exception e)
	   {JOptionPane.showMessageDialog(null, e.getMessage());}
	   }
}