package arrays;


/*
 * Given an unsorted array of n integers which can contain integers from 1 to n. 
 * Some elements can be repeated multiple times and some other elements can be absent from the array. 
 * Count frequency of all elements that are present and print the missing elements.
 */
public class DigitFrequency1toN {
public static void main(String[] args) {
	
	
	int arr []=new int[] {2,3,3,2,5,7,7};
	int n=arr.length;
	 // Subtract 1 from every element so that the elements
    // become in range from 0 to n-1
	for(int i=0;i<n;i++) {
		arr[i]=arr[i]-1;
	}
	 // Use every element arr[i] as index and add 'n' to
    // element present at arr[i]%n to keep track of count of
    // occurrences of arr[i]
	for(int i=0;i<n;i++) {
		int index=arr[i]%n;
		//add the number to its appropriate bucket
		arr[index]+=n;
		//System.out.println("State of array in iteration ["+(i+1)+"] is : "+Arrays.toString(arr));
	}
	   // To print counts, simply print the number of times n
    // was added at index corresponding to every element
	for(int i=0;i<n;i++) {
		if(arr[i]>=n)
		System.out.println("The count of ["+(i+1)+"] is :"+(arr[i]/n));
	}

}
}
