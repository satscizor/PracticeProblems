package random;

import java.util.HashSet;
import java.util.Set;

public class FindNonRepeatingArrayElement {

	public static void main(String[] args) {		
		int [] array=new int[]{1,2,3,4,5,6,7,8,1,2,3,4,6,7,8};
		long startime = System.nanoTime();
		int a=findSingleBySet(array);
		checkTime(startime);
		 startime = System.nanoTime();
		 int b=findSingleByXor(array);
		checkTime(startime);
		System.out.println(a);
		System.out.println(b);
	}
	public static int findSingleBySet(int[] array) {
	    Set<Integer> set = new HashSet<Integer>();
	    for (int item : array) {
	        if (!set.remove(item)) {
	            set.add(item);
	        }
	    }       
	    assert set.size() == 1;
	    return set.iterator().next();
	}
	public static int findSingleByXor(int[] array) {
int xor=0;
for(int i=0;i<array.length;i++) {
	 xor=xor^array[i];
}
return xor;
	}
	public static void checkTime(long startime) {
		long time2 = System.nanoTime();
		long timeTaken = time2 - startime;  
		System.out.println("Time taken " + timeTaken + " ns");  
	}
	
}
