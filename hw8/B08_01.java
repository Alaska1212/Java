package hw8;

// стек як рекурсивна структура даних, що приймає об’єкти довільного типу

public class B08_01<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> top; // верхівка стеку

    // додає елемент у стек (push)
    public void push(T value) {
        top = new Node<>(value, top);
    }

    // видаляє та повертає елемент з вершини стеку (pop)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("стек порожній");
        }
        T value = top.value;
        top = top.next;
        return value;
    }

    // повертає елемент без видалення (peek)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("стек порожній");
        }
        return top.value;
    }

    // перевіряє, чи стек порожній
    public boolean isEmpty() {
        return top == null;
    }

    // рекурсивний метод для виводу стеку
    public void printRecursive() {
        printRecursive(top);
    }

    private void printRecursive(Node<T> node) {
        if (node == null) return;
        System.out.println(node.value);
        printRecursive(node.next);
    }

    public static void main(String[] args) {
        B08_01<Object> stack = new B08_01<>();

        // додаємо елементи різних типів
        stack.push("текст");
        stack.push(42);
        stack.push(3.14);
        stack.push(true);

        System.out.println("вміст стеку (рекурсивно):");
        stack.printRecursive();

        System.out.println("\nверхівка стеку: " + stack.peek());

        System.out.println("\nвидаляємо елементи:");
        while (!stack.isEmpty()) {
            System.out.println("pop -> " + stack.pop());
        }
    }
}

