package sorting;

import java.util.Scanner;

public class BinarySearch {
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
	BinarySearch b=new BinarySearch();
	b.quickSort(arr);
	System.out.println();
	System.out.println("Enter the element to search :");
	int search=sc.nextInt();
	System.out.println("Element["+search+"] found? ["+b.binarySearch(search,arr,0,arr.length-1)+"]");
	while(search!=-1)
	{	
		System.out.println("Enter another number to search.Press -1 to exit");
		search=sc.nextInt();
		System.out.println("Element["+search+"] found? ["+b.binarySearch(search,arr,0,arr.length-1)+"]");
	}
	sc.close();
	}

	private void quickSort(int[] arr) {
		qs(arr,0,arr.length-1);
	
	}

	private void qs(int[] arr, int left, int right) {
		if(left>=right)	
			return;
		
		int pivot=arr[(left+right)/2];
		int index=partition(arr,left,right,pivot);
		qs(arr,left,index-1);
		qs(arr,index,right);
	}

	private  int partition(int[] arr, int left, int right, int pivot) {
		
		while(left<=right) {	
			//The while loops will fix the position of the element which is basically larger than pivot on left and smaller than pivot on right
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

private void swap(int[] arr, int left, int right) {
	int temp=arr[left];
	arr[left]=arr[right];
	arr[right]=temp;
	}

private boolean binarySearch(int search, int[] arr,int low,int high) {
		if(low>high)
			return false;
		int mid=low+((high-low)/2);
		if(arr[mid]==search) {
			return true;
		}
		else if(search<arr[mid])
			return binarySearch(search,arr,low,mid-1);
		else
			return binarySearch(search,arr,mid+1,high);
	    }
}
