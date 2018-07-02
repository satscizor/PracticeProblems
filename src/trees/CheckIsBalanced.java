package trees;

import java.util.Arrays;
import java.util.List;

public class CheckIsBalanced {
	public static void main(String[] args) {
		List<Integer> nodelist1=Arrays.asList(3,9,20,null,null,15,7);
		List<Integer> nodelist2=Arrays.asList(1,2,2,3,3,null,null,4,4);
		Node<Integer> root1 = null;
		root1=createLevelBinaryTree(nodelist1, root1);
		BTPrinter.printNode(root1);
		System.out.println("Height of the tree 1 is "+findTreeHeight(root1));
		System.out.println("Tree 1 is balanced? "+(isBalanced(root1)!=-1));
		//
		System.out.println("=================================");
		Node<Integer> root2 = null;
		root2=createLevelBinaryTree(nodelist2, root2);
		BTPrinter.printNode(root2);
		System.out.println("Height of the tree 2 is "+findTreeHeight(root2));
		System.out.println("Tree 2 is balanced? "+(isBalanced(root2)!=-1));
	}

	private static Node<Integer> createLevelBinaryTree(List<Integer> nodelist,Node<Integer> root) {
			root=insertLevelOrder(nodelist, root, 0);
		return root;
	}
	public static Node<Integer> insertBinaryTree(Node<Integer> current,Integer next) {
		if(current==null)
		{
			//Reached root for 1st level [or] leaf node for other levels
			return next==null?null:new Node<Integer>(next);
		}
		if(next==null||next<=current.data){
			current.left=insertBinaryTree(current.left, next);
		}
		else if(next==null||next>=current.data){
			current.right=insertBinaryTree(current.right, next);
		}
		//Value already exists
		return current;
	}

	public static Node<Integer> insertLevelOrder(List<Integer> list, Node root,
              int position)
	{
		//Base case for recursion,Ignore if the value is null
		if (position< list.size()&&list.get(position)!=null) {
			Node<Integer> temp = new Node<Integer>(list.get(position));
			root = temp;
		// insert left child
		root.left = insertLevelOrder(list, root.left, 2 * position + 1);
		// insert right child
		root.right = insertLevelOrder(list, root.right,2 * position + 2);
		}
		return root;
	}
	
	public static int findTreeHeight(Node root) {
		if(root==null)
			return 0;
		int left=findTreeHeight(root.left);
		int right=findTreeHeight(root.right);
		return max(left,right)+1;
	}

	private static int max(int left, int right) {
		return left>right?left:right;
	}
	
	private static int isBalanced(Node root) {
		//Exit condition of recursion
		if(root==null)
			return 0;
		int left=isBalanced(root.left);
		if(left==-1) return -1;
		int right=isBalanced(root.right);
		if(right==-1) return -1;
		//a tree is not balanced if difference of the left child tree and right child tree height is greater than one
		if(Math.abs(left-right)>1) return -1;
		//Otherwise return the level
		return max(left,right)+1;
	}
	
}
