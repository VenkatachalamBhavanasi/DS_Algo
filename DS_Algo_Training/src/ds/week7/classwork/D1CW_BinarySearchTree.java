package ds.week7.classwork;

public class D1CW_BinarySearchTree {

	public static void main(String[] args) {
		
		D1CW_BinarySearchTree bst = new D1CW_BinarySearchTree();
		bst.insert(8);
		bst.insert(7);
		bst.insert(6);
		bst.insert(4);
		bst.insert(12);
		bst.insert(11);
		bst.insert(9);
		bst.insert(3);
		bst.insert(10);
		bst.insert(5);
		bst.insert(1);
		bst.insert(2);
		
		bst.postorder();

	}


	/* Class containing left and right child of current node and key value*/
	class Node { 
		int key; 
		Node left, right; 

		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	// Root of BST 
	Node root; 

	// Constructor 
	D1CW_BinarySearchTree() {  
		root = null;  
	} 

	// This method mainly calls insertRec() 
	void insert(int key) { 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) { 

		/* If the tree is empty, return a new node */
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder()  { 
		inorderRec(root); 
	} 
	
	void preorder()  { 
		preorderRec(root); 
	} 
	
	void postorder()  { 
		postorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(Node root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	} 
	
	void preorderRec(Node root) { 
		if (root != null) { 
			System.out.println(root.key); 
			preorderRec(root.left); 
			preorderRec(root.right); 
		} 
	} 
	
	void postorderRec(Node root) { 
		if (root != null) { 
			postorderRec(root.left); 
			postorderRec(root.right); 
			System.out.println(root.key); 
		} 
	} 
}

