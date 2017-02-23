import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDemo 
{
	public static void main(String arg[])
	{
	   try
	   {
		   Login frame=new Login();
		   frame.setSize(700,500);
		   frame.setVisible(true);
	   }
	   catch(Exception e)
	   {
		   JOptionPane.showMessageDialog(null, e.getMessage());}
	   }
}
