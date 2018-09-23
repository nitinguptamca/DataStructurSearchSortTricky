package doublyLinkedList;
public class DoublyLinkedListDemo {

	protected Node head, tail;
	int size;

	private class Node {
		Node next, prev;
		int data;

		public Node(int data) {
			this.data = data;
			next = prev = null;
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
		demo.printAll();
		demo.printBackwordAll();

		demo.addAtPosition(44, 4);
		demo.printAll();
		demo.printBackwordAll();
		demo.addAtPosition(54, 5);
		/// demo.printAll();
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

	private void removeAtPosition(int position) {
		if (position == 1)
			removeAtFirst();
		else if (position == size)
			removeAtLast();
		else {
			int pos = position ;
			Node tmp = head;
			for (int i = 1; i < size; i++) {
				if (pos == i) {
					Node nextV=tmp.next;
					Node prevV=tmp.prev;
					prevV.next=nextV;
					nextV.prev=prevV;
					size --;
					return ;
				} else {
					tmp=tmp.next;
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

}
