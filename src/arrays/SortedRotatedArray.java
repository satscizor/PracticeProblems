package arrays;

import java.util.Arrays;

public class SortedRotatedArray {
   public static void main(String[] args) {
	int  arr[]=new int [] {4,5,6,3,2,1,8,9,10,11,12,7};
	System.out.println("Initial array is :"+Arrays.toString(arr));
	quicksort(arr);
	System.out.println("Sorted array is :"+Arrays.toString(arr));
	rotateLeft(arr,3);
	System.out.println("Rotated array is :"+Arrays.toString(arr));
	int pivotIndex=findPivot(arr);
	System.out.println("The pivot and max element is :"+ arr[pivotIndex]);
	System.out.println("The smallest element is :"+ ((pivotIndex!=arr.length-1)?arr[pivotIndex+1]:arr[0]));
	int index=search(arr,5);
	System.out.println("Element 5 found ? :"+(index!=-1?(arr[index]==5):false));
	 index=search(arr,22);
	 System.out.println("Element 22 found ? :"+(index!=-1?(arr[index]==22):false));
	 index=search(arr,12);
	 System.out.println("Element 12 found ? :"+(index!=-1?(arr[index]==12):false));
   }

   private static int search(int[] arr, int key) {
	   int n=arr.length;
	   int pivot = findPivot(arr);	   
	   // If we didn't find a pivot, 
	   // then array is not rotated at all
	   if (pivot == -1)
	     return binarySearch(arr, 0, n-1, key);
	  
	   // If we found a pivot, then first compare with pivot
	   // and then search in two subarrays around pivot
	   if (arr[pivot] == key)
	     return pivot;
	      
	   if (arr[0] <= key)
	     return binarySearch(arr, 0, pivot-1, key);
	      
	     return binarySearch(arr, pivot+1, n-1, key);
     }

private static int binarySearch(int[] arr, int low, int high, int key) {
	if (high < low) return -1;
	if (high == low&&high != key) return -1;  
	int mid=low+(high-low)/2;
	if(arr[mid]==key)
		return mid;
	else if(key>arr[mid])
		return binarySearch(arr, mid+1, high, key);
	else if(key<arr[mid])
		return binarySearch(arr, low, mid-1, key);
	return -1;
}

private static int findPivot(int[] arr) {
	   return pv(arr,0,arr.length-1);
   }

   private static int pv(int[] arr, int low, int high) {
	// base case
	if (high < low) return -1;
	if (high == low) return low;  
	int mid=low+(high-low)/2;
	if(mid==0||mid==arr.length-1)
		return arr.length-1;
	/*If the mid element satisfies the property of the peak element (not lesser than its neighbors), then, it is the pivot.*/
	if(arr[mid]>=arr[mid-1]&&arr[mid]>=arr[mid+1])
		return mid;	
	/*If the mid element is greater than the last element, then the pivot should be in the second half of the array. */
	else if(arr[mid]>arr[high])
		return pv(arr, mid+1, high);
	/*If the mid element is less than the last element, then the pivot should be in the first half of the range.*/
	else if(arr[mid] < arr[high])
		return pv(arr, low, mid-1);
	return -1;	
}

private static void rotateLeft(int[] arr, int d) {      
       int n=arr.length;
       int gcd=GCD(d, n);
       int  k=gcd;
       for (int i = 0; i < gcd; i++) 
       {
    	   int temp=arr[i];
    	   for(int j=i+gcd;j<=n-k;j=j+gcd) {
    		arr[j-gcd]=arr[j];	 
    	   }
    	   arr[n-k]=temp;
    	   k--;
       }
   }
   private static void quicksort(int[] arr) {
	qs(arr,0,arr.length-1);
   }
   
   //recursive
   private static void qs(int [] arr,int left,int right) {
	 //exit condition
	   if(left>=right)
		   return;
	    int index=partition(arr, left, right, arr[(left+right)/2]);
	   	qs(arr, left, index-1);
	   	qs(arr, index, right);
     }
   
   //
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
	
	/*Iterative Function to get gcd of a and b*/
	public static int GCD(int a,int b) {
	        while(a != b)
	        {
	            if(a > b)
	                a -= b;
	            else
	                b -= a;
	        }
	        return a;
	    } 
	/*recursive Function to get gcd of a and b*/
    int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
