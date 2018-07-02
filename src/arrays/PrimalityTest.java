package arrays;

public class PrimalityTest {
	public static void main(String[] args) {
	for(int i=0;i<1000;i++) {
		if(isPrime(i))
		System.out.println("Prime number is ----> "+i);
		}
	}
	
	private static boolean isPrime(int x) {
		if(x<=1)
			return false;
		if(x<=3)
			return true;
		if(x%2==0||x%3==0)
			return false;
		else {
			for(int i=5;i*i<=x;i+=6) {
				if(x%i==0||x%(i+2)==0)
					return false;
			}
		}
		return true;
	}
}
