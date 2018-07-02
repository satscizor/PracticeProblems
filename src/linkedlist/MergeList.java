package linkedlist;

public class MergeList {
	public static void main(String[] args) {
		ListNode head1=new ListNode(-10);
		head1.next=new ListNode(10);
		ListNode head2=null;
		/*head2.next=new ListNode(-2);
		head2.next.next=new ListNode(-9);*/
		//head2.next.next.next=new ListNode(1);
		printLinkedList(mergeTwoLists(head1, head2));
	}
    private static void printLinkedList(ListNode listNode) {
		while(listNode!=null) {
			System.out.print(listNode.val+"--->");
			listNode=listNode.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null)
			return null;
		if(l2==null&&l1!=null)
			return l1;
		if(l1==null&&l2!=null)
			return l2;
		if(l1.next==null&&l2.next==null) {
			if(l1.val>l2.val) {
				l2.next=l1;
				return l2;
			}
			else {
				l1.next=l2;
				return l1;
			}
		}
        ListNode main=l1;
        ListNode splice=l2;
        while(splice!=null){
        ListNode temp=splice;
        while(main.next!=null&&temp.val>main.next.val){
            main=main.next;
        }
        splice=splice.next;
        if(temp.val<main.val){
            temp.next=main;
            main=temp;
        }
        else{
            temp.next=main.next;    
            main.next=temp;
            }
        }
      return l1.val<=l2.val?l1:l2;  
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
