package demo;

class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    CircularQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue Full");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }
    int dequeue() {
    	if(size==0) {
    		return -1;
    	}
    	int value=queue[front];
    	front =(front+1)%queue.length;
    	size--;
    	return value;
    }
    public static void main(String[] args) {
		CircularQueue queue=new CircularQueue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue());
		queue.enqueue(40);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}