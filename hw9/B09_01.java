package hw9;import java.io.*;
import java.util.concurrent.*;

// B09_01: producer/consumer with different processing times
public class B09_01 {

    private static final String POISON_PILL = "__END__";

    static class Producer implements Runnable {
        private final BlockingQueue<String> queue;
        private final String inputFile;
        private final long t1Millis;

        Producer(BlockingQueue<String> queue, String inputFile, long t1Millis) {
            this.queue = queue;
            this.inputFile = inputFile;
            this.t1Millis = t1Millis;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    queue.put(line);
                    Thread.sleep(t1Millis); // раз в T1 часу читає рядок
                }
            } catch (FileNotFoundException e) {
                System.err.println("Не знайдено файл: " + inputFile);
            } catch (IOException e) {
                System.err.println("Помилка читання файлу: " + e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // повідомляємо обом споживачам, що дані закінчились
                try {
                    queue.put(POISON_PILL);
                    queue.put(POISON_PILL);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<String> queue;
        private final String outputFile;
        private final long tProcessMillis;

        Consumer(BlockingQueue<String> queue, String outputFile, long tProcessMillis) {
            this.queue = queue;
            this.outputFile = outputFile;
            this.tProcessMillis = tProcessMillis;
        }

        @Override
        public void run() {
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
                while (true) {
                    String line = queue.take();
                    if (POISON_PILL.equals(line)) break;

                    // імітація обробки
                    Thread.sleep(tProcessMillis);

                    pw.println(line);
                    pw.flush();
                }
            } catch (IOException e) {
                System.err.println("Помилка запису у файл " + outputFile + ": " + e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Ввід:
            // 1) ім'я (або шлях) до файлу F
            // 2) T1 T2 T3 (у мілісекундах)
            String inputFile = in.readLine().trim();
            String[] parts = in.readLine().trim().split("\\s+");
            long T1 = Long.parseLong(parts[0]);
            long T2 = Long.parseLong(parts[1]);
            long T3 = Long.parseLong(parts[2]);

            BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

            Thread producer = new Thread(new Producer(queue, inputFile, T1), "Producer");
            Thread consumer1 = new Thread(new Consumer(queue, "out_T2.txt", T2), "Consumer-T2");
            Thread consumer2 = new Thread(new Consumer(queue, "out_T3.txt", T3), "Consumer-T3");

            producer.start();
            consumer1.start();
            consumer2.start();

            producer.join();
            consumer1.join();
            consumer2.join();

            System.out.println("Готово. Результати у файлах out_T2.txt та out_T3.txt");

        } catch (Exception e) {
            System.err.println("Помилка вводу/виконання: " + e.getMessage());
        }
    }
}
