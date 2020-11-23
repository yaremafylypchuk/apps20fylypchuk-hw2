package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private Object[] array;

    public ImmutableArrayList() {
        this.array = new Object[0];
    }

    public ImmutableArrayList(Object[] objects) {
        this.array = new Object[objects.length];
        System.arraycopy(objects, 0, this.array, 0, objects.length);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(this.size(), e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        CheckBounds(index);
        Object[] newArr = new Object[this.size() + 1];
        System.arraycopy(this.array, 0, newArr, 0, index);
        newArr[index] = e;
        System.arraycopy(this.array, index, newArr, index + 1,
                this.size() - index);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(this.size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        CheckBounds(index);
        Object[] newArr = new Object[this.size() + c.length];
        System.arraycopy(this.array, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(this.array, index, newArr, index + c.length,
                this.size() - index);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        CheckBounds(index);
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        CheckBounds(index);
        Object[] newArr = new Object[this.size() - 1];
        System.arraycopy(this.array, 0, newArr, 0, index);
        System.arraycopy(this.array, index + 1, newArr, index,
                this.size() - index - 1);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        CheckBounds(index);
        Object[] newArr = new Object[this.size()];
        System.arraycopy(this.array, 0, newArr, 0, this.size());
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    private void CheckBounds(int index) {
        if (this.size() < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        return Arrays.toString(toArray());
    }
}
