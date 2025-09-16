package hw1;
import java.util.Scanner;

public class B01_01 {
    public  static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть ім'я: ");
        String name = in.nextLine();
        System.out.printf("Привіт, %s", name);
        in.close();

    }
}