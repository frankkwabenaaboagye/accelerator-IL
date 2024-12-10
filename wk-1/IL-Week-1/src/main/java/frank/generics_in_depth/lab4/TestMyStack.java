package frank.generics_in_depth.lab4;

public class TestMyStack {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.peek()); // 2
        System.out.println("Pop element: " + stack.pop()); // 2
        System.out.println("Stack size: " + stack.getSize()); // 1


        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Top element: " + stringStack.peek()); // World
        System.out.println("Pop element: " + stringStack.pop()); // World
    }
}
