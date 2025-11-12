package hw7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_01 {
    // створює бінарний файл f із заданими дійсними числами
    public static void createFileF(String fileName, double[] numbers) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (double num : numbers) {
                dos.writeDouble(num);
            }
            System.out.println("файл " + fileName + " успішно створено.");
        } catch (IOException e) {
            System.out.println("помилка запису у файл: " + e.getMessage());
        }
    }

    // зчитує масив дійсних чисел з бінарного файлу
    public static List<Double> readFile(String fileName) {
        List<Double> numbers = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                numbers.add(dis.readDouble());
            }
        } catch (IOException e) {
            System.out.println("помилка зчитування файлу: " + e.getMessage());
        }
        return numbers;
    }

    // створює файл g з чисел, що більші за a
    public static void createFileG(String fileF, String fileG, double a) {
        List<Double> numbers = readFile(fileF);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileG))) {
            for (double num : numbers) {
                if (num > a) {
                    dos.writeDouble(num);
                }
            }
            System.out.println("файл " + fileG + " створено. містить числа > " + a);
        } catch (IOException e) {
            System.out.println("помилка створення файлу g: " + e.getMessage());
        }
    }

    // головна функція
    public static void main(String[] args) {
        String fileF = "F.bin";
        String fileG = "G.bin";

        // початкові дані
        double[] numbers = {2.5, -1.0, 4.2, 3.3, 7.8, 0.5};
        double a = 3.0;

        // створюємо файл f
        createFileF(fileF, numbers);

        // створюємо файл g
        createFileG(fileF, fileG, a);

        // виводимо вміст обох файлів
        System.out.println("\nвміст файлу f:");
        System.out.println(readFile(fileF));

        System.out.println("\nвміст файлу g (числа > " + a + "):");
        System.out.println(readFile(fileG));
    }
}
