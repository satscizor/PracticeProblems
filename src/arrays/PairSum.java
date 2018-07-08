package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Number of pairs whose sum is equal to the given sum
 * 
 */
public class PairSum {
	
	public static void main(String[] args) {
		
		int arr[]=new int[] {4,5,3,6,9,0,1,1,8,2,7,1,2,3,4,5,6,7,8,9,0,1,23,4,4,5,56,7,8,9,0};
		int sum=9;
		int counter=0;
		long startime = System.nanoTime();
		counter = n2sol(arr, sum, counter);
		checkTime(startime);
		System.out.println("N2 sol :Number of pair whose sum is ["+sum+"] is : "+counter);	
		counter=0;
		startime = System.nanoTime();
		counter = nsol(arr, sum, counter);
		checkTime(startime);
		System.out.println("N sol :Number of pair whose sum is ["+sum+"] is : "+counter);
		
	}

	private static int n2sol(int[] arr, int sum, int counter) {
		//n2 solution
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum)
					counter++;
			}
		}
		return counter;
	}

	private static int nsol(int[] arr, int sum, int counter) {
		//n sol
		Map<Integer,Integer> freqMap=new HashMap<Integer,Integer>();
		  // Store counts of all elements in map
        for (int i=0; i<arr.length; i++){
             
            // initializing value to 0, if key not found
            if(!freqMap.containsKey(arr[i]))
            	freqMap.put(arr[i],0);
                 
            freqMap.put(arr[i], freqMap.get(arr[i])+1);
        }
		for(int i=0;i<arr.length;i++) {
			//Check if sum exists
			if(freqMap.get(sum-arr[i]) != null)
				counter+=freqMap.get(sum-arr[i]);
			//Reduce the counter if the same i value is picked
			if(sum-arr[i]== arr[i])
				counter--;
		}
		return counter/2;
	}
	
	
	public static void checkTime(long startime) {
		long time2 = System.nanoTime();
		long timeTaken = time2 - startime;  
		System.out.println("Time taken " + timeTaken + " ns");  
	}
}
