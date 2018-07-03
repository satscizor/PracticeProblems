package arrays;
/*
 * Find the duplicates in an array which has numbers from 1....N
 * 
 */
public class FindDuplicatesInArray1ToN {
public static void main(String[] args) {
	int  arr[]=new int [] {4,5,6,3,2,1,8,9,10,12,11,3,12,7};
		for(int i=0;i<arr.length;i++) {
			if(arr[Math.abs(arr[i])]>=0) {
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			}	
			else {
				System.out.println("Reptition is  "+Math.abs(arr[Math.abs(arr[i])]));
			}
		}
 	}
}
