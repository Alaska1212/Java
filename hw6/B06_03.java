package hw6;

public class B06_03 {
    public static void main(String[] args) {
        String ex1 = "+2 - 57*33 + 25/ - 4";
        String ex2 = "+2 - 57*33 + 25/ - ";

        String regex = "\\s*[+-]?\\s*\\d+(\\s*[+\\-*/]\\s*[+-]?\\s*\\d+)*\\s*";

        System.out.println(ex1);
        if (ex1.matches(regex)) {
            System.out.println("Вираз синтаксично правильний.");
        } else {
            System.out.println("Вираз містить помилку.");
        }

        System.out.println(ex2);
        if (ex2.matches(regex)) {
            System.out.println("Вираз синтаксично правильний.");
        } else {
            System.out.println("Вираз містить помилку.");
        }
    }


}
