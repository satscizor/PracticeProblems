package queues;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingStack {
        
        public static int top_s1=-1;
        public static int top_s2=-1;
    
    public static void main(String[] args) {    
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] s1=new int[n];
        int [] s2=new int[n];
        sc.nextLine();
        String commands;
        for(int i=0;i<n;i++){
            int value;
            commands=sc.nextLine();
            if(commands.contains(" ")){
                value=Integer.parseInt(commands.substring(2));
                pushS1(value,s1);
            }
            else if("2".equals(commands)){
                if(top_s1==-1)
                break;  
                //If stack s2 is not empty then pop from s2
                if(top_s2!=-1) 
                    popS2(s2);
                //If stack s2  empty then copy from s1 to s2 and pop from s2
                else{
                   stackCopy(s1,s2);
                   popS2(s2);
                    }                 
            }    
            else
            print(s1,s2,"F");    
        }
    }   
    public static void pushS1(int value,int [] s1){
       if(top_s1==s1.length-1)
          System.out.println("Stack is full!!!");
       else
         s1[++top_s1]=value;   
    }
    
    public static void pushS2(int value,int [] s2){
        if(top_s2==s2.length-1)
           System.out.println("Stack is full!!!");
        else
          s2[++top_s2]=value;   
     }
    public static int popS1(int [] stack){
    	int val=0;
       if(top_s1==-1){
          System.out.println("Stack is empty!!!");
       }
       else{
    	   val=stack[top_s1];
    	   top_s1--;
        }
        return val;
    }
    public static int popS2(int [] stack){
    	int val=0;
       if(top_s2==-1){
          System.out.println("Stack is empty!!!");
       }
       else{
    	   val=stack[top_s2];
    	   top_s2--;
        }
        return val;
    }
    public static void stackCopy(int [] s1,int [] s2){

        while(top_s1!=-1){
        	int valuePopped=popS1(s1);
            pushS2(valuePopped,s2);
        }
    }
    public static void print(int [] s1,int [] s2,String type){
           if("F".equals(type)){
        	   if(top_s2!=-1)
        		System.out.println(s2[top_s2]);
        	   else if(top_s1!=-1)
        		 System.out.println(s1[0]);  
           }
           else if("R".equals(type)){
        	   if(top_s1!=-1)
           		System.out.println(s1[top_s1]);
           	   else
           		 System.out.println(s2[0]);  
           }
    }
}