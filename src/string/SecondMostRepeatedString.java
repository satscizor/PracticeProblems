package string;

import java.util.*;
import java.lang.*;
import java.io.*;
class SecondMostRepeatedString
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int tests=sc.nextInt();
	 while(tests>0){
	     int num=sc.nextInt();
	     sc.nextLine();
	     String str=sc.nextLine();
	     Map<String,Integer>stringcount=new HashMap<String,Integer>();
	     StringTokenizer stk=new StringTokenizer(str," ");
	     while(stk.hasMoreTokens()){
	         String s=stk.nextToken();
	         if(stringcount.get(s)!=null)
	         	stringcount.put(s,stringcount.get(s)+1);
	         else
	            stringcount.put(s,1);
	     }
	     Set<String> s=stringcount.keySet();
	     int maxCount=Integer.MIN_VALUE;
	     int secmaxCount=Integer.MIN_VALUE;
	     String maxStr="";
	     String secmaxStr="";
	     for(String setstr:s){
	         if(stringcount.get(setstr)>maxCount){
	            secmaxStr=maxStr; 
	            maxStr=setstr;
	            secmaxCount=maxCount; 
	            maxCount=stringcount.get(setstr); 
	         }
	         else if(stringcount.get(setstr)<maxCount&&stringcount.get(setstr)>=secmaxCount){
	           secmaxStr=setstr; 
	           secmaxCount=stringcount.get(setstr);  
	         }
	     }
	     System.out.println(secmaxStr);
	     tests--;
	 }
	 }
}
