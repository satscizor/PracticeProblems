import java.util.Arrays;
import java.util.Scanner;

public class FindTheNextAnagramNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER:");
		int num=sc.nextInt();
		try {
			String str=String.valueOf(num);
			if(!checkRepdigit(str)) {
				String nextVal="";
				int d=-1;
				for(int i=str.length()-2;i>=0;i--) {
					if(Character.getNumericValue(str.charAt(i))<Character.getNumericValue(str.charAt(i+1))) {
						d=i;
						break;
					}
				}
				if(d==-1) {
					System.out.println("Not possible");
					return;
				}
				else {
					int diff=11;
					int s=-1;
				for(int i=d+1;i<=str.length()-1;i++) {
					if(str.charAt(i)>str.charAt(d)) {
						if(diff>Character.getNumericValue(str.charAt(i))-Character.getNumericValue(str.charAt(d))) {
							diff=Character.getNumericValue(str.charAt(i))-Character.getNumericValue(str.charAt(d));
							s=i;
						}
					}
					else
					  continue;
				    }
				str=swap(str,d,s);
				//sort
				char[] arr=str.substring(d+1).toCharArray();
				Arrays.sort(arr);
				for(char c:arr) {
					nextVal+=c;
				}
				if(d==0)
			    nextVal=str.charAt(d)+nextVal;
				else
				nextVal=str.substring(0, d+1)+nextVal;
			}
			System.out.println("The  number is "+nextVal);	
			
			}
		}
		catch(Exception e) {
			
		}
	}
	
	 private static String swap(String str, int i, int j)
	    {
	        StringBuilder sb = new StringBuilder(str);
	        sb.setCharAt(i, str.charAt(j));
	        sb.setCharAt(j, str.charAt(i));
	        return sb.toString();
	    }
	private static boolean checkRepdigit(String str){
		return false;
		
	}

}
