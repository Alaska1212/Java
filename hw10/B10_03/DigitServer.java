package hw10.B10_03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DigitServer {

    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущено на порту " + PORT);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клієнт підключився");

            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(
                            clientSocket.getOutputStream(), true)
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(line)) {
                        break; // завершуємо роботу
                    }

                    // Витягаємо всі цифри з рядка
                    StringBuilder digits = new StringBuilder();
                    for (char ch : line.toCharArray()) {
                        if (Character.isDigit(ch)) {
                            digits.append(ch);
                        }
                    }

                    out.println(digits.toString()); // повертаємо клієнту
                }
            }

            System.out.println("Сервер завершив роботу");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
