package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ContiguosSubarrayCountProduct {
	public static void main(String[] args) {
	int arr[]=new int[] { 75, 222};
	int k=18;
	
	
/*	int arr[]=new int[] {1,2,3,4};
	int k=10;*/
	
	System.out.println(findSubArr(arr, k));
	}

	
/*	public static void main (String[] args)
	 {
	Scanner sc=new Scanner(System.in);
	int tests=sc.nextInt();
	while(tests>0){
	    int n=sc.nextInt();
	    int k=sc.nextInt();
	    System.out.println("k is "+k);
	    System.out.println("n is "+n);
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=sc.nextInt();
	    }
	    System.out.println("Array is :"+Arrays.toString(arr));
	    System.out.println(findSubArr(arr,k));
	    tests--;
	}
	sc.close();
	 }*/
	
//Sliding window 
private static int findSubArr(int [] arr,int k){
    int counter=0;
    int start=0;int end=0;
    int prod=1;
    for(int i=start;(i<=end&&end<arr.length);i=end){
       prod*=arr[end];
       if(prod<k){
           counter+=1+(end-start);
           end++;
       }
       else{
    	     if(counter<1) {
    	   		start++;
    	   		end++;
    	   		prod=1;
    	   	   }
    	   	   else {
    	   		   start++;
    	   		   if(start>end) {
    	   			   end++;
    	   		   }
    	   		   prod=1;
    	   		   for(int j=start;j<end;j++) {
    	   			   prod*=arr[j];
    	   		   }
    	   	   }
           }
       }
    return counter;
}
}
