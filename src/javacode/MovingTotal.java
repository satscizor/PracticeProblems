package javacode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovingTotal {
	
	List<Integer> mainlist=new ArrayList<Integer>(); 
	Set<Integer> cache=new HashSet<Integer>(); 
	
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
        if(list.length>0) {
        	for(int i=0;i<list.length;i++) {
        		mainlist.add(list[i]);
        	}
        }
   
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        if(mainlist.size()<3)
        	return false;
        else if(cache.contains(total))
        	return true;
        else {
        	for(int i=2;i<mainlist.size();i++) {
        		int num=mainlist.get(i)+mainlist.get(i-1)+mainlist.get(i-2);
        		if(!cache.contains(num))
        			cache.add(num);
        		if(num==total) {
        			return true;
        		}
        	}
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}