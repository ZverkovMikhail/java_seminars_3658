import java.util.Arrays;

/**
 * Реализовать стэк с помощью массива.
 * Нужно реализовать методы:
 * size(), empty(), push(), peek(), pop().
 */
public class Task4 {
    public static void run() {
        MyStack stack = new MyStack();

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

}

class MyStack {
    int[] stack;
    int cursor;
    public MyStack() {
        stack = new int[10];
        cursor = -1;
    }

    public int size(int[] stack) {
        return cursor+1;
    }

    public boolean empty() {
        return (cursor == -1);
    }

    public int push(int val) {
        cursor++;
        if (stack.length <= cursor) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[cursor] = val;
        return stack[cursor];
    }

    public int peek() {
        return stack[cursor];
    }

    public int pop() {
        int temp = stack[cursor];
        cursor--;
        return temp;
    }
}

