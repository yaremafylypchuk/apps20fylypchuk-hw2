package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList arrayList;
    private ImmutableArrayList emptyList;

    @Before
    public void SetUp() {
        arrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
        emptyList = new ImmutableArrayList();
    }

    @Test
    public void testAdd() {
        ImmutableArrayList res = arrayList.add(6);
        assertEquals(res.toString(), "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList res = arrayList.add(1, 10);
        assertEquals(res.toString(), "[1, 10, 2, 3, 4, 5]");
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList res = arrayList.addAll(new Object[]{10, 50});
        assertEquals(res.toString(), "[1, 2, 3, 4, 5, 10, 50]");
    }

    @Test
    public void testAddAllIndex() {
        ImmutableArrayList res = arrayList.addAll(2, new Object[]{77, 69});
        assertEquals(res.toString(), "[1, 2, 77, 69, 3, 4, 5]");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWrongIndex() {
        arrayList.add(1000, 1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWrongIndex() {
        arrayList.addAll(1000, new Object[]{200, 10});
    }

    @Test
    public void testGet() {
        Object res = arrayList.get(2);
        assertEquals(res, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        Object res = arrayList.get(1000);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList res = arrayList.remove(2);
        assertEquals(res.toString(), "[1, 2, 4, 5]");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        ImmutableArrayList res = arrayList.remove(10);
    }

    @Test
    public void testSet() {
        ImmutableArrayList res = arrayList.set(1, 100);
        assertEquals(res.toString(), "[1, 100, 3, 4, 5]");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        ImmutableArrayList res = arrayList.set(10, 1000);
    }

    @Test
    public void testIndexOf() {
        assertEquals(arrayList.indexOf(1), 0);
    }

    @Test
    public void testWrongIndexOf() {
        assertEquals(arrayList.indexOf(100), -1);
    }

    @Test
    public void testCLear() {
        ImmutableArrayList res = arrayList.clear();
        assertEquals(res.size(), 0);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyEmpty() {
        assertTrue(emptyList.isEmpty());
    }

}
