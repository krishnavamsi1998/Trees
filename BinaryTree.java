package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	//O(N),O(N)
	void inorder(Node node)
	{
		
		if(node==null)
			return;
		
		
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		
	}
	
	//O(N),O(N)
	void preorder(Node node)
	{
		if(node==null)
			return;
		
		
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		
	}
	
	//O(N),O(N)
	void postorder(Node node)
	{
		
		if(node==null)
			return;	
			
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+" ");
		
	}
	
	//O(N),O(N)
	
	List<List<Integer>> levelorder(Node node) {
		// store level wise nodes

		List<List<Integer>> res = new ArrayList();

		if (node == null)
			return res;

		Queue<Node> q = new LinkedList<>();

		q.add(node);

		while (!q.isEmpty()) {
			int levels = q.size();
			List<Integer> list = new ArrayList();
			for (int i = 0; i < levels; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				list.add(q.poll().data);

			}
			res.add(list);
		}

		return res;

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
		System.out.println("\nLEVEL-ORDER :");
		
		System.out.println(tree.levelorder(tree.root));
		
		
	}

}
