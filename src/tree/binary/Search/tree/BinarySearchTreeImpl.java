package tree.binary.Search.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nitin
 *
 *         Program: Implement Binary Search Tree (BST)
 * 
 *         Description: For a binary tree to be a binary search tree (BST), the
 *         data of all the nodes in the left sub-tree of the root node should be
 *         less than or equals to the data of the root. The data of all the
 *         nodes in the right subtree of the root node should be greater than
 *         the data of the root.
 */
class BstNode {

	private BstNode left;
	private BstNode right;
	private Integer data;

	public BstNode(Integer data) {
		this.data = data;
	}

	public BstNode getLeft() {
		return left;
	}

	public void setLeft(BstNode left) {
		this.left = left;
	}

	public BstNode getRight() {
		return right;
	}

	public void setRight(BstNode right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}

public class BinarySearchTreeImpl {

	private BstNode root;

	public boolean isEmpty() {

		return (this.root == null);
	}

	public BstNode getRoot() {
		return this.root;
	}

	public void insert(Integer data) {

		System.out.print("[input: " + data + "]");
		if (root == null) {
			this.root = new BstNode(data);
			System.out.println(" -> inserted: " + data);
			return;
		}

		insertNode(this.root, data);
		System.out.print(" -> inserted: " + data);
		System.out.println();
	}

	private BstNode insertNode(BstNode root, Integer data) {

		BstNode tmpNode = null;
		System.out.print(" ->" + root.getData());
		if (root.getData() >= data) {
			System.out.print(" [L]");
			if (root.getLeft() == null) {
				root.setLeft(new BstNode(data));
				return root.getLeft();
			} else {
				tmpNode = root.getLeft();
			}
		} else {
			System.out.print(" [R]");
			if (root.getRight() == null) {
				root.setRight(new BstNode(data));
				return root.getRight();
			} else {
				tmpNode = root.getRight();
			}
		}

		return insertNode(tmpNode, data);
	}

	/**
	 * @return
	 * 
	 * 		Program: Find min and max value from Binary Search Tree (BST)
	 * 
	 *         Description: For a binary tree to be a binary search tree (BST), the
	 *         data of all the nodes in the left sub-tree of the root node should be
	 *         less than or equals to the data of the root. The data of all the
	 *         nodes in the right subtree of the root node should be greater than
	 *         the data of the root. This example shows how to find min & max value
	 *         of a binary search tree.
	 */

	public Integer findMinValue() {

		return minValue(this.root);
	}

	public Integer findMaxValue() {

		return maxValue(this.root);
	}

	private Integer minValue(BstNode node) {

		if (node.getLeft() != null) {
			return minValue(node.getLeft());
		}
		return node.getData();
	}

	private Integer maxValue(BstNode node) {

		if (node.getRight() != null) {
			return maxValue(node.getRight());
		}
		return node.getData();
	}

	/**
	 * Program: Find height of a Binary Search Tree (BST)
	 * 
	 * Description: For a binary tree to be a binary search tree (BST), the data of
	 * all the nodes in the left sub-tree of the root node should be less than or
	 * equals to the data of the root. The data of all the nodes in the right
	 * subtree of the root node should be greater than the data of the root. This
	 * example shows how to find height of a binary search tree.
	 */
	public Integer findHeight() {

		return getNodeHeight(this.root);
	}

	private Integer getNodeHeight(BstNode node) {

		if (node == null) {
			return -1;
		}

		return Math.max(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight())) + 1;
	}

	/**
	 * Program: Implement Binary Search Tree (BST) Level order traversal (breadth
	 * first).
	 * 
	 * Description: For a binary tree to be a binary search tree (BST), the data of
	 * all the nodes in the left sub-tree of the root node should be less than or
	 * equals to the data of the root. The data of all the nodes in the right
	 * subtree of the root node should be greater than the data of the root. This
	 * example shows the implementation of a binary search tree level order
	 * traversal (breadth first).
	 * 
	 * What is Level order traversal (breadth first)? In Level order traversal, we
	 * visit every node on a level before going to a lower level from left to right.
	 * This is also known as Breadth first traversal as the search tree is broadened
	 * as much as possible on each depth before going to the next depth. Below
	 * picture shows the level order traversal.
	 * 
	 * Here is the steps to implement Level order traversal:
	 * 
	 * Since we have to traverse in same level until we cover all nodes in the same
	 * level, it is hard to keep the node references, we will maintain a queue for
	 * storing all discovered nodes. Initially the queue will be empty. If the root
	 * node is not null, push it to the queue. Use a while loop to visit all nodes
	 * in the queue until the queue is empty. Inside while loop, pop out the node.
	 * Add the left node to the queue if it is not null. Add the right node to the
	 * queue if it is not null. Read the node data and display it. Repeat from step
	 * 5, until the queue is empty.
	 */

	public void levelOrderTraversal() {

		Queue<BstNode> discovedNodeQueue = new LinkedList<>();
		if (this.root == null) {
			System.out.println("The tree is empty.");
			return;
		}
		discovedNodeQueue.add(this.root);
		while (!discovedNodeQueue.isEmpty()) {

			BstNode tmpNode = discovedNodeQueue.remove();
			if (tmpNode.getLeft() != null) {
				discovedNodeQueue.add(tmpNode.getLeft());
			}
			if (tmpNode.getRight() != null) {
				discovedNodeQueue.add(tmpNode.getRight());
			}
			System.out.print(tmpNode.getData() + " ");
		}
	}

	/**
	 * Program: Implement Binary Search Tree (BST) pre-order traversal (depth
	 * first).
	 * 
	 * What is pre-order traversal (depth first)? Tree traversal means we visiting
	 * all nodes in the tree, visiting means either of accessing node data or
	 * processing node data. Traversal can be specified by the order of visiting 3
	 * nodes, ie current node, left subtree and right subtree. In pre-order
	 * traversal, first we visit the current node, then left subtree and then right
	 * subtree. In our current example we use recursive approach to implement
	 * pre-order traversal.
	 * 
	 * Here is the steps to implement pre-order traversal:
	 * 
	 * 
	 * Start with root node.
	 * 
	 * Check if the current node is empty / null.
	 * 
	 * Display the data part of the root (or current node).
	 * 
	 * Traverse the left subtree by recursively calling the pre-order function.
	 * 
	 * Traverse the right subtree by recursively calling the pre-order function.
	 */

	public void preOrderTraversal() {
		doPreOrder(this.root);
	}

	private void doPreOrder(BstNode root) {

		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		doPreOrder(root.getLeft());
		doPreOrder(root.getRight());
	}

	/**
	 * Program: Implement Binary Search Tree (BST) in-order traversal (depth first).
	 * What is in-order traversal (depth first)? Tree traversal means we visiting
	 * all nodes in the tree, visiting means either of accessing node data or
	 * processing node data. Traversal can be specified by the order of visiting 3
	 * nodes, ie current node, left subtree and right subtree. In in-order
	 * traversal, first we visit the left subtree, then current node and then right
	 * subtree. In-order traversal gives data in the sorted order. In our current
	 * example we use recursive approach to implement in-order traversal.
	 * 
	 * Here is the steps to implement in-order traversal:
	 * 
	 * Start with root node.
	 * 
	 * Check if the current node is empty / null.
	 * 
	 * Traverse the left subtree by recursively calling the in-order function.
	 * 
	 * Display the data part of the root (or current node).
	 * 
	 * Traverse the right subtree by recursively calling the in-order function.
	 */

	public void inOrderTraversal() {
		doInOrder(this.root);
	}

	private void doInOrder(BstNode root) {

		if (root == null)
			return;
		doInOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		doInOrder(root.getRight());
	}

	public static void main(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(10);
		bst.insert(20);
		bst.insert(21);
		bst.insert(8);
		bst.insert(6);
		bst.insert(16);
		bst.insert(23);
	}

	public static void main1(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(10);
		bst.insert(20);
		bst.insert(21);
		bst.insert(8);
		bst.insert(6);
		bst.insert(16);
		bst.insert(23);
		bst.insert(2);
		System.out.println("-------------------");
		System.out.println("Min value: " + bst.findMinValue());
		System.out.println("Max value: " + bst.findMaxValue());
	}

	public static void main2(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(10);
		bst.insert(20);
		bst.insert(21);
		bst.insert(8);
		bst.insert(6);
		bst.insert(16);
		bst.insert(23);
		bst.insert(2);
		System.out.println("-------------------");
		System.out.println("Height of the tree: " + bst.findHeight());
	}

	public static void main4(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(8);
		bst.insert(10);
		bst.insert(14);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(13);
		System.out.println("-------------------");
		System.out.println("Level order traversal");
		bst.levelOrderTraversal();
	}

	public static void main41(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(8);
		bst.insert(10);
		bst.insert(14);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(13);
		System.out.println("\n-------------------");
		System.out.println("Pre Order Traversal");
		bst.preOrderTraversal();
	}

	public static void main9(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(8);
		bst.insert(10);
		bst.insert(14);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(13);
		System.out.println("\n-------------------");
		System.out.println("In Order Traversal");
		bst.inOrderTraversal();
	}

	/**
	 * Program: Implement Binary Search Tree (BST) post-order traversal (depth
	 * first). What is post-order traversal (depth first)? Tree traversal means we
	 * visiting all nodes in the tree, visiting means either of accessing node data
	 * or processing node data. Traversal can be specified by the order of visiting
	 * 3 nodes, ie current node, left subtree and right subtree. In post-order
	 * traversal, first we visit the left subtree, then the right subtree, and then
	 * current node. In our current example we use recursive approach to implement
	 * post-order traversal. Here is the steps to implement post-order traversal:
	 * 
	 * Start with root node.
	 * 
	 * Check if the current node is empty / null.
	 * 
	 * Traverse the left subtree by recursively calling the post-order function.
	 * 
	 * Traverse the right subtree by recursively calling the post-order function.
	 * 
	 * Display the data part of the root (or current node).
	 */
	public void postOrderTraversal() {
		doPostOrder(this.root);
	}

	private void doPostOrder(BstNode root) {

		if (root == null)
			return;
		doPostOrder(root.getLeft());
		doPostOrder(root.getRight());
		System.out.print(root.getData() + " ");
	}

	public static void main111(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(8);
		bst.insert(10);
		bst.insert(14);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(13);
		System.out.println("\n-------------------");
		System.out.println("Post Order Traversal");
		bst.postOrderTraversal();
	}

	public static void main22(String a[]) {

		BstNode root = new BstNode(3);
		// left sub tree
		BstNode node_2 = new BstNode(2);
		root.setLeft(node_2);
		BstNode node_1 = new BstNode(1);
		node_2.setLeft(node_1);
		BstNode node_4 = new BstNode(4);
		node_2.setRight(node_4);
		// right sub tree
		BstNode node_6 = new BstNode(6);
		root.setRight(node_6);
		BstNode node_5 = new BstNode(5);
		node_6.setLeft(node_5);
		BstNode node_7 = new BstNode(7);
		node_6.setRight(node_7);

		IsBinarySearchTree ibsTree = new IsBinarySearchTree();
		System.out.println(ibsTree.isBinarySearchTree(root));
	}

	public void delete(Integer data) {

		deleteNode(this.root, data);
	}

	/**
	 * Program: How to delete a node from Binary Search Tree (BST)?
	 * 
	 * Description: In a Binary Tree, each node can have at most two nodes. For a
	 * binary tree to be a binary search tree (BST), the data of all the nodes in
	 * the left sub-tree of the root node should be less than or equals to the data
	 * of the root. The data of all the nodes in the right subtree of the root node
	 * should be greater than the data of the root.
	 * 
	 * Deleting a node from Binary search tree is little complicated compare to
	 * inserting a node. It includes two steps:
	 * 
	 * Search the node with given value. Delete the node. The algorithm has 3 cases
	 * while deleting node:
	 * 
	 * Node to be deleted has is a leaf node (no children). Node to be deleted has
	 * one child (eight left or right child node). Node to be deleted has two nodes.
	 * We will use simple recursion to find the node and delete it from the tree.
	 * 
	 * Here is the steps to delete a node from binary search tree:
	 * 
	 * Case 1: Node to be deleted has is a leaf node (no children).
	 * 
	 * This is very simple implementation. First find the node reference with given
	 * value. Set corresponding link of the parent node to null. With this the node
	 * to be deleted lost its connectivity and eligible for garbage collection. Case
	 * 2: Node to be deleted has one child (eight left or right child node).
	 * 
	 * First find the node reference with given value. Take the reference of the
	 * child node and assign its reference to the corresponding link of the parent
	 * node. With this the node to be deleted lost its connectivity and eligible for
	 * garbage collection. Case 3: Node to be deleted has two nodes.
	 * 
	 * It is little complicated process. First find the node reference with given
	 * value. Find the minimum/maximum value of the right/left sub tree. Replace the
	 * node value with the minimum/maximum value. Now delete the minimum/maximum
	 * value from the nodes right/left sub tree.
	 */
	private BstNode deleteNode(BstNode root, Integer data) {

		if (root == null)
			return root;

		if (data < root.getData()) {
			root.setLeft(deleteNode(root.getLeft(), data));
		} else if (data > root.getData()) {
			root.setRight(deleteNode(root.getRight(), data));
		} else {
			// node with no leaf nodes
			if (root.getLeft() == null && root.getRight() == null) {
				System.out.println("deleting " + data);
				return null;
			} else if (root.getLeft() == null) {
				// node with one node (no left node)
				System.out.println("deleting " + data);
				return root.getRight();
			} else if (root.getRight() == null) {
				// node with one node (no right node)
				System.out.println("deleting " + data);
				return root.getLeft();
			} else {
				// nodes with two nodes
				// search for min number in right sub tree
				Integer minValue = minValue(root.getRight());
				root.setData(minValue);
				root.setRight(deleteNode(root.getRight(), minValue));
				System.out.println("deleting " + data);
			}
		}

		return root;
	}

	public static void main33(String a[]) {

		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.insert(8);
		bst.insert(10);
		bst.insert(14);
		bst.insert(3);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);
		bst.insert(13);
		System.out.println("-------------------");
		System.out.println("In Order Traversal");
		bst.inOrderTraversal();
		System.out.println();
		bst.delete(13);
		bst.inOrderTraversal();
		System.out.println();
		bst.delete(14);
		bst.inOrderTraversal();
	}

}

/**
 * Program: How to check the given Binary Tree is Binary Search Tree (BST) or
 * not?
 * 
 * Description: In a Binary Tree, each node can have at most two nodes. For a
 * binary tree to be a binary search tree (BST), the data of all the nodes in
 * the left sub-tree of the root node should be less than or equals to the data
 * of the root. The data of all the nodes in the right subtree of the root node
 * should be greater than the data of the root.
 * 
 * There are various ways to validate Binary Search Tree. One of the simple way
 * is: The in-order traversal of a binary search tree results natural order. So,
 * we can do in-order traversal and check for natural order. If the order
 * sorted, then it is binary search tree. We will give this implementation in
 * the coming pages.
 * 
 * In this page we follow different approach. We will set min and max value for
 * each node and validate node data against min and max value. The same approach
 * will continue for each left and right sub binary search tree in recursive
 * way.
 * 
 * Here is the steps to validate binary search tree:
 * 
 * Start with root node. In this case root node data min & max values can be
 * extreme integer ranges. Pass min value as Integer.MIN_VALUE and max value as
 * Integer.MAX_VALUE.
 * 
 * Make sure node data is falling under min & max values.
 * 
 * Along with the above check, make sure the left and right sub trees are also
 * go through similar checks.
 * 
 * Make a recursive call on left node with no change in min value and node data
 * as max value.
 * 
 * Make a recursive call on right node with node data as min value and no change
 * in max value.
 * 
 * Check the the code for better understanding.
 */

class IsBinarySearchTree {

	public boolean isBinarySearchTree(BstNode root) {

		if (root == null)
			return Boolean.TRUE;
		return isBstValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBstValid(BstNode root, Integer minValue, Integer maxValue) {

		if (root == null)
			return Boolean.TRUE;
		if (root.getData() >= minValue && root.getData() < maxValue
				&& isBstValid(root.getLeft(), minValue, root.getData())
				&& isBstValid(root.getRight(), root.getData(), maxValue)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}