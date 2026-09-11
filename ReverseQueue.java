package demo;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseQueue {
 static void reverse(Queue<Integer> queue) {
  Stack <Integer> stack = new Stack<>();
  while(!queue.isEmpty()) {
   stack.push(queue.remove());
  }
  while(!stack.isEmpty()) {
   queue.add(stack.pop());
  } 
 }
 public static void main(String[] args) {
  Queue<Integer> queue = new LinkedList<>();
  queue.add(10);
  queue.add(20);
  queue.add(30);
  queue.add(40);
  reverse(queue);
  System.out.println(queue);
}
}