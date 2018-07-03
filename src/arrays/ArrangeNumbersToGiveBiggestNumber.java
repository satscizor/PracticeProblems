package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given an array of numbers. make the biggest number by rearranging those.  
 * 
 */
public class ArrangeNumbersToGiveBiggestNumber {
public static void main(String[] args) {
	int [] arr1=new int[] {1, 34, 3, 98, 9, 76, 45, 4};
	int [] arr2=new int[] {54, 546, 548, 60};
	System.out.println(printBiggestNumber(arr1));
	System.out.println(printBiggestNumber(arr2));
}

private static String printBiggestNumber(int[] arr) {
	Comparator<String> comp=new Comparator<String>() {
		@Override
		public int compare(String x, String y) {
			String xy=x+y;
			String yx=y+x;
			return xy.compareTo(yx) > 0 ? -1:1;
		}
	};
	
	List <String> strList=new ArrayList<String>();
	for(int i=0;i<arr.length;i++) {
		strList.add(String.valueOf(arr[i]));
	}
	Collections.sort(strList,comp);
	String num="";
	for(int i=0;i<strList.size();i++) {
		num+=strList.get(i);
	}
	return num;
}
}
