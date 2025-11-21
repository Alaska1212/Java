package hw9;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class B09_04 {
    static class Parking {
        private final boolean[] spots;          // true = зайнято
        private final Random random = new Random();
        AtomicInteger money = new AtomicInteger(0);

        public Parking(int n) {
            spots = new boolean[n];
        }

        // спроба зайняти випадкове вільне місце
        public synchronized int tryPark() {
            List<Integer> free = new ArrayList<>();
            for (int i = 0; i < spots.length; i++) {
                if (!spots[i]) free.add(i);
            }

            if (free.isEmpty()) return -1; // немає місць

            int chosen = free.get(random.nextInt(free.size()));
            spots[chosen] = true;
            return chosen;
        }

        public synchronized void leave(int place) {
            spots[place] = false;
        }
    }

    static class Car extends Thread {
        private final Parking parking;
        private final int t3, t4;
        private final Random rand = new Random();

        public Car(Parking p, int t3, int t4) {
            this.parking = p;
            this.t3 = t3;
            this.t4 = t4;
        }

        @Override
        public void run() {
            int place = parking.tryPark();

            if (place == -1) {
                // всі місця зайняті → авто поїхало
                return;
            }

            // стоїть деякий час
            int time = rand.nextInt(t4 - t3 + 1) + t3;

            try {
                Thread.sleep(time);
            } catch (InterruptedException ignored) {}

            // додати гроші
            parking.money.addAndGet(time);

            parking.leave(place);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Ввід:
        // N
        // T1 T2
        // T3 T4
        // K — скільки автомобілів згенерувати
        int N = sc.nextInt();
        int T1 = sc.nextInt();
        int T2 = sc.nextInt();
        int T3 = sc.nextInt();
        int T4 = sc.nextInt();
        int K = sc.nextInt();

        Parking parking = new Parking(N);
        Random rand = new Random();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            Car c = new Car(parking, T3, T4);
            cars.add(c);
            c.start();

            // час до приїзду наступного авто
            int delay = rand.nextInt(T2 - T1 + 1) + T1;
            Thread.sleep(delay);
        }

        for (Car car : cars) car.join();

        System.out.println("Зароблено стоянкою: " + parking.money.get());
    }
}
