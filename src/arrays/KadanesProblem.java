package arrays;

/*
 * Max sum of contiguos subarray
 * 
 */
public class KadanesProblem {
	
	public static void main(String[] args) {
		int[] data1 = {-2,1,-3,4,-1,2,1,-5,4};
		kadanesSolution(data1);
	}

	private static void kadanesSolution(int[] data) {
		int max_ending_here=data[0];
		int max_so_far=data[0];
		for(int i=1;i<data.length;i++) {	
			max_ending_here=Math.max(data[i],max_ending_here+data[i]);
			max_so_far=Math.max(max_so_far,max_ending_here);	
		}
		System.out.println("Max sum is ----> "+max_so_far);
	}
}
