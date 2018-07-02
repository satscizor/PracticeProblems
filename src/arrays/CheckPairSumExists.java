package arrays;

import java.util.Arrays;

/*
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 */
public class CheckPairSumExists {
public static void main(String[] args) {
	int [] array=new int[]{112,112,44,22,42,121,4242,123132,432342,31212,43443,121121,43432,21,113,441,903,1231,131,3443};
	int sum=244253;
	Arrays.sort(array);
	int low=0;
	int high =array.length-1;
	while (low<high) {
		if(array[low]+array[high]==sum) {
			System.out.println("Found : "+array[low]+" and "+array[high]);
			break;
		}
		else if(array[low]+array[high]<sum)
			low++;
		else
			high--;
	}
}
}
