package sorting;

import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=sc.nextInt();
		System.out.println("The size entered is : "+size);
		int arr[]=new int [size];
		System.out.println("Enter the array elements one by one : ");
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("The array elements entered are : ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		sortElements(arr);
		System.out.println("The sorted array is : ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+ " ");
		}
		sc.close();
	}
	
	private static void sortElements(int arr []) {
		
	};
}
