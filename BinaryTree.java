package trees;

class Node
{
	int data;
	Node left,right;
	
	public Node(int data)
	
	{
		this.data=data;
		left=right=null;
	}
}


public class BinaryTree {
	
	//root
	Node root;
	
	//left-root-right
	
	void inorder(Node node)
	{
		
		if(node!=null)
		{
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	void preorder(Node node)
	{
		
		if(node!=null)
		{
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
			
			
		}
	}
	
	void postorder(Node node)
	{
		
		if(node!=null)
		{		
			
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	
	public static void main(String[] args) {
	
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		System.out.println("IN-ORDER :");
		tree.inorder(tree.root);
		System.out.println("\nPRE-ORDER :");
		tree.preorder(tree.root);
		System.out.println("\nPOST-ORDER :");
		tree.postorder(tree.root);
		
		
	}

}
