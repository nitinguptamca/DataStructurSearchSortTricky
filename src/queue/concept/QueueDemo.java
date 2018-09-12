package queue.concept;

public class QueueDemo {
	int maxCapcity = 5;
	int size;
	int[] queueArray;
	int front = 0, rear = -1;

	public QueueDemo() {
		queueArray = new int[maxCapcity];
	}

	public static void main(String[] args) {
		QueueDemo demo = new QueueDemo();
		demo.enqueue(10);
		demo.dequeue(10);
	}

	private void enqueue(int item) {
		if(size==maxCapcity) {
			System.out.println("queue full");
		}else {
			rear++;
			if (rear == maxCapcity - 1) {
				rear = 0;
			}
			queueArray[rear] = item;
			
			size++;
		}

	}

	private void dequeue(int i) {
		// TODO Auto-generated method stub

	}

}
