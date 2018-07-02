package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharInArray {
public static void main(String[] args) {
	String str="leetcode";
	Map<Character,CharCount> countMap=new HashMap<Character,CharCount>(256);
	for(int i=0;i<str.length();i++) {
		if(countMap.containsKey(str.charAt(i))) {
			countMap.get(str.charAt(i)).count++;
		}
		else {
			countMap.put(str.charAt(i), new CharCount(1, i));
		}
	}
	Set <Character> set=countMap.keySet();
	int index=str.length();
	for(Character chars:set) {
		if(countMap.get(chars).count==1&&countMap.get(chars).firstIndex<index) {
			index=countMap.get(chars).firstIndex;
		}
	}
	System.out.println("First non repeated char is : " +str.charAt(index));
}
}

class CharCount{
int count;
int firstIndex;
CharCount(int count,int firstIndex){
	this.count=count;
	this.firstIndex=firstIndex;
}
}
