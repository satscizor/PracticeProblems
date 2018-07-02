package string;

import java.util.Arrays;

public class Anagram {
	    public boolean isAnagram(String s, String t) {
	        char[] str1=s.toCharArray();
	        char[] str2=t.toCharArray();
	        if (str1.length != str2.length)
	        return false;
	        int NO_OF_CHARS=256;
	        int count1[] = new int [NO_OF_CHARS];
	        Arrays.fill(count1, 0);
	        int count2[] = new int [NO_OF_CHARS];
	        Arrays.fill(count2, 0);
	        for (int i = 0; i <str1.length && i < str2.length ;
	                                                 i++)
	        {
	            count1[str1[i]]++;
	            count2[str2[i]]++;
	        }

	        for (int i = 0; i < NO_OF_CHARS; i++)
	            if (count1[i] != count2[i])
	                return false;
	  
	        return true;
	    }

}
