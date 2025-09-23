package hw2;
import java.util.Scanner;

//Знайдіть кількість значущих (не рівних 0) бітів двобайтового цілого числа.
//
//Вказівка. Використати бітові операції.

public class B02_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input < Short.MIN_VALUE || input > Short.MAX_VALUE) {
            System.out.println("Помилка");
            return;
        }
        int x = input & 0xFFFF;
        int count = 0;
        for (int i = 0; i < 16; i++) {
            count += (x >>> i) & 1;
        }
        System.out.println(count);
    }
}
