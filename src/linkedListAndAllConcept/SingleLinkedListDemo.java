package linkedListAndAllConcept;


public class SingleLinkedListDemo {
	private Node head, tail;
	private int size;

	private class Node {
		protected Node next;
		protected int data;

		public Node(int data) {
			this.next = null;
			this.data = data;
		}
	}

	public void addAtFirst(int data) {
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
	}
	/* Function to print middle of linked list */
    void printMiddle()
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                                slow_ptr.data + "] \n");
        }
    }
	public void addAtLast(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node tmp = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void addAtPosition(int data, int position) {
		Node node = new Node(data);
		int pos = position - 1;
		if (1 == position) {
			addAtFirst(data);
		} else if (size + 1 == position) {
			addAtLast(data);
		} else {
			Node tmp = head;
			for (int i = 1; i <= size; i++) {
				if (i == pos) {
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

	public void removeAtFirst() {
		if (head == null) {
			head = null;
			tail = null;
		} else {
			Node tmp = head.next;
			head = tmp;
		}
		size--;
	}

	public void removeAtLast() {
		if (head == null) {
			head = null;
			tail = null;
		} else {
			Node s = head;
			Node t = head;
			while (s.next != null) {
				t = s;
				s = s.next;
			}
			t.next = null;
			tail = t;
		}
		size--;
	}

	public void removeAtPosition(int position) {
		int pos=position -1;
		if(1==pos) {
			removeAtFirst();
		}else if(size==position) {
			removeAtLast();
		}else {
			Node tmp=head;
			for(int i=1 ;i<size ;i++) {
				if(i==pos) {
					Node ptr=tmp.next.next;
					tmp.next=ptr;
				}else {
					tmp=tmp.next;
				}
			}
		}

	}

	public void printAll() {
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

	public static void main(String[] args) {
		SingleLinkedListDemo demo = new SingleLinkedListDemo();
		demo.addAtFirst(30);
		demo.addAtFirst(20);
		demo.addAtFirst(10);
		//// demo.printAll();

		demo.addAtLast(40);
		demo.addAtLast(50);
		demo.addAtLast(60);
		/// demo.printAll();

		demo.addAtPosition(44, 4);
		// demo.printAll();
		demo.addAtPosition(54, 5);
		/// demo.printAll();
		demo.addAtPosition(64, 6);
		 demo.printAll();
		
		/*demo.removeAtFirst();
		demo.printAll();
		demo.removeAtFirst();
		demo.printAll();

		demo.removeAtLast();
		demo.printAll();
		demo.removeAtLast();
		demo.printAll();*/
		
		demo.removeAtPosition(3);
		demo.printAll();
		
		demo.removeAtPosition(5);
		demo.printAll();

	}

}
