package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;
    private Queue emptyQueue;

    @Before
    public void SetUp() {
        queue = new Queue(new Object[]{1, 2, 3});
        emptyQueue = new Queue();
    }

    @Test
    public void testPeek() {
        assertEquals(queue.peek(), 1);
    }

    @Test
    public void testDequeue() {
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.toString(), "[2, 3]");
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        assertEquals(queue.toString(), "[1, 2, 3, 10]");
    }

    @Test(expected = NullPointerException.class)
    public void testEmpty() {
        emptyQueue.dequeue();
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyPeek() {
        emptyQueue.peek();
    }

    @Test
    public void testEmptyenqueue() {
        emptyQueue.enqueue(10);
        emptyQueue.enqueue(2);
        assertEquals(emptyQueue.toString(), "[10, 2]");
    }
}
