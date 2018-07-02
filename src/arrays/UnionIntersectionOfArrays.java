package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionIntersectionOfArrays {
public static void main(String[] args) {
	int arr1[]=new int[] {1,2,2,1};
	int arr2[]=new int[] {3,2};
	
	System.out.println("The union is :"+Arrays.toString(union(arr1,arr2)));
	System.out.println("The intersection is :"+Arrays.toString(intersection(arr1,arr2)));
}

private static int[] union(int[] arr1, int[] arr2) {
	Set<Integer> set=new HashSet<Integer>();
	for(int i=0;i<arr1.length;i++) {
		set.add(arr1[i]);
	}
	for(int i=0;i<arr2.length;i++) {
		set.add(arr2[i]);
	}
	return set.stream().mapToInt(i->i).toArray();
}

private static int[] intersection(int[] arr1, int[] arr2) {
	Set<Integer> set=new HashSet<Integer>();
	for(int i=0;i<arr1.length;i++) {
		set.add(arr1[i]);
	}
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<arr2.length;i++) {
		if(set.contains(arr2[i])) {
			list.add(arr2[i]);
		}
	}	
	return list.stream().mapToInt(i -> i).toArray();
	}
}
