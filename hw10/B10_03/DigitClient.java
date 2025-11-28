package hw10.B10_03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DigitClient {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 5000;

        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Підключено до сервера. Введіть рядок (або 'exit' для виходу):");

            while (true) {
                System.out.print("Ввід: ");
                String line = scanner.nextLine();
                out.println(line);          // відправляємо рядок на сервер

                if ("exit".equalsIgnoreCase(line)) {
                    break;                  // завершуємо роботу клієнта
                }

                String response = in.readLine(); // отримуємо цифри від сервера
                System.out.println("Цифри з рядка: " + response);
            }

            System.out.println("Клієнт завершив роботу");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
