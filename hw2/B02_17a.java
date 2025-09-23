package hw2;
import java.util.Scanner;

public class B02_17a {public static double f(double x, double eps) {
    double sum = 0.0;
    int k = 0;
    while (true) {
        double term = Math.pow(-1, k) * Math.pow(x, k);
        if (Math.abs(term) <= eps) {
            break;
        }
        sum += term;
        k++;
    }
    return sum;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x (|x| < 1): ");
        double x = sc.nextDouble();
        System.out.print("епсілон (>0): ");
        double eps = sc.nextDouble();

        if (Math.abs(x) >= 1 || eps <= 0) {
            System.out.println("помилка: |x| має бути < 1, епсілон > 0");
        } else {
            double result = f(x, eps);
            System.out.println("сума = " + result);
        }
    }
}
