package demo;

public class QueueLinkedlist {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	private Node front;
	private Node rear;
	
	void enqueue(int value) {
		Node newNode= new Node(value);
		if(rear == null) {
			front = rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = newNode;
	}
	int dequeue() {
		if(front==null) {
			return -1;
		}
		int value=front.data;
		if(front==null) {
			rear=null;
		}
		return value;

	}
	int peek() {
	if(front==null) {
		return -1;
	}
	return front.data;
	}
	public static void main(String[] args) {
		QueueLinkedlist queue=new QueueLinkedlist();
	    queue.enqueue(10);
	    queue.enqueue(20);
	    queue.enqueue(30);
	    queue.enqueue(40);
	    System.out.println(queue.dequeue());
	    System.out.println(queue.peek());


	}
}