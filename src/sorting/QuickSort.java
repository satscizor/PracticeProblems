package sorting;

import java.util.Scanner;

public class QuickSort {
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
		quicksort(arr,0,arr.length-1);
	}

	private static void quicksort(int[] arr, int left, int right) {
		//Recursion exit
		   if(left>=right) {
			   return;
			}
			int pivot=arr[(left+right)/2];
			int index=partition(arr,left,right,pivot);
			quicksort(arr, left, index-1);
			quicksort(arr, index, right);
	};
	
	private static int partition(int[] arr, int left, int right, int pivot) {
		 while(left<=right) {	
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			if(left<=right) {
				swap(arr,left,right);
				left++;
				right--;
			}
			
		}
		return left;
	}
	
	private static void swap(int arr[],int left, int right) {
		int temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
		
	}
}
