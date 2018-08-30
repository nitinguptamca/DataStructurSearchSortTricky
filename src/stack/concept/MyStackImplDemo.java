package stack.concept;

public class MyStackImplDemo {
	int stackSize;
	int[] stackArray;
	int top;

	public MyStackImplDemo(int stackSize) {
		super();
		this.stackSize = stackSize;
		this.stackArray = new int[stackSize];
		this.top = -1;
	}

	public void push(int data) {
		if (isStackFull()) {
			System.out.println("full");
		} else {
			this.stackArray[++top] = data;
		}
	}

	public int pop() {
		if (this.isStackEmpty()) {
			System.out.println("Stack is empty. Can not remove element.");
		}
		int entry = this.stackArray[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
