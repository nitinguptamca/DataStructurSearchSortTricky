package linkedListAndAllConcept;


public class DoublyLinkedListDemo {
	private Node head, tail;
	private int size;

	private class Node {
		protected Node next, prev;
		protected int data;

		public Node(Node next, Node prev, int data) {
			super();
			this.next = next;
			this.prev = prev;
			this.data = data;
		}
	}

	private void delete() {
		Node node=new Node(null, null, 40);
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}

	}
	
	private void addAtFirst(int data) {
		Node node = new Node(null, null, data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node tmp = head;
			node.next = tmp;
			tmp.prev = node;
			head = node;
		}
		size++;
	}

	private void addAtLast(int data) {
		Node node = new Node(null, null, data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node tmp = tail;
			tmp.next = node;
			node.prev = tmp;
			tail = node;
		}
		size++;
	}

	private void addAtPosition(int data, int position) {
		Node node = new Node(null, null, data);
		if (position == 1) {
			addAtFirst(data);
		} else if (size + 1 == position) {
			addAtLast(data);
		} else {
			Node tmp = head;
			int pos = position - 1;
			for (int i = 1; i < size; i++) {
				if (i == pos) {
					node.next = tmp.next;
					tmp.next.prev = node;
					tmp.next = node;
					node.prev = tmp;
					size++;
					return;
				} else {
					tmp = tmp.next;
				}

			}
		}

	}

	private void removeAtFirst() {
		if (head == null) {
			head = null;
			tail = null;
		} else {
			Node tmp = head.next;
			head = tmp;
			head.prev = null;
		}
		size--;

	}

	private void removeAtLast() {
		if (head == null) {
			head = null;
			tail = null;
		} else {
			Node tmp = tail.prev;
			tail = tmp;
			tail.next = null;
		}
		size--;
	}

	private void removeAtPosition(int position) {
		if (position == 1) {
		removeAtFirst();
		} else if (size  == position) {
			removeAtLast();
		} else {
			Node tmp = head;
			int pos = position - 1;
			for (int i = 1; i < size; i++) {
				if (i == pos) {
					Node prev1=tmp.prev;
					Node next1=tmp.next;
					prev1.next=next1;
					next1.prev=prev1;
					
					size++;
					return;
				} else {
					tmp = tmp.next;
				}

			}
		}

	}

	private void printAllForword() {
		Node tmp = head;
		System.out.println();
		while (true) {
			if (tmp == null) {
				return;
			} else {
				System.out.print("   " + tmp.data);
				tmp = tmp.next;
			}
		}

	}

	private void printAllBackword() {
		Node tmp = tail;
		System.out.println();
		while (true) {
			if (tmp == null) {
				return;
			} else {
				System.out.print("   " + tmp.data);
				tmp = tmp.prev;
			}
		}

	}

	/* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    
	public static void main(String[] args) {
		DoublyLinkedListDemo demo = new DoublyLinkedListDemo();
		demo.addAtFirst(30);
		demo.addAtFirst(20);
		demo.addAtFirst(10);

		demo.addAtLast(40);
		demo.addAtLast(50);
		demo.addAtLast(60);

		demo.addAtPosition(44, 4);
		demo.addAtPosition(54, 5);
		demo.addAtPosition(74, 7);
		demo.delete();
		
		demo.printAllForword();
		demo.printAllBackword();

		/// demo.removeAtFirst();
		/// demo.removeAtFirst();
		//demo.removeAtLast();
		//demo.removeAtLast();
		demo.removeAtPosition(5);
		demo.removeAtPosition(3);
		demo.printAllForword();
		demo.printAllBackword();
		demo.head = demo.reverse(demo.head);
		demo.printAllForword();
		demo.printAllBackword();

	}

}
