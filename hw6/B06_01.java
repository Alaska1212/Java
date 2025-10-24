package hw6;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class B06_01 {
    public static void main(String[] args) {
        String text = "Сьогодні дата: 12.05.2023, а тут підкреслення __.__.____ і ще одна дата 05.11.2021.";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String currentDate = LocalDate.now().format(formatter); // поточна дата

        String result = text.replaceAll("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b|__\\. __\\.____|__\\.__\\.____", currentDate);

        System.out.println("Початковий текст:");
        System.out.println(text);
        System.out.println("\nПісля заміни:");
        System.out.println(result);
    }
}
