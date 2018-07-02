package linkedlist;

import java.util.Stack;

import linkedlist.util.Node;

class Palindrome {
    public boolean isPalindrome(Node head) {
        if(head==null||head.next==null||head.next.next==null)
            return false;
        else{
            Stack<Integer> st=new Stack<Integer>();
            Node fast=head;
            Node mid=head;
            while(fast!=null&&fast.next!=null){
                st.push((Integer) mid.data);
                fast=fast.next.next;
                mid=mid.next;
            }
            Node temp=mid.next;
            while(temp!=null){
                if(st.pop()!=temp.data)
                    return false;
                temp=temp.next;    
            }
        }
        return true;
    }
}