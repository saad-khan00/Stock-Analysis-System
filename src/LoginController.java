import javax.swing.JFrame;

public class LoginController {

	
	public boolean Login(String Username, String Password)
	{
		if ((Username.equals("user1") || Username.equals("user2") || Username.equals("roseindia")) && (Password.equals("roseindia") || Password.equals("123456")))
		{
			return true;
		}
		
		return false;
	}
	
	
}
