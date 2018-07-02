package arrays;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number to find factorial:");
		int num=sc.nextInt();
		System.out.println("Number entered is "+num);
		System.out.println("Factorial is :"+factorialIter(num));
		sc.close();
	}
	
	private static int factorial(int n) {
		if(n==1|n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	
	private static int factorialIter(int n) {
		if(n==0||n==1)
			return 1;
		int factorial=1;
		for(int i=n;i>=1;i--)
			factorial*=(i);
		return factorial;
	}

}
