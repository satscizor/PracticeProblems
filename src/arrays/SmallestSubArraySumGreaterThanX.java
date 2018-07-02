package arrays;

import java.util.Scanner;
/*
 * Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
 * 
 */
public class SmallestSubArraySumGreaterThanX {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int tests=sc.nextInt();
	 while(tests>0){
	     int n=sc.nextInt();
	     int x=sc.nextInt();
	     int arr[]=new int[n];
	     for(int i=0;i<n;i++){
	        arr[i]=sc.nextInt();
	     }
	     int start=0,end=0,sum=0,len=n+1,minlen=n+1;
	     for(int i=0;i<n;i++) {
	    	 sum+=arr[i];
	    	 if(sum>x) {
	    		 len=(end-start)+1;
	    		 while(sum>x) {
	    			 sum-=arr[start];
	    			 len=(end-start)+1;
	    			 start++;		 
	    		 }
	    		 if(len<minlen)
	    			 minlen=len; 
	    	 }
	    	 end++;
	     }
	     System.out.println(minlen);
	     tests--;
	    }
	 sc.close();
	 }
}
