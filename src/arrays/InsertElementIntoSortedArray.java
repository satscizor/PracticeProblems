package arrays;

import java.util.Arrays;

public class InsertElementIntoSortedArray {
	
public static void main(String[] args) {
	int arr[]=new int[] {1,-3,4,-8,-5,4,55,74,23,6,10};
	Arrays.sort(arr);
	System.out.println("Sorted array is :"+Arrays.toString(arr));
	System.out.println("-----------------------------------");
	arr=insert(arr,-1);
	System.out.println("After first insert :"+Arrays.toString(arr));
	arr=insert(arr,45);
	System.out.println("After second insert :"+Arrays.toString(arr));
	arr=insert(arr,30);
	System.out.println("After third insert :"+Arrays.toString(arr));
	arr=insert(arr,0);
	System.out.println("After forth insert :"+Arrays.toString(arr));
}

	private static int[] insert(int arr[],int num) {
		int position=-1;
		if(arr[arr.length-1]<=num)
			position=arr.length;
		else if(arr[0]>=num)
			position=0;
		else
		position=findPosition(arr,num,0,arr.length-1);
		System.out.println("Position to enter the number ["+num+"] is :"+position);
		int dest[]=new int[arr.length+1];
		System.arraycopy(arr, 0, dest, 0, (position-0));
		dest[position]=num;
		System.arraycopy(arr, position, dest, position+1, arr.length-position);
		return dest;
	}

	private static int findPosition(int[] arr,int num,int low,int high) {
		int mid=low+((high-low)/2);
		if(arr[mid]>=num&&arr[mid-1]<=num)
			return mid;
		else if(arr[mid]<=num&&arr[mid+1]>=num)
			return mid+1;
		else if(arr[mid]<num)
			return findPosition(arr,num,mid+1,high);
		else
			return findPosition(arr,num,low,mid-1);
	}
}
