package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    public ImmutableLinkedList stack;
    public Stack(){
        this.stack = new ImmutableLinkedList();
    }
    public Stack(Object[] objects){
        this.stack = new ImmutableLinkedList(objects);
    }
    public Object peek(){
        return stack.getLast();
    }
    public Object pop(){
        Object res = this.peek();
        stack = stack.removeLast();
        return res;
    }
    public void push(Object e){
        stack = stack.addLast(e);
    }
    public String toString(){
        return stack.toString();
    }

}
