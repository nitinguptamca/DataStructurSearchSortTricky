package tree.binary.Search.tree;

public class AVLTreeDemo {
	Node root;
	private class Node {
		Node left, right;
		int height, key;

		public Node(int key) {
			this.key = key;
			height = 1;
		}
	}
	int balance(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}
	int height(Node n) {
		if (n == null)
			return 0;
		return n.height;
	}
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	Node rightRotata(Node y) {
		Node x=y.left;
		Node t2=x.right;
		
		x.right=y;
		y.left=t2;
		
		y.height=max(height(y.left ) ,height(y.right))+1;
		x.height=max(height(x.left) ,height(x.right) )+1;
		
		return x;
	}
	
	Node leftRotate(Node x) {
		Node y=x.right;
		Node T2=y.left;
		
		y.left=x;
		x.right=T2;
		
		x.height=max(height(x.left) ,height(x.right) )+1;
		y.height=max(height(y.left ) ,height(y.right))+1;
		
		return y;
	}
}
