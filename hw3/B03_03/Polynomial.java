package hw3.B03_03;
import java.util.Arrays;

public class Polynomial {
    private final double[] a; // коефіцієнти: a[0] + a[1]x + ... + a[n]x^n
    private static final double EPS = 1e-9;

    public Polynomial() {
        this.a = new double[]{0.0};
    }

    public Polynomial(double[] coeffs) {
        if (coeffs == null || coeffs.length == 0) {
            this.a = new double[]{0.0};
        } else {
            this.a = trim(Arrays.copyOf(coeffs, coeffs.length));
        }
    }

    public Polynomial(Polynomial other) {
        this.a = Arrays.copyOf(other.a, other.a.length);
    }

    public int degree() {
        return a.length - 1;
    }

    public double coeff(int power) {
        if (power < 0 || power >= a.length) return 0.0;
        return a[power];
    }

    public Polynomial add(Polynomial b) {
        int n = Math.max(this.a.length, b.a.length);
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = this.coeff(i) + b.coeff(i);
        }
        return new Polynomial(res);
    }

    public Polynomial subtract(Polynomial b) {
        int n = Math.max(this.a.length, b.a.length);
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = this.coeff(i) - b.coeff(i);
        }
        return new Polynomial(res);
    }

    public Polynomial multiply(Polynomial b) {
        int n = this.degree() + b.degree() + 1;
        double[] res = new double[n];
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < b.a.length; j++) {
                res[i + j] += this.a[i] * b.a[j];
            }
        }
        return new Polynomial(res);
    }

    public static Polynomial sum(Polynomial[] arr) {
        if (arr == null || arr.length == 0) return new Polynomial();
        Polynomial s = new Polynomial(arr[0]);
        for (int i = 1; i < arr.length; i++) s = s.add(arr[i]);
        return s;
    }

    private static double[] trim(double[] c) {
        int k = c.length - 1;
        while (k > 0 && Math.abs(c[k]) < EPS) k--;
        return Arrays.copyOf(c, k + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polynomial)) return false;
        Polynomial b = (Polynomial) o;
        int n = Math.max(this.a.length, b.a.length);
        for (int i = 0; i < n; i++) {
            if (Math.abs(this.coeff(i) - b.coeff(i)) > EPS) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            double c = a[i];
            if (Math.abs(c) < EPS) continue;
            String sign = sb.length() == 0 ? (c < 0 ? "-" : "") : (c < 0 ? " - " : " + ");
            double ab = Math.abs(c);
            boolean showCoeff = !(Math.abs(ab - 1.0) < EPS && i != 0);
            sb.append(sign);
            if (showCoeff) sb.append(ab);
            if (i >= 1) sb.append("x");
            if (i >= 2) sb.append("^").append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
