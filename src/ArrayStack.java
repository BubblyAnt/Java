import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] stack;
    private int top = -1;


    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void clear() {
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    public void push(E e) {
        if (top == stack.length - 1) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        top++;
        stack[top] = e;
    }

    public E pop() {
        if (top == -1) throw new EmptyStackException();
        return stack[top--];
    }

    public E peek() {
        if (top == -1) throw new EmptyStackException();
        return stack[top];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i] + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> myStack = new ArrayStack<Integer>();
        myStack.push(123);
        myStack.push(345);
        myStack.push(null);
        myStack.push(567);
        myStack.push(null);
        myStack.push(789);

        System.out.println(myStack);
        System.out.println("is empty - " + myStack.isEmpty());
        System.out.println("peek the last element - " + myStack.peek());
        System.out.println("pop the last element - " + myStack.pop());
        System.out.println("size - " + myStack.size());
        System.out.println(myStack);
        System.out.println("clear");
        myStack.clear();
        System.out.println("size - " + myStack.size());
        System.out.println("is empty - " + myStack.isEmpty());
    }

}
