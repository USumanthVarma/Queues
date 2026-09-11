package demo;

class QueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    QueueArray(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue Overflow");
            return;
        }
       rear++;
        queue[rear] = value;
        size++;
    }
      public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return -1; 
        }
        int value = queue[front];
        front++;
        size--;
        return value;
    }
      int peek() {
    	  if(size==0) {
    		  return -1;
    	  }
    	  return queue[front];
      }
      public static void main(String[] args) {
		QueueArray queue=new QueueArray(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());
	}
}
