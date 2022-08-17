package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

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


class pair
{
	int value;
	int level;
	public pair(int value, int level) {
		
		this.value = value;
		this.level = level;
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
				
				Node curr=q.peek();
				
								
				if (q.peek().left != null)
					q.add(curr.left);
				if (q.peek().right != null)
					q.add(curr.right);
				
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
	
	 public int height(Node root) {
	        if(root==null)
	            return 0;
	        int l=height(root.left);
	        int r=height(root.right);
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
		
		//O(n),O(n) 
		public List<Integer> rightSideView(Node root) {

			List<Integer> list = new ArrayList();

			rightSideViewHelper(root, 0, list);

			return list;

		}

		void rightSideViewHelper(Node root, int level, List<Integer> list) {

			if (root == null)
				return;

			if (level == list.size())
				list.add(root.data);

			rightSideViewHelper(root.right, level + 1, list);
			rightSideViewHelper(root.left, level + 1, list);

		}
		
		//O(n),O(n)
		
		ArrayList<Integer> leftSideView(Node root) {

			ArrayList<Integer> list = new ArrayList();

			leftSideViewHelper(root, 0, list);

			return list;

		}

		void leftSideViewHelper(Node root, int level, ArrayList<Integer> list) {

			if (root == null)
				return;

			if (level == list.size())
				list.add(root.data);

			leftSideViewHelper(root.left, level + 1, list);
			leftSideViewHelper(root.right, level + 1, list);

		}
		
		//sum of all nodes
		//O(n),O(n)
		
		int sumBT(Node head) {
			Node root = head;
			if (root == null)
				return 0;

			return root.data + sumBT(root.left) + sumBT(root.right);
		}
		
		// O(nlogn),O(n)
		ArrayList<Integer> topView(Node root) {
			ArrayList<Integer> res = new ArrayList();
			Map<Integer, pair> map = new TreeMap();

			// initial : level -0, distance(from root) - 0
			topViewHelper(root, map, 0, 0);

			for (Map.Entry<Integer, pair> entry : map.entrySet()) {

				res.add(entry.getValue().value);

			}

			return res;
		}

		void topViewHelper(Node root, Map<Integer, pair> map, int dist, int level) {

			if (root == null)
				return;

			// for bottom levl : map.get(dist).level<=level

			if (map.get(dist) == null || map.get(dist).level > level) {

				map.put(dist, new pair(root.data, level));
			}

			topViewHelper(root.left, map, dist - 1, level + 1);
			topViewHelper(root.right, map, dist + 1, level + 1);

		}
		
		//O(n2),O(n)

		List<List<Integer>> zigzaglevel(Node node) {
			// store level wise nodes

			List<List<Integer>> res = new ArrayList();

			if (node == null)
				return res;

			Queue<Node> q = new LinkedList<>();

			q.add(node);
			int c = 0;
			while (!q.isEmpty()) {

				int levels = q.size();
				List<Integer> list = new ArrayList();

				for (int i = 0; i < levels; i++) {

					Node curr = q.peek();

					if (q.peek().left != null)
						q.add(curr.left);
					if (q.peek().right != null)
						q.add(curr.right);

					list.add(q.poll().data);

				}
				if (c == 0) {
					c = 1;
					res.add(list);
				} else {
					c = 0;
					Collections.reverse(list);
					res.add(list);
				}

			}

			return res;

		}
		
		//O(n),O(1)
		//refer tuf

		public void flattenToLinkedList(Node root) {

			Node curr = root;
			while (curr != null) {
				if (curr.left != null) {
					Node prev = curr.left;

					while (prev.right != null)
						prev = prev.right;

					prev.right = curr.right;
					curr.right = curr.left;
					curr.left = null;
				}

				curr = curr.right;
			}
			
			while(root!=null) {
				System.out.print(root.data+" ");
				root=root.right;
			}

		}
		
		//O(n),O(1)
		
		void morrisPreorder(Node root) {

			Node curr = root;

			while (curr != null) {
				if (curr.left == null) {
					System.out.print(curr.data + " ");
					curr = curr.right;
				} else {
					Node prev = curr.left;
					// traverse to last right node of left sub tree
					while (prev.right != null && prev.right != curr)
						prev = prev.right;

					// connect link to curr and go left
					if (prev.right == null) {
						prev.right = curr;
						System.out.print(curr.data + " ");
						curr = curr.left;
					}
					// cut the link and go right
					else {
						prev.right = null;
						curr = curr.right;
					}

				}

			}
		}
		
		// O(n2),O(n)
		// if height diff bw left subtree and right subtree is <=1 at every node
		// then its called balanced binary tree
		boolean isBalanced(Node root) {

			
			int lh, rh;

			if (root == null)
				return true; 
			lh = height(root.left);
			rh = height(root.right);

			if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
				return true;

			return false;
			 
			

		}
		
		static Node head=null;
		Node prev=null;
		
		//In order conversion 
		//O(n),O(1)/O(n)
		void toDLL(Node root) {
			if (root == null)
				return;

			toDLL(root.left);

			// here last left node
			if (prev == null)// means this is first node
				head = root;
			else {
				root.left = prev;
				prev.right = root;

			}
			prev = root;

			// now right
			toDLL(root.right);

		}

		void printDLL(Node head) {
			Node temp = head;
			Node prev = null;

			while (temp != null) {
				System.out.print(temp.data + "==");
				temp = temp.right;
				if (temp != null)
					prev = temp;
			}
			System.out.println();
			System.out.println("dll reverse order :");

			while (prev != null) {
				System.out.print(prev.data + "==");
				prev = prev.left;

			}

		}
		
		//O(n),O(n)
		
	     int sumOfLeftLeaves(Node root) {
	        
	        if(root==null)
	            return 0;
	        //check if its left leaf
	        
	        else if(root.left!=null && root.left.left==null && root.left.right==null)
	            return root.left.data+sumOfLeftLeaves(root.right);
	        
	        //check both sides
	        else
	            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
	        
	    }
	     
		boolean isLeafNode(Node node) {
			if (node == null)
				return false;

			if (node.left == null && node.right == null)
				return true;
			return false;

		}

		// O(n),O(1)
		// bottom up approach

		boolean isSumTree(Node root) {
			if (root == null || isLeafNode(root))
				return true;

			int ls;
			int rs;

			if (isSumTree(root.left) && isSumTree(root.right)) {
				// left is null but right is there
				if (root.left == null)
					ls = 0;
				else if (isLeafNode(root.left))
					ls = root.left.data;
				// non leaf logic
				else
					ls = 2 * root.left.data;

				// same for right

				if (root.right == null)
					rs = 0;
				else if (isLeafNode(root.right))
					rs = root.right.data;
				// non leaf logic
				else
					rs = 2 * root.right.data;

				if (ls + rs == root.data)
					return true;
				else
					return false;

			}
			return false;
		}
		
		// O(n2),O(n)

		boolean isSubtree(Node T, Node S) {
			// add code here.
			if (S == null)
				return true;

			if (T == null)
				return false;

			if (isIdentical(T, S))
				return true;
			// left or right
			return isSubtree(T.left, S) || isSubtree(T.right, S);

		}
	    
	    //O(n),O(n)
		//n is no of nodes in lesser nodes tree
		
		boolean isIdentical(Node a, Node b) {

			if (a == null && b == null)
				return true;

			if (a != null && b != null) {
				return a.data == b.data && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
			}

			return false;

		}
		
		// O(n),O(a+b) , a=recursion stack space of main tree, b= recursion stack space
		// of sub tree
		boolean subTreeOptimized(Node main, Node sub) {

			if (main == null)
				return false;
			if (sub == null)
				return true;

			List<Integer> mainInorderArray = new ArrayList<>();

			List<Integer> subInorderArray = new ArrayList<>();

			fillInOrderArray(main, mainInorderArray);

			fillInOrderArray(sub, subInorderArray);

			//System.out.println(mainInorderArray + " " + subInorderArray);

			// convert to string and check

			// System.out.println(arrayListToString(mainInorderArray));

			if (!(arrayListToString(mainInorderArray).contains(arrayListToString(subInorderArray))))
				return false;

			// in order is true, so
			// continue checking with preorder

			List<Integer> mainPreorderArray = new ArrayList<>();

			List<Integer> subPreorderArray = new ArrayList<>();

			fillPreOrderArray(main, mainPreorderArray);

			fillPreOrderArray(sub, subPreorderArray);

			//System.out.println(mainPreorderArray + " " + subPreorderArray);

			// final check
			return arrayListToString(mainPreorderArray).contains(arrayListToString(subPreorderArray));

		}

		void fillInOrderArray(Node a, List<Integer> arr) {

			if (a == null)
				return;
			fillInOrderArray(a.left, arr);

			arr.add(a.data);

			fillInOrderArray(a.right, arr);
		}

		void fillPreOrderArray(Node a, List<Integer> arr) {

			if (a == null)
				return;

			arr.add(a.data);

			fillPreOrderArray(a.left, arr);

			fillInOrderArray(a.right, arr);
		}

		// O(n),O(n)

		String arrayListToString(List<Integer> arr) {
			String s = "";

			for (int i = 0; i < arr.size(); i++)
				s += arr.get(i);

			return s;

		}
		
		//O(n),O(n)
		
		boolean areMirror(Node a, Node b) {

			if (a == null && b == null)
				return true;

			if (a != null && b != null)
				return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left);

			// either of it's null , so they are not mirror
			return false;

		}
		
		//O(n),O(n)
		// similar to mirror image except that we pass same root
		// check symmetric tree structure once
		
		public boolean isSymmetric(Node root) {
	        return symmetricHelper(root,root);
	        
	    }
	    
	    boolean symmetricHelper(Node a,Node b)
	    {
	        if(a==null && b==null)
	            return true;
	        
	        if(a!=null && b!=null)
	            return a.data==b.data && symmetricHelper(a.left,b.right) && symmetricHelper(a.right,b.left);
	        return false;
	    }
	    
		// O(min(m,n)),O(min(m,n))
		boolean isIsomorphic(Node root1, Node root2) {

			if (root1 == null && root2 == null)
				return true;

			if (root1 == null || root2 == null)
				return false;

			// don't forget this condition
			if (root1.data != root2.data)
				return false;

			// either normal or flip
			return isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)
					|| isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

		}

	public static void main(String[] args) {
	
		BinaryTree tree = new BinaryTree();
		BinaryTree tree1 = new BinaryTree();
		
		 tree.root = new Node(1);
		 tree.root.left = new Node(2);
		 tree.root.right = new Node(3);
	     tree.root.left.left = new Node(4);
	     tree.root.left.right=new Node(5);
	     
	     tree1.root = new Node(2);
		 tree1.root.left = new Node(4);
		 tree1.root.right = new Node(5);
		 //tree1.root.right.right=new Node(6);
		 
	   
	     
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
		System.out.println(tree.height(tree.root));
		
		System.out.println("\nDIAMETER :");
		System.out.println(tree.diameterOfBinaryTree(tree.root));
		
		
		System.out.println("\nhas path for given sum ?:");
		System.out.println(tree.hasPathSum(tree.root, 7));
		
		System.out.println("\nall path for given sum ?:");
		
		
		
		System.out.println(tree.allPathSum(tree.root,7));
		
		System.out.println("\nall paths from root to leaf:");
		
		
		System.out.println(tree.allPaths(tree.root));
		
		System.out.println("\nmirror of tree/invert tree:");
		
		//tree.root=tree.invertTree(tree.root);
		
		//tree.preorder(tree.root);
		
		System.out.println("\n right side view tree:");
		
		System.out.println(tree.rightSideView(tree.root));
		
		System.out.println("\n right side view tree:");
		
		System.out.println(tree.leftSideView(tree.root));
		
		System.out.println("\n sum of all nodes :");
		System.out.println(tree.sumBT(tree.root));
		
		System.out.println("\n top view of binary tree ");
		System.out.println(tree.topView(tree.root));
		
		System.out.println("\n Zig zag level order : ");
		System.out.println(tree.zigzaglevel(tree.root));
		
		//System.out.println("\n flatten to linked list : In place ");
		//tree.flattenToLinkedList(tree.root);
		
		//tree.preorder(tree.root);
		
		System.out.println("\n morris pre order ");
		tree.morrisPreorder(tree.root);
		
		System.out.println("\n balanced binary tree : ");
		System.out.println(tree.isBalanced(tree.root));
		
		//System.out.println("\n Convert To DLL : Inplace");
		
		//tree.toDLL(tree.root);
		//tree.printDLL(head);
		
		System.out.println("sum of left leafs");
		System.out.println(tree.sumOfLeftLeaves(tree.root));
		
		System.out.println("\nsum tree or not : ");
		System.out.println(tree.isSumTree(tree.root));
		
//		1                  
//	   /  \
//	  2	  3        2
//	 / \          / \
//  4   5        4   5     == sub tree
   
		System.out.println("\nsub tree or not? : ");
		
		System.out.println(tree.isSubtree(tree.root, tree1.root));
		
		
		System.out.println("\noptimized version , sub tree or not? : ");
		
		System.out.println(tree.subTreeOptimized(tree.root, tree1.root));
		
		System.out.println("\nmirror or not : ");
		
		System.out.println(tree.areMirror(tree.root, tree1.root));
		
		System.out.println("\nsymmetric or not : ");
		
		System.out.println(tree.isSymmetric(tree.root));
		
		System.out.println("\nIsomorphic or not: ");
		
		System.out.println(tree.isIsomorphic(tree.root, tree1.root));
		
	}

	

}
