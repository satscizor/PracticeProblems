package arrays;

import java.util.Arrays;

/*
 * Two elements whose sum is closest to zero
 * 
 */
public class PairSumEqualZero {
	public static void main(String[] args) {
		int arr[] =new int[] {13,21,33,42,5,6,5,7,-20,-40};
		Arrays.sort(arr);
		int low=0;
		int high=arr.length-1;
		int minsum=Integer.MAX_VALUE;
		int minlow=Integer.MAX_VALUE;
		int minhigh=Integer.MAX_VALUE;
		while (low<high) {
			if(Math.abs(arr[low]+arr[high])<minsum) {
				minsum=Math.abs(arr[low]+arr[high]);
				minlow=arr[low];
				minhigh=arr[high];
			}
			if(arr[low]+arr[high]<0)
				low++;
			else if(arr[low]+arr[high]>0)
				high--;
			else
			{
				System.out.println("These add up to zero :"+arr[low]+" "+arr[high]);
				break;
			}
			
		}
		System.out.println("Min sum is "+minsum);
		System.out.println("Min sum numbers are : "+minhigh+" "+minlow);
	}
}
