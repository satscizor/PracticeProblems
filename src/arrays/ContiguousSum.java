package arrays;

/*package whatever //do not write package name here */

import java.util.*;

class ContiguousSum {
	public static void main (String[] args) {
		//code
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of tests: ");
		int test=sc.nextInt();
		while(test>0){
			System.out.println();
			System.out.println("*****************************");
		    int num=sc.nextInt();
		    System.out.println("num is ====>"+num);
		    int sum=sc.nextInt();
		    System.out.println("sum is ====>"+sum);
		    int [] arr=new int [num];
		    int start=0;
		    int end=0;
		    for(int i=0;i<num;i++) {
		        arr[i]=sc.nextInt();
		    }
		    mainloop:for(int i=0;i<num;i++){
		        int tempsum=0;
		        printArr(arr);
		        for(int j=i;j>=0;j--){
		            tempsum+=arr[j];
		            System.out.println("TEMPSUM is ------>"+tempsum);
		            if(tempsum==sum){
		            System.out.println("Tempsum matches : ");		     
		            start=j+1;
		            end=i+1;
		            System.out.println("Start-->"+start);
		            System.out.println("End-->"+end);
		            break mainloop;
		            }
		        }
		    }
		    test--;
		    if(start==0&&end==0&&arr.length>1)
		    System.out.println("-1");
		    else
		    System.out.println(start+" "+end);
		}
	}
	
	public static void printArr(int arr[]) {
		System.out.println("ARRAY IS ----->");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"|");
		}
		System.out.println();
	}
}
