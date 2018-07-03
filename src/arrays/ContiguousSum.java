package arrays;

/*
 * Find all subarrays in an array sum of which matches a given sum
 */

import java.util.*;

class ContiguousSum {
	public static void main (String[] args) {
			
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test>0){
		    int num=sc.nextInt();
		    int sum=sc.nextInt();
		    int [] arr=new int [num];

		    for(int i=0;i<num;i++) {
		        arr[i]=sc.nextInt();
		    }
	        System.out.println(Arrays.toString(arr));
	        //code O(n^2) solution 2 loops
		    NaiveSolution(num, sum, arr);
		    BetterSolution( arr,sum);
		    test--;

		}
		sc.close();
	}
	//O(n) solution
		private static void BetterSolution(int[] arr, int k) {
		    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		    List<Integer> initial = new ArrayList<Integer>();
		    initial.add(-1);
		    map.put(0, initial);
		    int preSum = 0;

		    // Loop across all elements of the array
		    for(int i=0; i< arr.length; i++) {
		        preSum += arr[i];
		        // If point where sum = (preSum - k) is present, it means that between that 
		        // point and this, the sum has to equal k
		        if(map.containsKey(preSum - k)) {   // Subarray found 
		            List<Integer> startIndices = map.get(preSum - k);
		            for(int start : startIndices) {
		                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
		            }
		        }

		        List<Integer> newStart = new ArrayList<Integer>();
		        if(map.containsKey(preSum)) { 
		            newStart = map.get(preSum);
		        }
		        newStart.add(i);
		        map.put(preSum, newStart);
		    }
		}
		
		
	

	private static void NaiveSolution(int num, int sum, int[] arr) {
	    int start=-1;
	    int end=-1;
		for(int i=0;i<num;i++){
		    int tempsum=0;
		    for(int j=i;j>=0;j--){
		        tempsum+=arr[j];
		        if(tempsum==sum){	     
		        start=j;
		        end=i;
		        System.out.println("Found sum between index ["+start+"] and ["+end+"]");
		        }
		    }
		}
		if(start==-1&&end==-1&&arr.length>1)
			System.out.println("-1");
	}
	
}
