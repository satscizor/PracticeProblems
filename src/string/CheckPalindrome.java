package string;
//Basic checkPalindrome
public class CheckPalindrome {
public static void main(String[] args) {
	String p1="nurses run";
	String p2="madam";
	String p3="abcd";
	System.out.println(isPalindrome(p1));
	System.out.println(isPalindrome(p2));
	System.out.println(isPalindrome(p3));
}

private static boolean isPalindrome(String p) {
	p=p.trim().replaceAll(" ", "");
	int front=0;
	int back=p.length()-1;
	while(front<back) {
		if(p.charAt(front)!=p.charAt(back))
			return false;
		front++;
		back--;
	}
	return true;
}
}
