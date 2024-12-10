package frank.generics_in_depth.lab4;

import lombok.Data;
import lombok.Getter;

@Getter
public class MyStack<T> {

    private Object[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        stack = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T item) {
        if (size == stack.length) {
            resize();
        }
        stack[size++] = item;
    }

    private void resize() {
        int newCapacity = stack.length * 2;
        Object[] newStack = new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) stack[--size];
        stack[size] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stack[size - 1];
    }
}
