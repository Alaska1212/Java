package hw4.B04_03;

public class Leafy extends Vegetable{
    public Leafy(String name, double kcal100, int fresh, double baseV) {
        super(name, kcal100, fresh, baseV);
    }
    @Override protected double typeFactor() { return 1.3; }
}
