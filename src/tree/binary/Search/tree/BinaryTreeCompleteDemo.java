package tree.binary.Search.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeCompleteDemo {
	Node root;

	private class Node {
		Node right, left;
		int value;

		public Node(int value) {
			right = null;
			left = null;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		BinaryTreeCompleteDemo completeDemo = new BinaryTreeCompleteDemo();
		completeDemo.add(100);
		completeDemo.add(110);
		completeDemo.add(90);
		completeDemo.add(99);
		completeDemo.add(80);
		completeDemo.add(85);
		completeDemo.add(105);
		completeDemo.add(187);
		completeDemo.add(190);
		completeDemo.add(1);
		completeDemo.add(125);
		completeDemo.add(118);
		completeDemo.traverseInOrder(completeDemo.root);
		System.out.println();
		
		completeDemo.traversePreOrder(completeDemo.root);
		System.out.println();
		completeDemo.traversePostOrder(completeDemo.root);
		System.out.println();
		completeDemo.traverseLevelOrder(completeDemo.root);

		System.out.println();
		completeDemo.traverseZigZag(completeDemo.root);
		System.out.println();
		boolean flag = completeDemo.containsNode(105);
		System.out.println("flag  -->>" + flag);
		completeDemo.delete(105);
		completeDemo.traverseInOrder(completeDemo.root);
		System.out.println();
		System.out.println("findSmallestValue   " + completeDemo.findSmallestValue(completeDemo.root));
		System.out.println();
		System.out.println("minvalue   " + completeDemo.minvalue(completeDemo.root));

		System.out.println();
		System.out.println("findLargestValue   " + completeDemo.findLargestValue(completeDemo.root));
		System.out.println();
		System.out.println("maxValue   " + completeDemo.maxValue(completeDemo.root));
		System.out.println();
		System.out.println("count node " + completeDemo.countNode());
		System.out.println(" height " + completeDemo.height(completeDemo.root));
		System.out.println(" maxDepth " + completeDemo.maxDepth(completeDemo.root));
		completeDemo.mirror();
		System.out.println();
		completeDemo.traversePreOrder(completeDemo.root);
	}

	
	void mirror() {
		root = mirror(root);
	}

	Node mirror(Node node) {
		if (node == null)
			return node;

		/* do the subtrees */
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return 0;
		else {

			/* compute the height of each subtree */
			int lheight = height(node.left);
			int rheight = height(node.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	private int countNode() {
		return countNodes(root);
	}

	private int countNodes(Node r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	int minvalue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return (current.value);
	}

	int maxValue(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.right != null) {
			current = current.right;
		}
		return (current.value);
	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	private int findLargestValue(Node root) {
		return root.right == null ? root.value : findLargestValue(root.right);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		if (value == current.value) {
			if (current.left == null && current.right == null) {
				return null;
			}
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		} else {
			current.right = deleteRecursive(current.right, value);
			return current;
		}
	}

	private boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node node, int value) {
		if (node == null)
			return false;
		if (value == node.value) {
			return true;
		}
		return value < node.value ? containsNodeRecursive(node.left, value) : containsNodeRecursive(node.right, value);
	}

	private void traverseZigZag(Node node) {
		if (node == null)
			return;
		// declare two stacks
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(node);
		boolean leftToRight = true;
		while (!currentLevel.isEmpty()) {
			// pop out of stack
			Node tmp = currentLevel.pop();

			// print the data in it
			System.out.print(tmp.value + "  ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (tmp.left != null) {
					nextLevel.push(tmp.left);
				}

				if (tmp.right != null) {
					nextLevel.push(tmp.right);
				}
			} else {
				if (tmp.right != null) {
					nextLevel.push(tmp.right);
				}

				if (tmp.left != null) {
					nextLevel.push(tmp.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}

	}

	private void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// already added
		}
		return current;
	}

	// Left-root-right
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print("  " + node.value);
			traverseInOrder(node.right);
		}
	}

	// root-left-right
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print("  " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	// right-left-root
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print("  " + node.value);
		}
	}

	public void traverseLevelOrder(Node node) {
		if (node == null)
			return;
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(node);

		while (!nodes.isEmpty()) {
			Node node1 = nodes.remove();
			System.out.print("  " + node1.value);
			if (node1.left != null) {
				nodes.add(node1.left);
			}
			if (node1.right != null) {
				nodes.add(node1.right);
			}
		}
	}
}
