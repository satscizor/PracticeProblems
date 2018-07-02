package trees;

public class SimpleTraversal {

      TreeNode root;
	public static void main(String[] args) {
		SimpleTraversal sp=new SimpleTraversal();
		/*for(int i=1;i<8;i++) {
				sp.add(i);
			}	*/
		 sp.add(6);
		 sp.add(4);
		 sp.add(8);
		 sp.add(3);
		 sp.add(5);
		 sp.add(7);
		 sp.add(9);
		 System.out.println("The tree is :");
		 System.out.println("PREORDER:");
	     sp.prOrder(sp.getRoot());
	     System.out.println("INORDER:");
	     sp.inOrder(sp.getRoot());
	     System.out.println("POSTORDER:");
	     sp.postOrder(sp.getRoot());
		}
	
	
	public TreeNode getRoot() {
		return root;
	}

	//DLR
	public void prOrder(TreeNode node) {
		if(node==null)
			return;
		else {
				    System.out.println(node.getData());
					prOrder(node.getLeftNode());
					prOrder(node.getRightNode());						
		}
	}
	
	//LDR
	public void inOrder(TreeNode node) {
		if(node==null)
			return;
		else {
					prOrder(node.getLeftNode());
				    System.out.println(node.getData());
					prOrder(node.getRightNode());						
		}
	}
	//LRD
	public void postOrder(TreeNode node) {
		if(node==null)
			return;
		else {
					prOrder(node.getLeftNode());
					prOrder(node.getRightNode());
					System.out.println(node.getData());
		}
	}
	//BFS
	public void levelOrder(TreeNode node) {
		
	}
	
	
	public void add(int value) {
	    root = insertNode(root, value);
	}
	
	public TreeNode insertNode(TreeNode current,int value) {
		if(current==null)
		{
			//Reached root for 1st level [or] leaf node for other levels
			return new TreeNode(value);
		}
		if(value<current.getData()){
			current.setLeftNode(insertNode(current.getLeftNode(), value));
		}
		else if(value>current.getData()){
			current.setRightNode(insertNode(current.getRightNode(), value));
		}
		return current;
	}
}
