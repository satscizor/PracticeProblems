package string;

public class RobotMovement {
public static void main(String[] args) {
	String move="UDLRUUDLRULLDRUDD";
	//String move="LRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUD";
	int countx=0;
	int county=0;
	for(int i=0;i<move.length();i++) {
		switch(move.charAt(i)) {
		case 'U':county++;break;
		case 'D': county--;break;
		case 'L': countx--;break;
		case 'R': countx++;break;
		}
	}
	System.out.println("The final coordinate of the robot from (0,0) is :["+countx+","+county+"]");
	
}
}
