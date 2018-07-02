package arrays;

import java.util.Arrays;


public class PythagoranTriplets {
public static void main(String[] args) {
	int arr[] =new int[] {3, 4, 5,8, 15, 17,45,11,55,34,6,48, 55, 73,12,13};
	/*
	 * Only finds where n=1
	 * 
	 */
	System.out.println("---------Imperfection---------");
	imperfectSolution(arr);
	/*
	 * Finds everything
	 * 
	 */
	System.out.println("---------Perfection---------");
	perfectSolution(arr);
}
private static void perfectSolution(int[] arr) {
	for(int i=0;i<arr.length;i++) {
		arr[i]=arr[i]*arr[i];
	}
	Arrays.sort(arr);
	int a=arr.length-1;
	while(a!=0) {
	int b=0,c=a-1;
	while(b<c) {
		if(arr[b]+arr[c]<arr[a])
			b++;
		else if(arr[b]+arr[c]>arr[a])
			c--;
		else {
			System.out.println("Found pythagoran triplet :"+(int)Math.sqrt(arr[b])+" "+(int)Math.sqrt(arr[c])+" "+(int)Math.sqrt(arr[a]));
			break;
			}
		}
	a--;
	}
}
private static void imperfectSolution(int[] arr) {
	for(int i=0;i<arr.length;i++) {
		int x=0,y=0,z=0;
		if(isPerfectSq(arr[i]-1)) {z=arr[i];}
		else if(isPerfectSq(arr[i]+1)) {y=arr[i];}
		else if(arr[i]%2==0) {x=arr[i];}
		if(x!=0) {
			//x is even
			//iterate through the loop checking for y and z
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]==(int)Math.pow((x/2), 2)-1){y=arr[j];}
				if(arr[j]==(int)Math.pow((x/2), 2)+1){z=arr[j];}
				if(y!=0&&z!=0)
					break;
			}
		}
		if(y!=0) {
			//y is found
			//iterate through the loop checking for x and z
			int m=(int) Math.sqrt(y+1);
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]==(int)Math.pow(m, 2)+1){z=arr[j];}
				if(arr[j]==2*m){x=arr[j];}
				if(x!=0&&z!=0)
					break;
			}
		}
		if(z!=0) {
			//z is found
			//iterate through the loop checking for y and x
			int m=(int) Math.sqrt(z-1);
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]==(int)Math.pow(m, 2)-1){y=arr[j];}
				if(arr[j]==2*m){x=arr[j];}
				if(x!=0&&y!=0)
					break;
			}
		}
		if(x!=0&&y!=0&&z!=0)
		{
			System.out.println("Found pythagoran triplet :"+x+" "+y+" "+z);
		}
	}
}
public static boolean isPerfectSq(int num) {
	int sqrt = (int) Math.sqrt(num);
	return (sqrt*sqrt == num);
}
}

