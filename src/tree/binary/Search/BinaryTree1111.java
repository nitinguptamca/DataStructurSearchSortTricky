package tree.binary.Search;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree1111 {
	protected Node root;
	 // head --> Pointer to head node of created doubly linked list
    Node head;
      
    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static Node prev = null;

	private class Node {
		protected Node left, right;
		protected int value;

		public Node(int value) {
			this.left = null;
			this.right = null;
			this.value = value;
		}
	}

	public void add(int value) {
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
			// value already exists
			return current;
		}
		return current;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
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

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	// Finally, let’s create the public method that starts the deletion from the
	// root:
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	/**
	 * 
	 * Depth-First Search Depth-first search is a type of traversal that goes deep
	 * as much as possible in every child before exploring the next sibling.
	 * 
	 * There are several ways to perform a depth-first search: in-order, pre-order
	 * and post-order.
	 * 
	 * The in-order traversal consists of first visiting the left sub-tree, then the
	 * root node, and finally the right sub-tree:
	 * 
	 * @param args
	 */
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}

	// Pre-order traversal visits first the root node, then the left subtree, and
	// finally the right subtree:
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	// Post-order traversal visits the left subtree, the right subtree, and the root
	// node at the end:
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}

	//// Breadth-First Search called level-order
	/**
	 * visits all the nodes of a level before going to the next level. This kind of
	 * traversal is also called level-order and visits all the levels of the tree
	 * starting from the root, and from left to right.
	 * 
	 * For the implementation, we’ll use a Queue to hold the nodes from each level
	 * in order. We’ll extract each node from the list, print its values, then add
	 * its children to the queue:
	 */
	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(" " + node.value);
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	/* Function to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
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

	// Function to print the spiral traversal of tree
	void printSpiral(Node node) {
		int h = height(node);
		int i;

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * transversed from left to right
		 */
		boolean ltr = false;
		for (i = 1; i <= h; i++) {
			printGivenLevel(node, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
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

	/* Print nodes at a given level */
	void printGivenLevel(Node node, int level, boolean ltr) {
		if (node == null)
			return;
		if (level == 1)
			System.out.print(node.value + " ");
		else if (level > 1) {
			if (ltr != false) {
				printGivenLevel(node.left, level - 1, ltr);
				printGivenLevel(node.right, level - 1, ltr);
			} else {
				printGivenLevel(node.right, level - 1, ltr);
				printGivenLevel(node.left, level - 1, ltr);
			}
		}
	}

	// function to print the
	// zigzag traversal
	void printZigZagTraversal() {

		// if null then return
		if (root == null) {
			return;
		}

		// declare two stacks
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(root);
		boolean leftToRight = true;

		// check if stack is empty
		while (!currentLevel.isEmpty()) {

			// pop out of stack
			Node node = currentLevel.pop();

			// print the value in it
			System.out.print(node.value + " ");

			// store value according to current
			// order.
			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}

				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}

				if (node.left != null) {
					nextLevel.push(node.left);
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

	// Convert a Binary Tree into its Mirror Tree

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
	//Write Code to Determine if Two Trees are Identical
	 /* Given two trees, return true if they are
    structurally identical */
 boolean identicalTrees(Node a, Node b) 
 {
     /*1. both empty */
     if (a == null && b == null)
         return true;
          
     /* 2. both non-empty -> compare them */
     if (a != null && b != null) 
         return (a.value == b.value
                 && identicalTrees(a.left, b.left)
                 && identicalTrees(a.right, b.right));

     /* 3. one empty, one not -> false */
     return false;
 }
/**
 * Foldable Binary Trees
Question: Given a binary tree, find out if the tree can be folded or not.

A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11

(b)
        10
       /  \
      7    15
     /      \
    9       11

(c)
        10
       /  \
      7   15
     /    /
    5   11

(d)

         10
       /   \
      7     15
    /  \    /
   9   10  12
 * @param args
 */
 /* Returns true if the given tree is foldable */
 boolean isFoldable(Node node) 
 {
     boolean res;

     /* base case */
     if (node == null)
         return true;

     /* convert left subtree to its mirror */
     mirror(node.left);

     /* Compare the structures of the right subtree and mirrored
      left subtree */
     res = isStructSame(node.left, node.right);

     /* Get the originial tree back */
     mirror(node.left);

     return res;
 }

 boolean isStructSame(Node a, Node b) 
 {
     if (a == null && b == null)
         return true;
     if (a != null && b != null
             && isStructSame(a.left, b.left)
             && isStructSame(a.right, b.right)) 
         return true;

     return false;
 }
 
	// A simple recursive function to convert a given Binary tree
	// to Doubly Linked List
	// root --> Root of Binary Tree
	// Convert a given Binary Tree to Doubly Linked List
	void BinaryTree2DoubleLinkedList(Node root) {
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);
		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}
	//Inorder Tree Traversal without Recursion
	private  void inorder()
	    {
	        if (root == null)
	            return;
	 
	 
	        Stack<Node> s = new Stack<Node>();
	        Node curr = root;
	 
	        // traverse the tree
	        while (curr != null || s.size() > 0)
	        {
	 
	            /* Reach the left most Node of the
	            curr Node */
	            while (curr !=  null)
	            {
	                /* place pointer to a tree node on
	                   the stack before traversing
	                  the node's left subtree */
	                s.push(curr);
	                curr = curr.left;
	            }
	 
	            /* Current must be NULL at this point */
	            curr = s.pop();
	 
	            System.out.print(curr.value + " ");
	 
	            /* we have visited the node and its
	               left subtree.  Now, it's right
	               subtree's turn */
	            curr = curr.right;
	        }
	    }
	
	
	 // Iterative method to find height of Bianry Tree
    private int treeHeight(Node node) 
    {
        // Base Case
        if (node == null)
            return 0;
  
        // Create an empty queue for level order tarversal
        Queue<Node> q = new LinkedList();
  
        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;
  
        while (1 == 1) 
        {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
  
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) 
            {
                Node newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }
    
    //Insret node in binary tree using iteration
    public Node insertNode(Node root, Node node) {
        if (root == null)
            return node;
        Node curr = root;
        while (true) {
            if (node.value < curr.value) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = node;
                    break;
                }
            } else if (node.value > curr.value) {
                if (curr.right != null) 
                    curr = curr.right;
                else {
                    curr.right = node;
                    break;
                }
            } else {
                curr.value = node.value;
                break;
            }
        }
        return root;
    }
   /**
    * inserting using Iteration 
    * @param root
    * @param value
    * @return
    */
    
    public  Node insertIterative(Node root, int value)
    {
        // start with root node
        Node curr = root;

        // pointer to store parent node of current node
        Node parent = null;

        // if tree is empty, create a new node and set root
        if (root == null) {
            return new Node(value);
        }

        // traverse the tree and find parent node of key
        while (curr != null)
        {
            // update parent node as current node
            parent = curr;

            // if given key is less than the current node,
            // go to left subtree else go to right subtree
            if (value < curr.value) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        // construct a new node and assign to appropriate parent pointer
        if (value < parent.value) {
            parent.left = new Node(value);
        }
        else {
            parent.right = new Node(value);
        }

        return root;
    }

	public static void main(String[] args) {
		BinaryTree1111 bt = new BinaryTree1111();
		bt.add(12);
		bt.add(9);
		bt.add(8);
		bt.add(10);
		bt.add(2);
		bt.add(14);
		bt.add(3);
		bt.add(4);
		bt.add(10);
		bt.add(22);
		bt.add(14);
		bt.add(1);
		bt.add(21);
		bt.add(16);
		bt.add(17);
		bt.add(13);
		bt.add(19);
		bt.add(15);
		bt.add(5);
		bt.add(7);
		bt.add(6);
		bt.add(12);
		bt.add(11);
		bt.traverseInOrder(bt.root);
		System.out.println();
		bt.traversePreOrder(bt.root);
		System.out.println();
		bt.traversePostOrder(bt.root);
		System.out.println();
		bt.traverseLevelOrder();
		bt.findSmallestValue(bt.root);
		
		bt.treeHeight(bt.root);

		bt.delete(5);
		
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key: keys) {
            bt.root = bt.insertIterative(bt.root, key);
        }
	}

}
