package hw3.B03_13;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Кількість квартир: ");
        int n = in.nextInt();
        in.nextLine();

        House[] arr = new House[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nКвартира " + (i + 1));

            System.out.print("Номер квартири: ");
            int number = in.nextInt();

            System.out.print("Площа: ");
            double area = in.nextDouble();
            in.nextLine();

            System.out.print("Адреса: ");
            String address = in.nextLine();

            System.out.print("Термін експлуатації (роки): ");
            int serviceLife = in.nextInt();
            in.nextLine();

            arr[i] = new House(number, area, address, serviceLife);
        }

        // a) квартири з великим терміном експлуатації
        System.out.print("\nМінімальний термін експлуатації: ");
        int minYears = in.nextInt();
        House[] over = House.filterByServiceLife(arr, minYears);
        System.out.println("Квартири з терміном > " + minYears + ":");
        for (House h : over) System.out.println("  " + h);

        in.nextLine();


        // b) сортування за площею для заданої адреси
        System.out.print("\nВведіть адресу для пошуку: ");
        String address = in.nextLine();
        House[] sortedAtAddr = House.sortedByAreaAtAddress(arr, address);
        System.out.println("Квартири за адресою \"" + address + "\" (за площею):");
        for (House h : sortedAtAddr) System.out.println("  " + h);
    }
}
