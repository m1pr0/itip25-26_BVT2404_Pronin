public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) {
            data[size] = element;
            size++;
        } else {
            throw new RuntimeException("Стек переполнен");
        }
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Стек пуст");
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Стек пуст");
        }
        return data[size - 1];
    }
}

// Тестовый класс
class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());

        stack.push(4);
        System.out.println("pop: " + stack.pop());
    }
}