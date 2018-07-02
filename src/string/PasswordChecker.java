package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

	public static void main(String[] args) {
		System.out.println(minimumNumber(7, "AUzs-nV"));
	}
	
	 static int minimumNumber(int n, String password) {
	        int number=0;
	        // Return the minimum number of characters to make the password strong
	        Pattern p1 = Pattern.compile("[0-9]");
	        Pattern p2 = Pattern.compile("[a-z]");
	        Pattern p3 = Pattern.compile("[A-Z]");
	        Pattern p4 = Pattern.compile("[!@#$%^&*()--+]");
	        Matcher m = p1.matcher(password);
	        if(!m.find())
	           number++;
	         m = p2.matcher(password);
	        if(!m.find())
	           number++;
	         m = p3.matcher(password);
	        if(!m.find())
	           number++;
	         m = p4.matcher(password);
	        if(!m.find())
	           number++;
	        if(password.length()+number<6)
	            number+=6-(password.length()+number);
	        return number;
	    }
}
