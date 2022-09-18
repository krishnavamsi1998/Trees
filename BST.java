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

	// O(logn),O(n)
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

	// O(logn),O(n)
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

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(8);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(4);

		tree.inOrder(tree.root);
		System.out.println();
		System.out.println(tree.searchKey(3));

	}
}
