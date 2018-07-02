package arrays;

/*package whatever //do not write package name here */

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
		        System.out.println(1);
		    }
		    else{
		        int sumLeft=0;
		        int arr[]=new int[size];
		        for(int i=0;i<size;i++){
		            arr[i]=sc.nextInt();
		        }
	
		        mainloop : for(int i=0;i<size;i++){     
		            int diff=sumLeft;
		            if(i==0) {
		            	sumLeft+=arr[i];	
		            	continue;
		            }
		            //from 2nd element
		            for(int j=i+1;j<size;j++)
		            {
		               diff-= arr[j];
		               if(diff<0) {
		                	break;
		               }
		               else if(diff==0){
		                   equilibrium=i+1;
		                   break mainloop;
		               }
		            }
		            sumLeft+=arr[i];
		        }
		        System.out.println(equilibrium);
		    }    
		    test--;
		}
		
	}
}
