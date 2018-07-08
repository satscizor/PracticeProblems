package arrays;
/*
 * Find second minimum in an array
 */
public class SecondMinimum {
	public static void main(String[] args) {
		int arr1[]=new int [] {5,2,3,4,-5,-1,-2};
		int arr2[]=new int [] {111,12,34,13,54,22,34,15,32,11,31};
		int arr3[]=new int [] {5,2,3,1,4};
		
		findSecondMin(arr3);
	}
	
	
	//Single traversal
	private static void findSecondMin(int[] arr2) {
		int min=Integer.MAX_VALUE;
		int smin=Integer.MAX_VALUE;
		for(int i=0;i<arr2.length;i++) {
			if(arr2[i]<min){
				smin=min;
				min=arr2[i];
				
			}
			else if(arr2[i]<smin) {
				smin=arr2[i];
			}
		}
		System.out.println("Second min is"+smin);
		System.out.println("min is"+min);
	}
}
