package arrays;

/*
 * Count the sub-arrays having product less than k
 * https://www.geeksforgeeks.org/number-subarrays-product-less-k/
 */
public class ContiguosSubarrayCountProduct {
	public static void main(String[] args) {
	int arr1[]=new int[] {75,222};
	int k1=18;
	int arr2[]=new int[] {1,2,3,4};
	int k2=10;
	int arr3[]=new int[] {1, 9, 2, 8, 6, 4, 3};
	int k3=100;
	System.out.println(findSubArr(arr1, k1));
	System.out.println(findSubArr(arr2, k2));
	System.out.println(findSubArr(arr3, k3));
	}
	
//Sliding window 
private static int findSubArr(int [] arr,int k){
    int counter=0;
    int start=0;int end=0;
    int prod=1;
    for(int i=start;(i<=end&&end<arr.length);i=end){
       prod*=arr[end];
       //Case 1. p*x < k
       if(prod<k){
           counter+=1+(end-start);
           end++;
       }
       
       else{
    	   //This is where the counter has not been incremented i.e there is nothing less thak k at this point
    	     if(counter<1) {
    	   		start++;
    	   		end++;
    	   		prod=1;
    	   	   }
    	    //Case 2. p*x >= k
    	   	 else {
    	   		 //shift the left border to right
    	   		   start++;
    	   		   //this is required to prevent the situation where start exceeds end
    	   		   if(start>end) {
    	   			   end++;
    	   		   }
    	   		   //re adjust the product after adjusting the left border i.e start pointer
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
