package hw5;
import java.util.Scanner;

//В заданий рядок входять тільки цифри та літери. Визначити, чи задовольняє
//
//він наступним властивостям:
//a) рядок починається з деякої ненульової цифри, за якою знаходяться тільки
//літери і їх кількість дорівнює числовому значенню цієї цифри;
//b) рядок містить (крім літер) тільки одну цифру, причому її числове
//значення дорівнює довжині рядка;
//c) сума числових значень цифр, які входять в рядок, дорівнює довжині
//рядка.

public class B05_02 {
    // a) рядок починається з ненульової цифри; далі тільки літери, і їх кількість дорівнює цій цифрі
    public static int checkA(String s) {
        if (s == null || s.length() == 0) return 0;
        char first = s.charAt(0);
        if (first < '1' || first > '9') return 0;

        int k = first - '0';
        if (s.length() != 1 + k) return 0;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) return 0;
        }
        return 1;
    }

    // b) рядок містить лише одну цифру, її значення = довжині рядка
    public static int checkB(String s) {
        if (s == null || s.length() == 0) return 0;

        int digitCount = 0;
        int digitValue = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                digitCount++;
                digitValue = c - '0';
                if (digitCount > 1) return 0;
            } else if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return 0;
            }
        }

        if (digitCount == 1 && digitValue == s.length()) return 1;
        return 0;
    }

    // c) сума цифр у рядку = довжині рядка
    public static int checkC(String s) {
        if (s == null) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') sum += (c - '0');
            else if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) return 0;
        }
        if (sum == s.length()) return 1;
        return 0;
    }

    // головний метод
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть рядок:");
        String line = sc.nextLine();

        System.out.println("a) " + (checkA(line) == 1 ? "так" : "ні"));
        System.out.println("b) " + (checkB(line) == 1 ? "так" : "ні"));
        System.out.println("c) " + (checkC(line) == 1 ? "так" : "ні"));
    }

}
