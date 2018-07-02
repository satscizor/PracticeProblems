package arrays;

import java.util.Arrays;

public class RemoveDupes {
public static void main(String[] args) {
	//int arr[]=new int[] {0,0,1,1,1,2,2,3,3,4};
	//int arr[]=new int[] {1,1,2,2,3,5,7,7,7,8,8,8};
	int arr[]=new int[] {0,0,2,3,4,5,5,5,8,8,8,9,9,9,10};
	System.out.println(removeDuplicates(arr));
}

public static int removeDuplicates(int[] nums) {
    int i=0;
    for(int j=0; j< nums.length; j++) {
        if(nums[i] != nums[j]) {
            i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
    }
    System.out.println(Arrays.toString(nums));
    return i+1; 
}
}
