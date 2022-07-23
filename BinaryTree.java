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
	
	//O(n),O(2n)
	public List<Integer> postorderIterative(Node root) {

		List<Integer> res = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Stack<Node> opstack = new Stack<>();

		if (root == null)
			return res;

		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			opstack.push(root);
			if (root.left != null)
				stack.push(root.left);
			if (root.right != null)
				stack.push(root.right);

		}
		while (!opstack.isEmpty()) {
			res.add(opstack.pop().data);
		}

		return res;
	}
	
	//O(n),O(n)
	
	 public int maxDepth(Node root) {
	        if(root==null)
	            return 0;
	        int l=maxDepth(root.left);
	        int r=maxDepth(root.right);
	        return 1+Math.max(l,r);
	    }
	 
	 //O(n),O(n)
	 public int diameterOfBinaryTree(Node root) {
	        //reference variable
	        int[] res=new int[1];
	        diameter(root,res);
	        return res[0];
	        
	        
	    }
	    public int diameter(Node root,int[] res)
	    {
	        if(root==null)
	            return 0;
	        int l=diameter(root.left,res);
	        int r=diameter(root.right,res);
	    //diameter of a
	    // tree is nothing but maximum value of
	    // (left_height + right_height + 1) for each node
	        res[0]=Math.max(res[0],l+r);
	        
	        return 1+Math.max(l,r); 
	       
	    }
	    
	    //O(n),O(n)
	    
	    public boolean hasPathSum(Node root, int targetSum) {
	        
	        if(root==null)
	            return false;
	        if(root.data==targetSum && (root.left==null && root.right==null))
	            return true;
	        
	        return hasPathSum(root.left,targetSum-root.data) || hasPathSum(root.right,targetSum-root.data);
	            
	        
	    }
	    
	    //O(n),O(n)
	    public List<List<Integer>> allPathSum(Node root, int targetSum) {
	        
	        List<List<Integer>> paths=new ArrayList() ;
	        helper(root,targetSum,new ArrayList<Integer>(),paths);
	        return paths;
	        
	        
	    }
	    
	    void helper(Node root,int targetSum,ArrayList<Integer> path , List<List<Integer>> paths){
	        
	        if(root==null)
	            return ;
	        
	        path.add(root.data);
	        if(root.data==targetSum && (root.left ==null && root.right==null)){
	           paths.add(path);
	           return ;
	        }
	        
	        helper(root.left,targetSum-root.data,new ArrayList<>(path) ,paths);
	        helper(root.right,targetSum-root.data,new ArrayList<>(path) ,paths);
	        
	    }
	    
	     ArrayList<String> allPaths(Node root) {
	    	 
	    	 ArrayList<String> paths=new ArrayList();
	    	 
	    	 pathsHelper(root,paths,new String());
	    	 
			return paths;
		}
	    
	     void pathsHelper(Node root, ArrayList<String> paths,String path) {
	    	 
	    	 if(root==null)
	    		 return;
	    	 
	    	 if(root.left==null && root.right==null)
	    		 path+=root.data;
	    	 else	    		 
	    		 path+=root.data+"->";
	    	 
	    	 if(root.left==null && root.right==null) {
	    		 
	    		 paths.add(path);
	    	 }
	    	
	    	 pathsHelper(root.left,paths,new String(path));
	    	 pathsHelper(root.right,paths,new String(path));
		    
			
		}
	    
	    //O(n),O(n)
	     
		public Node invertTree(Node root) {

			if (root == null)
				return null;

			Node left = invertTree(root.left);
			Node right = invertTree(root.right);

			root.left = right;
			root.right = left;
			return root;

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
		
		System.out.println("\nPOST-ORDER ITERATIVE :");
		System.out.println(tree.postorderIterative(tree.root));
		
		System.out.println("\nHEIGHT/DEPTH :");
		System.out.println(tree.maxDepth(tree.root));
		
		System.out.println("\nDIAMETER :");
		System.out.println(tree.diameterOfBinaryTree(tree.root));
		
		
		System.out.println("\nhas path for given sum ?:");
		System.out.println(tree.hasPathSum(tree.root, 7));
		
		System.out.println("\nall path for given sum ?:");
		
		
		
		System.out.println(tree.allPathSum(tree.root,7));
		
		System.out.println("\nall paths from root to leaf:");
		
		
		System.out.println(tree.allPaths(tree.root));
		
		System.out.println("\nmirro of tree/invert tree:");
		
		tree.root=tree.invertTree(tree.root);
		
		tree.preorder(tree.root);
		
		
		
		
	}

	

}
