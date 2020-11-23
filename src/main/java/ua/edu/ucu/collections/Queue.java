package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    public ImmutableLinkedList queue;

    public Queue() {
        this.queue = new ImmutableLinkedList();
    }

    public Queue(Object[] objects) {
        this.queue = new ImmutableLinkedList(objects);
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object ans = this.peek();
        queue = queue.removeFirst();
        return ans;
    }

    public void enqueue(Object e) {
        queue = queue.add(e);
    }

    public String toString() {
        return queue.toString();
    }

}
