package trees;

public class TreeNode {

	private int data;
	private TreeNode rightNode;
	private TreeNode leftNode;
	
	
	
	
	
	public TreeNode(int data) {
		super();
		this.data = data;
		this.rightNode = null;
		this.leftNode = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	
}
