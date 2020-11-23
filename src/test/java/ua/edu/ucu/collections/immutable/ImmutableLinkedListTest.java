package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList ordinaryList;
    @Before
    public void SetUp(){
        ordinaryList = new ImmutableLinkedList(new Object[] {5,10,15,20});
    }
    
    @Test
    public void testAdd() {
        ImmutableLinkedList newlist = ordinaryList.add(25);
        assertEquals(newlist.toString(), "[5, 10, 15, 20, 25]");
    }
    @Test
    public void testAddatIndex() {
        ImmutableLinkedList newlist = ordinaryList.add(2, 25);
        assertEquals(newlist.toString(), "[5, 10, 25, 15, 20]");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddatWrongIndex(){
        ImmutableLinkedList newlist = ordinaryList.add(25,2);
    }

    @Test
    public void testAddAll(){
        ImmutableLinkedList newlist = ordinaryList.addAll(new Object[] {300, 500});
        assertEquals(newlist.toString(), "[5, 10, 15, 20, 300, 500]");
    }
    @Test
    public void testAddAllatIndex(){
        ImmutableLinkedList newlist = ordinaryList.addAll(2, new Object[] {300, 500});
        assertEquals(newlist.toString(), "[5, 10, 300, 500, 15, 20]");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllatWrongIndex() {
        ImmutableLinkedList newlist = ordinaryList.addAll(200, new Object[]{300, 500});
    }
    @Test
    public void testGet(){
        Object value = ordinaryList.get(2);
        assertEquals(value, 15);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrong(){
        Object value = ordinaryList.get(300);
    }
    @Test
    public void testRemove(){
        ImmutableLinkedList newlist = ordinaryList.remove(1);
        assertEquals(newlist.toString(), "[5, 15, 20]");
    }
    @Test
    public void testRemoveZeroIndex(){
        ImmutableLinkedList newlist = ordinaryList.remove(0);
        assertEquals(newlist.toString(), "[10, 15, 20]");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex(){
        ImmutableLinkedList newlist = ordinaryList.remove(200);
    }
    @Test
    public void testSet(){
        ImmutableLinkedList newlist = ordinaryList.set(3, 50);
        assertEquals(newlist.toString(), "[5, 10, 15, 50]");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex(){
        ImmutableLinkedList newlist = ordinaryList.set(5, 50);
    }
    @Test
    public void testIndexof(){
        int index = ordinaryList.indexOf(5);
        assertEquals(index, 0);
    }
    @Test
    public void testIndexofFail(){
        int index = ordinaryList.indexOf(25);
        assertEquals(index, -1);
    }
    @Test
    public void testSize(){
        int size = ordinaryList.size();
        assertEquals(size, 4);
    }
    @Test
    public void testClear(){
        ImmutableLinkedList newlist = ordinaryList.clear();
        assertEquals(newlist.size(), 0);
    }
    @Test
    public void testIsEmpty(){
        assertFalse(ordinaryList.isEmpty());
    }
    @Test
    public void testAddFirst(){
        ImmutableLinkedList newlist = ordinaryList.addFirst(1);
        assertEquals(newlist.toString(), "[1, 5, 10, 15, 20]");
    }
    @Test
    public void testAddLast(){
        ImmutableLinkedList newlist = ordinaryList.addLast(1);
        assertEquals(newlist.toString(), "[5, 10, 15, 20, 1]");
    }
    @Test
    public void testGetFirst(){
        Object value = ordinaryList.getFirst();
        assertEquals(value, 5);
    }
    @Test
    public void testGetLast(){
        Object value = ordinaryList.getLast();
        assertEquals(value, 20);
    }
    @Test
    public void testRemoveFirst(){
        ImmutableLinkedList newlist = ordinaryList.removeFirst();
        assertEquals(newlist.toString(), "[10, 15, 20]");
    }
    @Test
    public void testRemoveLast(){
        ImmutableLinkedList newlist = ordinaryList.removeLast();
        assertEquals(newlist.toString(), "[5, 10, 15]");
    }
}
