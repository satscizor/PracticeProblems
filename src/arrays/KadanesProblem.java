package arrays;

public class KadanesProblem {
	
	public static void main(String[] args) {
		int[] data = {-2,1,-3,4,-1,2,1,-5,4};
		
		int[] data2 = {4, 2, -3, 1, 6};
		kadanesSolution(data);
		//findSUmIs0(data2);
	}

	private static void kadanesSolution(int[] data) {
		int max_ending_here=data[0];
		int max_so_far=data[0];
		for(int i=1;i<data.length;i++) {	
			max_ending_here=max(data[i],max_ending_here+data[i]);
			max_so_far=max(max_so_far,max_ending_here);	
			System.out.println("------ITERATION-----> "+i);
			System.out.println("------ELEMENT -----> "+data[i]);
			System.out.println("------MAX ENDING HERE -----> "+max_ending_here);
			System.out.println("------MAX SO FAR-----> "+max_so_far);		
			System.out.println("***************************************************");
		}
		System.out.println("ANSWER is ----> "+max_so_far);
	}
	private static void findSUmIs0(int[] data) {
		int max_ending_here=data[0];
		for(int i=1;i<data.length;i++) {	
			max_ending_here=max(data[i],max_ending_here+data[i]);
			System.out.println("------ITERATION-----> "+i);
			System.out.println("------ELEMENT -----> "+data[i]);
			System.out.println("------MAX ENDING HERE -----> "+max_ending_here);	
			System.out.println("***************************************************");
			if(max_ending_here==0)
			{
				System.out.println("Contains subarray with sum 0");
				return;
			}
		}
		System.out.println("Doesnt Contain subarray with sum 0");
	}
	
	public static int max(int p1,int p2) {
		if(p1==p2)
			return p1;
		else
			return (p1>p2)?p1:p2;
	}

}
