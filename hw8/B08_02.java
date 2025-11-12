package hw8;
import java.util.Stack;

public class B08_02 {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // якщо це відкрита дужка — кладемо в стек
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // якщо це закрита дужка — перевіряємо відповідність
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false; // немає пари
                char top = stack.pop();

                // перевірка відповідності типів дужок
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // якщо стек порожній — усі дужки мають пари
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "([)]";
        String s3 = "(([]){})";
        String s4 = "([{}]))";

        System.out.println(s1 + " -> " + isBalanced(s1));
        System.out.println(s2 + " -> " + isBalanced(s2));
        System.out.println(s3 + " -> " + isBalanced(s3));
        System.out.println(s4 + " -> " + isBalanced(s4));
    }
}
