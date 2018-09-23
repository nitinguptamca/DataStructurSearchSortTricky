package doublyLinkedList;

public class DoublyLinkedListDemo {

	protected Node head, tail, sorted;
	int size;

	private class Node {
		Node next, prev;
		int data;

		public Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}

	// remove duplicates from an unsorted linked list.
	public void removeDuplicate() {
		if (head == null)
			return;
		Node iter = head;

		while (iter != null) {
			Node currNode = iter;
			while (currNode != null && currNode.next != null) {
				if (iter.data == currNode.next.data) {
					Node nextNode = currNode.next;
					Node preVNode = currNode.prev;
					preVNode.next = nextNode;
					nextNode.prev = preVNode;
					size--;
					break;
				}
				currNode = currNode.next;
			}
			iter = iter.next;
		}
	}

	public void deleteNode(int key) {
		Node tmp = head;
		while (true) {
			if (key == tmp.data) {
				Node nextV = tmp.next;
				Node prevV = tmp.prev;
				prevV.next = nextV;
				nextV.prev = prevV;
				size--;
				return;
			} else {
				tmp = tmp.next;
			}
		}
	}

	// Implement an algorithm to find the nth to last element of a singly linked
	// list.
	private Node findNthToLast(int n) {
		if (head == null || n < 1)
			return null;
		Node p1 = head;
		Node p2 = head;
		for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}
		if (p2 == null) {
			return null;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	private void deleteNode1(Node node) {
		if (node == null || node.next == null) {
			return; // Failure
		}
		Node nextNode = node.next;
		Node prevNode = node.prev;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size--;
		return;
	}

	private Node findNthToLastUp(int position) {
		Node tmp = tail;
		for (int j = 0; j < position - 1; ++j) { // skip n-1 steps ahead
			if (tmp == null)
				return null;
			tmp = tmp.prev;
		}
		return tmp;
	}

	private void removeAtPosition(int position) {
		if (position == 1)
			removeAtFirst();
		else if (position == size)
			removeAtLast();
		else {
			int pos = position;
			Node tmp = head;
			for (int i = 1; i < size; i++) {
				if (pos == i) {
					Node nextV = tmp.next;
					Node prevV = tmp.prev;
					prevV.next = nextV;
					nextV.prev = prevV;
					size--;
					return;
				} else {
					tmp = tmp.next;
				}

			}

		}
	}

	private void removeAtLast() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("empty list");
			return;
		}
		Node tmp = tail.prev;
		tmp.next = null;
		tail = tmp;
		size--;

	}

	private void removeAtFirst() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("empty list");
			return;
		}
		Node tmp = head.next;
		tmp.prev = null;
		head = tmp;
		size--;
	}

	private void addAtPosition(int data, int position) {
		Node node = new Node(data);
		if (position == 1)
			addAtFirst(data);
		else if (position == size + 1)
			addAtLast(data);
		else {
			Node tmp = head;
			int pos = position - 1;
			for (int i = 1; i <= size; i++) {
				if (pos == i) {
					Node nextV = tmp.next;
					tmp.next = node;
					node.prev = tmp;
					node.next = nextV;
					nextV.prev = node;
					size++;
					return;
				} else {
					tmp = tmp.next;
				}
			}

		}
	}

	private void addAtLast(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			Node tmp = tail;
			tmp.next = node;
			node.prev = tmp;
			tail = node;
		}
		size++;
	}

	private void printBackwordAll() {
		// TODO Auto-generated method stub
		Node tmp = tail;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			else {
				System.out.print("  " + tmp.data);
				tmp = tmp.prev;
			}
		}

	}

	private void printAll() {
		// TODO Auto-generated method stub
		Node tmp = head;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			else {
				System.out.print("  " + tmp.data);
				tmp = tmp.next;
			}
		}

	}

	private void addAtFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			Node tmp = head;
			node.next = tmp;
			tmp.prev = node;
			head = node;
		}
		size++;
	}

	private void reverseList() {
		if (head == null)
			return;
		Node tmp = null;
		Node current = head;
		while (current != null) {
			tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			current = current.prev;
		}
		if (tmp != null) {
			head = tmp.prev;
		}
	}

	// Split a doubly linked list (DLL) into 2 DLLs of
	// half sizes
	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);

		// Recur for left and right halves
		node = mergeSort(node);
		second = mergeSort(second);

		// Merge the two sorted halves
		return merge(node, second);
	}

	// Function to merge two linked lists
	Node merge(Node first, Node second) {
		// If first linked list is empty
		if (first == null) {
			return second;
		}

		// If second linked list is empty
		if (second == null) {
			return first;
		}

		// Pick the smaller value
		if (first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.prev = first;
			first.prev = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.prev = second;
			second.prev = null;
			return second;
		}
	}

	public Node FindBeginning() {
		Node n1 = head;
		Node n2 = head;
		// Find meeting point
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
			}
		}
		// Error check - there is no meeting point, and therefore no loop
		if (n2.next == null) {
			return null;
		}

		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start.
		 */
		n1 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		// Now n2 points to the start of the loop.
		return n2;
	}

	public void insertionSort() {

		Node current = head;
		while (current != null) {
			Node next = current.next;
			sortedInsert(current);
			current = next;
		}
		// Update head_ref to point to sorted linked list
		head = sorted;
	}

	void sortedInsert(Node newnode) {
		/* Special case for the head end */
		if (sorted == null || sorted.data >= newnode.data) {
			newnode.next = sorted;
			sorted = newnode;
		} else {
			Node current = sorted;
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.data < newnode.data) {
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedListDemo demo = new DoublyLinkedListDemo();
		demo.addAtFirst(30);
		demo.addAtFirst(20);
		demo.addAtFirst(10);
		demo.printAll();
		demo.printBackwordAll();
		demo.addAtLast(40);
		demo.addAtLast(50);
		demo.addAtLast(60);
		demo.addAtLast(40);
		demo.addAtLast(50);
		demo.addAtLast(60);
		demo.addAtLast(10);
		demo.printAll();
		demo.insertionSort();
		demo.printAll();
		Node node3 = demo.mergeSort(demo.head);
		demo.printAll12(node3);
		//// Node node = demo.FindBeginning();
		//// System.out.println(node);

		// demo.SortOnDoublyLinkedList();
		/// demo.reverseList();
		demo.printAll();
		demo.deleteNode1(demo.head.next.next.next.next); // delete node 4
		/// demo.deleteNode(40);
		demo.printAll();
		Node node1 = demo.findNthToLastUp(2);
		System.out.println();
		/// System.out.println(node1.data);
		Node node2 = demo.findNthToLast(2);
		System.out.println();
		System.out.println(node2.data);
		demo.removeDuplicate();
		demo.printAll();
		demo.printBackwordAll();

		demo.addAtPosition(44, 4);
		demo.printAll();
		demo.printBackwordAll();
		demo.addAtPosition(54, 5);
		demo.printAll();
		demo.addAtPosition(64, 6);
		demo.printAll();
		demo.printBackwordAll();

		demo.removeAtFirst();
		demo.removeAtFirst();
		demo.printAll();
		demo.printBackwordAll();

		demo.removeAtLast();

		demo.removeAtLast();
		demo.printAll();
		demo.printBackwordAll();

		demo.removeAtPosition(3);
		demo.printAll();
		demo.printBackwordAll();

		demo.removeAtPosition(5);
		demo.printAll();
		demo.printBackwordAll();
	}

	private void printAll12(Node node3) {
		// TODO Auto-generated method stub
		Node tmp = node3;
		System.out.println();
		while (true) {
			if (tmp == null)
				return;
			else {
				System.out.print("  " + tmp.data);
				tmp = tmp.next;
			}
		}

	}

}
