package tree.binary.Search.tree;

//Java program for different tree traversals

/* Class containing left and right child of current
node and key value*/
/**
 * Tree Traversals (Inorder, Preorder and Postorder) Unlike linear data
 * structures (Array, Linked List, Queues, Stacks, etc) which have only one
 * logical way to traverse them, trees can be traversed in different ways.
 * Following are the generally used ways for traversing trees.
 * 
 * 
 * 
 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b)
 * Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) :
 * 4 5 2 3 1
 * 
 * Breadth First or Level Order Traversal : 1 2 3 4 5 Please see this post for
 * Breadth First Traversal.
 * 
 * Inorder Traversal:
 * 
 * Algorithm Inorder(tree) 1. Traverse the left subtree, i.e., call
 * Inorder(left-subtree) 2. Visit the root. 3. Traverse the right subtree, i.e.,
 * call Inorder(right-subtree) Uses of Inorder In case of binary search trees
 * (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of
 * BST in non-increasing order, a variation of Inorder traversal where Inorder
 * traversal s reversed can be used. Example: Inorder traversal for the
 * above-given figure is 4 2 5 1 3.
 * 
 * Practice Inorder Traversal
 * 
 * 
 * Preorder Traversal:
 * 
 * Algorithm Preorder(tree) 1. Visit the root. 2. Traverse the left subtree,
 * i.e., call Preorder(left-subtree) 3. Traverse the right subtree, i.e., call
 * Preorder(right-subtree) Uses of Preorder Preorder traversal is used to create
 * a copy of the tree. Preorder traversal is also used to get prefix expression
 * on of an expression tree. Please see
 * http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions
 * are useful. Example: Preorder traversal for the above given figure is 1 2 4 5
 * 3.
 * 
 * https://practice.geeksforgeeks.org/problems/preorder-traversal/1Practice
 * Preorder Traversal
 * 
 * 
 * Postorder Traversal:
 * 
 * Algorithm Postorder(tree) 1. Traverse the left subtree, i.e., call
 * Postorder(left-subtree) 2. Traverse the right subtree, i.e., call
 * Postorder(right-subtree) 3. Visit the root. Uses of Postorder Postorder
 * traversal is used to delete the tree. Please see the question for deletion of
 * tree for details. Postorder traversal is also useful to get the postfix
 * expression of an expression tree. Please see
 * http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of
 * postfix expression.
 * 
 * https://practice.geeksforgeeks.org/problems/postorder-traversal/1Practice
 * Postorder Traversal
 * 
 * Example: Postorder traversal for the above given figure is 4 5 2 3 1.
 * 
 * @author nitin
 *
 */
class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() {
		root = null;
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up" postorder
	 * traversal.
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}
}
