package tree.binary.Search.tree;

public class BinaryTreeIierative {

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
		BinaryTreeIierative iierative = new BinaryTreeIierative();
		iierative.add(100);
		iierative.add(110);
		iierative.add(90);
		iierative.add(99);
		iierative.add(80);
		iierative.add(85);
		iierative.add(105);
		iierative.add(187);
		iierative.add(190);
		iierative.add(1);
		iierative.add(125);
		iierative.add(118);
		iierative.traverseInOrder(iierative.root);
		System.out.println();
		iierative.traverPreOrder(iierative.root);
		System.out.println();
		iierative.traversePostOrder(iierative.root);
		System.out.println();
	}

	private void traversePostOrder(Node root2) {
		// TODO Auto-generated method stub

	}

	private void traverPreOrder(Node root2) {
		// TODO Auto-generated method stub

	}

	private void traverseInOrder(Node root2) {
		// TODO Auto-generated method stub

	}

	private void add(int data) {
		// TODO Auto-generated method stub

	}

}
