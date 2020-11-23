package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    private Stack emptyStack;

    @Before
    public void SetUp() {
        stack = new Stack(new Object[]{10, 15, 20});
        emptyStack = new Stack();
    }

    @Test
    public void testPeek() {
        assertEquals(stack.peek(), 20);
    }

    @Test
    public void testPop() {
        assertEquals(stack.pop(), 20);
        assertEquals(stack.toString(), "[10, 15]");
    }

    @Test
    public void testPush() {
        stack.push(100);
        stack.push(20);
        assertEquals(stack.toString(), "[10, 15, 20, 100, 20]");
    }

    @Test(expected = NullPointerException.class)
    public void testEmpty() {
        emptyStack.peek();
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyPop() {
        emptyStack.pop();
    }

    @Test
    public void testEmptyPush() {
        emptyStack.push(20);
        emptyStack.push(1);
        assertEquals(emptyStack.toString(), "[20, 1]");
    }
}
