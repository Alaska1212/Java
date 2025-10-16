package hw5;
import java.io.*;
import java.util.*;

//Дано файл, який містить відомості про кілька автомобілів. Відомості про
//автомобіль складаються з його марки, номера та прізвища власника. Скласти
//процедури знаходження:
//a) власників автомобілів заданої марки;
//b) кількості автомобілів кожної марки (пара: марка, кількість).
//Для кожного пункту, результат спрямувати в новий текстовий файл.

public class B05_05 {
    static class Car {
        String brand;
        String number;
        String owner;

        Car(String brand, String number, String owner) {
            this.brand = brand;
            this.number = number;
            this.owner = owner;
        }
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\polin\\IdeaProjects\\Java\\src\\hw5\\cars.txt";
        List<Car> cars = readCars(inputFile);       // зчитування даних з файлу

        // a) знайти власників авто заданої марки
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть марку автомобіля: ");
        String brandToFind = sc.nextLine();
        findOwnersByBrand(cars, brandToFind, "owners_" + brandToFind + ".txt");

        // b) порахувати кількість авто кожної марки
        countCarsByBrand(cars, "brands_count.txt");

        System.out.println("Результати записано у файли:");
        System.out.println("- owners_" + brandToFind + ".txt");
        System.out.println("- brands_count.txt");
    }

    // зчитування автомобілів з файлу
    public static List<Car> readCars(String filename) throws IOException {
        List<Car> cars = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Очікуваний формат: Марка Номер Прізвище
            String[] parts = line.split("\\s+");
            if (parts.length >= 3) {
                String brand = parts[0];
                String number = parts[1];
                String owner = parts[2];
                cars.add(new Car(brand, number, owner));
            }
        }

        br.close();
        return cars;
    }
    // a) Знайти власників заданої марки
    public static void findOwnersByBrand(List<Car> cars, String brand, String outputFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        bw.write("Власники автомобілів марки " + brand + ":\n");

        int count = 0;
        for (Car c : cars) {
            if (c.brand.equalsIgnoreCase(brand)) {
                bw.write(c.owner + " (" + c.number + ")\n");
                count++;
            }
        }

        if (count == 0) bw.write("Немає автомобілів цієї марки.\n");
        bw.close();
    }

    // b) Порахувати кількість авто кожної марки
    public static void countCarsByBrand(List<Car> cars, String outputFile) throws IOException {
        Map<String, Integer> brandCount = new HashMap<>();

        for (Car c : cars) {
            brandCount.put(c.brand, brandCount.getOrDefault(c.brand, 0) + 1);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        bw.write("Кількість автомобілів кожної марки:\n");
        for (String brand : brandCount.keySet()) {
            bw.write(brand + " - " + brandCount.get(brand) + "\n");
        }
        bw.close();
    }
}
