package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
	
	//O(n),O(n)
	
	List<List<Integer>> reverseLevelOrder(Node node) {
		// store level wise nodes

		List<List<Integer>> res = new ArrayList();
		Stack<List<Integer>> stack=new Stack();
		

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
			stack.add(list);
			
		}
		
		while(!stack.isEmpty())
		{
			res.add(stack.pop());
		}
		return res;

	}
	
	//O(n),O(n)
	
	List<Integer> preorderIterative(Node node) {
		List<Integer> res = new ArrayList();

		Stack<Node> stack = new Stack<>();

		// root null
		if (node == null)
			return res;

		stack.push(node);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			res.add(curr.data);
			// reverse : right , left bcoz its stack
			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);

		}

		return res;
	}
	
	//O(n,n)
	
	List<Integer> inorderIterative(Node node){
		List<Integer> res = new ArrayList();

		Stack<Node> stack = new Stack<>();

		// root null
		if (node == null)
			return res;
		Node curr=node;
		
		while(true)
		{
			if(curr!=null)
			{
				stack.push(curr);
				curr=curr.left;
				
			}
			//if left completed
			else {
				if(stack.isEmpty())
					break;
				//pop the root and push to res
				curr=stack.pop();
				res.add(curr.data);
				//goto right
				curr=curr.right;
			}
			
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
		
		System.out.println("\nREVERSE LEVEL-ORDER :");
		
		System.out.println(tree.reverseLevelOrder(tree.root));
		
		System.out.println("\nPRE-ORDER ITERATIVE :");
		System.out.println(tree.preorderIterative(tree.root));
		
		System.out.println("\nIN-ORDER ITERATIVE :");
		System.out.println(tree.inorderIterative(tree.root));
		
		
	}

}
