package trees;

public class BST {

	class Node {
		int data;
		Node left, right;

		public Node(int key) {
			this.data = key;
			left = right = null;
		}
	}

	Node root;

	BST() {
		root = null;

	}

	void insert(int key) {
		root = insertKey(root, key);

	}

	// O(logn),O(h)
	Node insertKey(Node root, int key) {

		if (root == null) {
			// using Node class which is already defined in other class
			root = new Node(key);
			return root;
		}
		if (key < root.data)
			root.left = insertKey(root.left, key);
		else if (key > root.data)
			root.right = insertKey(root.right, key);

		return root;
	}

	void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	// O(logn),O(h)
	boolean searchKey(int key) {
		return search(root, key);
	}

	boolean search(Node root, int key) {
		if (root == null)
			return false;

		if (root.data == key)
			return true;
		else if (key < root.data)
			return search(root.left, key);
		else
			return search(root.right, key);

	}

	// O(h),O(h)

	void deleteKey(int key) {
		root = delete(root, key);

	}

	Node delete(Node root, int key) {

		if (root == null)
			return root;

		// recurse left
		if (key < root.data)
			root.left = delete(root.left, key);
		// recurse right
		else if (key > root.data)
			root.right = delete(root.right, key);
		// found
		else {
			// if only one child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				// having both childs

				// find min val in right sub tree and assign to curr node
				root.data = minValueRightSubTree(root.right);
				// delete that min Value in Right SubTree
				root.right = delete(root.right, root.data);
			}

		}

		return root;
	}

	int minValueRightSubTree(Node root) {

		// int minVal = root.data;
		while (root.left != null) {
			// minVal = root.left.data;
			root = root.left;
		}

		return root.data;
	}

	// min value in bst is left most element in left sub tree
	// O(h),O(h)

	int minValueInBST() {

		Node curr = root;

		while (curr.left != null) {
			curr = curr.left;

		}
		return curr.data;

	}

	// max value in bst is right most element in right sub tree
	// O(h),O(h)

	int maxValueInBST() {

		Node curr = root;

		while (curr.right != null) {
			curr = curr.right;

		}
		return curr.data;

	}

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inOrder(tree.root);
		System.out.println();
		System.out.println(tree.searchKey(3));
		// tree.deleteKey(30);
		// tree.deleteKey(80);
		System.out.println(tree.minValueInBST());
		System.out.println(tree.maxValueInBST());

		tree.inOrder(tree.root);

	}
}
