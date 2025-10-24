package hw6;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {
    public static void main(String[] args) {
        String text = "Привіт! Мене звати Анна. Мій номер телефону +380-67-123-45-67. \n" +
                "Якщо не додзвонишся — напиши на пошту anna@example.com або зателефонуй колезі (050)9876543. \n" +
                "Також у нас є офісний номер 0931234567. Гарного дня!\n";

        String regex = "\\+?\\d{1,3}?[-\\s]?\\(?\\d{2,3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Знайдені номери телефонів:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
