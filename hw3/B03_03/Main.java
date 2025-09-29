package hw3.B03_03;

public class Main {
    public static void main(String[] args) {
        Polynomial a = new Polynomial(new double[]{1, -2, 3});      // 1 - 2x + 3x^2
        Polynomial b = new Polynomial(new double[]{0, 4, -1, 2});   // 4x - x^2 + 2x^3

        Polynomial sum = a.add(b);
        Polynomial diff = a.subtract(b);
        Polynomial prod = a.multiply(b);

        Polynomial[] arr = {a, b, new Polynomial(new double[]{5})};
        Polynomial total = Polynomial.sum(arr);

        System.out.println("a(x)   = " + a);
        System.out.println("b(x)   = " + b);
        System.out.println("a+b    = " + sum);
        System.out.println("a-b    = " + diff);
        System.out.println("a*b    = " + prod);
        System.out.println("sum[]  = " + total);
        System.out.println("equals check (p == new p): " + a.equals(new Polynomial(a)));
    }
}
