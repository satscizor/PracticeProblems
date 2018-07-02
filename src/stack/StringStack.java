package stack;

public class StringStack {

	public static void main(String[] args) {
		System.out.println(super_reduced_string("baab"));
	}
    private static int top=-1;
    
// Complete the super_reduced_string function below.
static String super_reduced_string(String s) {
    char[] chararr=s.toCharArray();
    char [] stack= new char[s.length()];
    String formattedString="";
    if(s.length()==1)
    	return s;
    top=stackPush(stack,chararr[0]);
    for(int i=1;i<chararr.length;i++){
        if(top!=-1&&stack[top]==chararr[i])
        top=stackPop(stack);
        else    
        top=stackPush(stack,chararr[i]);
    }
    if(stack.length==0)
        return "Empty String";

    for(int i=0;i<=top;i++)
    {
        formattedString=formattedString+stack[i];
    }
    if(formattedString.trim().equals(""))
        return "Empty String";
    return formattedString.trim();
}

public static int stackPush(char [] stack,char c){
    if(top==stack.length-1)
    {
        System.out.println("Stack is full");}
    else
    {
        stack[++top]=c;
    }
    return top;
}
public static int stackPop(char [] stack){
     if(top==-1)
    {
         System.out.println("Stack is empty");
     }
    else
    {
        top--;
    } 
    return top;
}

}
