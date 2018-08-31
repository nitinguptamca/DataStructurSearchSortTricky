package tree.binary.Search.tree;

import java.util.Stack;

public class BinaryTreeIterative {

	TreeNode root;

	private class TreeNode {
		TreeNode right, left;
		int value;

		public TreeNode(int value) {
			right = null;
			left = null;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		BinaryTreeIterative iierative = new BinaryTreeIterative();
		/*
		 * iierative.root = iierative.add(100); iierative.root = iierative.add(110);
		 * iierative.root = iierative.add(90); iierative.root = iierative.add(99);
		 * iierative.root = iierative.add(80); iierative.root = iierative.add(85);
		 * iierative.root = iierative.add(105); iierative.root = iierative.add(187);
		 * iierative.root = iierative.add(190); iierative.root = iierative.add(1);
		 * iierative.root = iierative.add(125); iierative.root = iierative.add(118);
		 */

		iierative.add1(100);
		iierative.add1(110);
		iierative.add1(90);
		iierative.add1(99);
		iierative.add1(80);
		iierative.add1(85);
		iierative.add1(105);
		iierative.add1(187);
		iierative.add1(190);
		iierative.add1(1);
		iierative.add1(125);
		iierative.add1(118);
		iierative.traverseInOrder(iierative.root);
		System.out.println();
		iierative.inorder();
		System.out.println();
		iierative.inOrderWithoutRecursion();
	}

	// Left-root-right
	public void traverseInOrder(TreeNode node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print("  " + node.value);
			traverseInOrder(node.right);
		}
	}

	private TreeNode add(int value) {
		TreeNode current = root;
		TreeNode node = new TreeNode(value);
		TreeNode present = null;
		if (root == null) {
			root = node;
			return root;
		} else {
			while (current != null) {
				present = current;
				if (value < current.value) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (value < present.value) {
				present.left = node;
			} else {
				present.right = node;
			}
			return root;
		}
	}

	// Iterative
	private void add1(int value) {
		TreeNode current = root;
		TreeNode node = new TreeNode(value);
		TreeNode present = null;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				present = current;
				if (value < current.value) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			if (value < present.value) {
				present.left = node;
			} else {
				present.right = node;
			}
		}
	}

	public void inOrderWithoutRecursion() {
		Stack<TreeNode> nodes = new Stack<>();
		TreeNode current = root;
		while (!nodes.isEmpty() || current != null) {
			if (current != null) {
				nodes.push(current);
				current = current.left;
			} else {
				TreeNode node = nodes.pop();
				System.out.printf("%s ", node.value);
				current = node.right;
			}
		}
	}

	void inorder() {
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = root;
		// traverse the tree
		while (current != null || s.size() > 0) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}
			current = s.pop();

			System.out.print(current.value + " ");
			current = current.right;
		}
	}

	// Function to check the given key exist or not
	private boolean iterativeSearch(int value) {
		// Traverse untill root reaches to dead end
		while (root != null) { // pass right subtree as new tree
			if (value > root.value)
				root = root.right;
			// pass left subtree as new tree
			else if (value < root.value)
				root = root.left;
			else
				return true;// if the key is found return 1
		}
		return false;
	}
}
