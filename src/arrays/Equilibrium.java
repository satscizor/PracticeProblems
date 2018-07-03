package arrays;
/*
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 * Given an array find the equilibrium
 * 
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Equilibrium {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test>0)
		{
		    int equilibrium=-1;
		    int size=sc.nextInt();
		    if(size==1){
		    	sc.nextInt();
		        System.out.println(0);
		    }
		    else{
		        int arr[]=new int[size];
		        // Get the total sum of the array as sum
		        int arrsum=0;
		        for(int i=0;i<size;i++){
		        	int val=sc.nextInt();
		        	arrsum+=val;
		            arr[i]=val;
		        }
		        System.out.println("The array entered is :"+Arrays.toString(arr));	
		        System.out.println("The array sum is :"+arrsum);
		        int leftsum=0;
		        for(int i=0;i<size;i++) {
		        	//Update sum to get the right sum.
		        	arrsum = arrsum - arr[i];
		        	//If leftsum is equal to sum, then return current index.
		        	if(leftsum==arrsum)
		        	{
		        		equilibrium=i;
		        		break;
		        	}
		        	leftsum = leftsum + arr[i]; // update leftsum for next iteration.
		        }
		        System.out.println("The equilibrium point is "+equilibrium);
		    }
		}
		sc.close();
	}
}
