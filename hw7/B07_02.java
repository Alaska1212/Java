package hw7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// клас іграшка
class Toy implements Serializable {
    private String name;
    private double price;
    private int minAge;
    private int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public boolean isForAge(int age) {
        return age >= minAge && age <= maxAge;
    }

    @Override
    public String toString() {
        return name + " (" + price + " грн, " + minAge + "-" + maxAge + " р.)";
    }
}

public class B07_02 {

    // створює файл з іграшками
    public static void createToyFile(String fileName, List<Toy> toys) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(toys);
            System.out.println("файл " + fileName + " створено.");
        } catch (IOException e) {
            System.out.println("помилка запису файлу: " + e.getMessage());
        }
    }

    // зчитує іграшки з файлу
    @SuppressWarnings("unchecked")
    public static List<Toy> readToyFile(String fileName) {
        List<Toy> toys = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            toys = (List<Toy>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("помилка зчитування файлу: " + e.getMessage());
        }
        return toys;
    }

    // створює новий файл з іграшками для дитини заданого віку
    public static void createFilteredFile(String inputFile, String outputFile, int childAge) {
        List<Toy> toys = readToyFile(inputFile);
        List<Toy> filtered = new ArrayList<>();

        for (Toy toy : toys) {
            if (toy.isForAge(childAge)) {
                filtered.add(toy);
            }
        }

        createToyFile(outputFile, filtered);
        System.out.println("створено файл " + outputFile + " з іграшками для віку " + childAge + " років.");
    }

    // головна функція
    public static void main(String[] args) {
        String fileF = "toys.dat";
        String fileG = "filtered_toys.dat";

        // створюємо список іграшок
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("м'яч", 150.0, 3, 10));
        toys.add(new Toy("лялька", 250.0, 4, 8));
        toys.add(new Toy("конструктор", 400.0, 6, 12));
        toys.add(new Toy("плюшевий ведмедик", 180.0, 1, 6));
        toys.add(new Toy("настільна гра", 300.0, 7, 14));

        // створюємо файл з іграшками
        createToyFile(fileF, toys);

        // зчитуємо всі іграшки
        System.out.println("\nвсі іграшки з файлу:");
        for (Toy t : readToyFile(fileF)) {
            System.out.println(t);
        }

        // створюємо файл з іграшками для дитини певного віку
        int childAge = 6;
        createFilteredFile(fileF, fileG, childAge);

        // показуємо відфільтровані іграшки
        System.out.println("\nіграшки для віку " + childAge + ":");
        for (Toy t : readToyFile(fileG)) {
            System.out.println(t);
        }
    }
}
