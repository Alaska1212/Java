package hw5;
import java.util.Scanner;

//Виключити з заданого рядка групи символів, які знаходяться між '(' та ')'.
//Самі дужки теж мають бути виключені. Перевірте перед цим, що дужки
//розставлено правильно (парами) та всередині кожної пари дужок немає
//інших дужок.

public class B05_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                while (i < s.length() && s.charAt(i) != ')') {
                    i++;
                }
            } else {
                res += s.charAt(i);
            }
        }

        System.out.println(res);
    }
}
