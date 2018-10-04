package linkedListAndAllConcept;

public class SingleLinkedListDemo {
	protected Node head, tail;
	int size;

	private class Node {
		protected int data;
		protected Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		SingleLinkedListDemo demo = new SingleLinkedListDemo();
		demo.addAtFirst(30);
		demo.addAtFirst(20);
		demo.addAtFirst(10);
		demo.addAtFirst(10);
		demo.printAll();

		demo.addAtLast(40);
		demo.addAtLast(50);
		demo.addAtLast(60);
		demo.addAtLast(50);
		demo.addAtLast(60);
		demo.addAtLast(60);
		demo.addAtLast(70);
		demo.addAtLast(80);
		demo.addAtLast(80);
		demo.addAtLast(90);
		demo.printAll();

		demo.addAtPosition(44, 4);
		demo.addAtPosition(54, 5);
		demo.addAtPosition(64, 6);
		demo.printAll();

		// demo.removeAtFirst();
		// demo.printAll();
		// demo.removeAtFirst();
		// demo.printAll();

		/// demo.removeAtLast();
		/// demo.printAll();
		/// demo.removeAtLast();
		/// demo.printAll();

		// demo.removeAtPosition(3);
		/// demo.printAll();

		/// demo.removeAtPosition(5);
		// demo.printAll();

		/// demo.removeAtNthFromLast(3);
		/// demo.removeAtNthFromLast(25);
		// demo.removeAtNthFromLast(14);
		/// demo.printAll();

		/// demo.removeAtNthFromStart(3);
		/// demo.deleteNode(20);
		/// demo.printAll();

		// demo.deleteNode(80);
		/// demo.printAll();
		/// demo.deleteNode(demo.head.next.next.next);
		/// demo.printAll();
		/// demo.deleteNode(demo.head.next.next.next);
		/// demo.printAll();
		// demo.removeDuplicate();
		// demo.printAll();
		/// demo.reverse();
		/// demo.printAll();
		// demo.BubbleSort();
		// demo.printAll();

		///demo.quickSort(demo.head);
		demo.mergeSort(demo.head);
		demo.printAll();
	}

	Node sortedMerge(Node a, Node b) {
		Node result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	Node mergeSort(Node h) {
		if (h == null || h.next == null)	return h;
		Node middle = getMiddle(h);
		Node nextofmiddle = middle.next;
		middle.next = null;
		Node left = mergeSort(h);
		Node right = mergeSort(nextofmiddle);
		Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	// Utility function to get the middle of the linked list
	Node getMiddle(Node h) {
		if (h == null)	return h;
		Node fastptr = h.next;
		Node slowptr = h;

		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}

	Node lastNode(Node node) {
		while (node.next != null)
			node = node.next;
		return node;
	}

	/* A recursive implementation of quicksort for linked list */
	void _quickSort(Node l, Node h) {
		if (h != null && l != h && l != h.next) {
			Node temp = partition(l, h);
			_quickSort(l, temp);
			_quickSort(temp.next, h);
		}
	}

	public static Node partition(Node first, Node last) {

		Node p = first;
		Node ptr = p.next;

		while (ptr != null) {
			if (ptr.data < p.data) {
				int pivot = p.data;
				p.data = ptr.data;
				ptr.data = p.next.data;
				p.next.data = pivot;
				p = p.next;
			}
			ptr = ptr.next;
		}
		return p;
	}

	private void quickSort(Node first) {
		// Find last node
		Node last = lastNode(first);

		// Call the recursive QuickSort
		_quickSort(first, last);

	}

	public void reverse() {
		Node tmp = head;
		Node previous = null, 
		current = null;
		while (tmp != null) {
			current = tmp;
			tmp = tmp.next;
			// reverse the link
			current.next = previous;
			previous = current;
			head = current;
		}
	}

	private void removeDuplicate() {
		Node tmp = head;
		while (tmp != null && tmp.next != null) {
			Node current = tmp;
			while (current.next != null) {
				if (tmp.data == current.next.data) {
					current.next = current.next.next;
					size--;
				}
				current = current.next;
			}
			tmp = tmp.next;
		}
	}

	private void deleteNode(Node node) {
		// node.data = node.next.data;
		node.next = node.next.next;
		size--;
	}

	void deleteNode(int data) {
		if (head == null)
			return;
		Node tmp = head.next;
		Node s = head;
		while (true) {
			if (tmp == null)
				return;
			if (tmp.data == data) {
				Node ptr = s.next.next;
				s.next = ptr;
				size--;
				return;
			}
			tmp = tmp.next;
			s = s.next;
		}
	}

	private void removeAtNthFromStart(int position) {
		Node s = head;
		for (int i = 1; i <= position - 1; i++) {
			if (s == null)
				return;
			s = s.next;
		}
		System.out.println();
		System.out.println(position + " " + s.data);
	}

	private void removeAtNthFromLast(int position) {
		if (head == null)
			return;
		Node t = head;
		Node s = head;
		int len = 0;
		while (t != null) {
			t = t.next;
			len++;
		}
		if (position > len)
			return;
		for (int i = 1; i <= len - position; i++) {
			if (s == null)
				return;
			s = s.next;
		}
		System.out.println();
		System.out.println(position + " " + s.data);
	}

	private void removeAtPosition(int position) {
		if (position == 1)
			removeAtFirst();
		else if (position == size)
			removeAtLast();
		else {
			Node tmp = head;
			int pos = position - 1;
			for (int i = 1; i < size; i++) {
				if (i == pos) {
					Node ptr = tmp.next.next;
					tmp.next = ptr;
					size--;
					return;
				} else {
					tmp = tmp.next;
				}
			}
		}
	}

	private void removeAtLast() {
		if (head == null)
			return;
		Node s = head;
		Node t = head;
		while (s.next != null) {
			t = s;
			s = s.next;
		}
		t.next = null;
		tail = t;
		tail.next = null;
		size--;
	}

	private void removeAtFirst() {
		if (head == null)
			return;
		Node tmp = head.next;
		head = tmp;
		size--;
	}

	private void addAtPosition(int data, int position) {
		if (position == 1)
			addAtFirst(data);
		else if (position == size + 1)
			addAtLast(data);
		else {
			Node tmp = head;
			int pos = position - 1;
			Node node = new Node(data);
			for (int i = 1; i <= size; i++) {
				if (pos == i) {
					Node ptr = tmp.next;
					tmp.next = node;
					node.next = ptr;
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
			tail = node;
		} else {
			Node tmp = tail;
			tmp.next = node;
			tail = node;
		}
		size++;
		return;
	}

	public void BubbleSort() {
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				Node currentNode = head;
				Node next = head.next;
				for (int j = 0; j < size - 1; j++) {
					if (currentNode.data > next.data) {
						int temp = currentNode.data;
						currentNode.data = next.data;
						next.data = temp;
					}
					currentNode = next;
					next = next.next;
				}
			}
		}
	}

	private void printAll() {
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
			tail = node;
		} else {
			Node tmp = head;
			node.next = tmp;
			head = node;
		}
		size++;
		return;
	}

}
