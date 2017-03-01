import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginDemo {
	public static void main(String arg[])
	   {
	   try
	   {
	   Login frame=new Login();
	   frame.setSize(300,100);
	   frame.pack();
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
	   }
	   catch(Exception e)
	   {JOptionPane.showMessageDialog(null, e.getMessage());}
	   }
}
