package stack;

import java.io.*;

import java.util.*;



public class OperatorValidator {

	 static int top=-1;     
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    char [] stack=new char[s.length()];
   
        String status="NO";
        char[] chararr=s.toCharArray();
        for(int i=0;i<chararr.length;i++){
            if(chararr[i]=='{'||chararr[i]=='['||chararr[i]=='(') {
                status=push(stack,chararr[i]);         
            }
            else{
                //stack empty return NO
                if(top==-1)
                    return "NO";
                
                //take the top element
                switch(chararr[i]){
                        case '}': 
                        status=pop('{',stack);
                        break;
                        case ']': 
                        status=pop('[',stack);
                        break;
                        case ')': 
                        status=pop('(',stack);
                        break;
                }
                
            }
        }
        return "YES".equals(status)?((top==-1)?"YES":"NO"):"NO";
    }
    
    public static String push(char [] stack,char val){
        if(top==stack.length-1)
            return "NO";         
        else{
        	stack[++top]=val;
            return "YES";
        }
    }
     public static String pop(char val,char [] stack){{
            if(top==-1){
                return "NO";
        }
        else{
            if(stack[top]==val){
                top--;
                return "YES";
            }
            else
                return "NO";
            }
        }
    }

    public static void main(String[] args) throws IOException {

    	
    	String s="{{[[(())]]}}";
           System.out.println(isBalanced(s));
    }
}
