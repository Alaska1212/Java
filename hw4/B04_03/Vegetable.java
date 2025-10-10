package hw4.B04_03;

public abstract class Vegetable implements Comparable<Vegetable>{
    private final String name;
    private final double kcalPer100g;
    private int freshness;           // 0..100
    private final double baseVitamins;

    protected Vegetable(String name, double kcalPer100g, int freshness, double baseVitamins) {
        this.name = name;
        this.kcalPer100g = Math.max(0, kcalPer100g);
        setFreshness(freshness);
        this.baseVitamins = Math.max(0, baseVitamins);
    }

    protected abstract double typeFactor(); // від типу овочу

    public double vitaminScore() {
        return baseVitamins * typeFactor() * (freshness / 100.0);
    }

    // --- гетери/сетери (інкапсуляція)
    public String getName() { return name; }
    public double getKcalPer100g() { return kcalPer100g; }
    public int getFreshness() { return freshness; }
    public void setFreshness(int f) { this.freshness = Math.min(100, Math.max(0, f)); }

    // Сортування: за спаданням вітамінізації
    @Override public int compareTo(Vegetable o) {
        return Double.compare(o.vitaminScore(), this.vitaminScore());
    }

    @Override public String toString() {
        return name + " {fresh=" + freshness + "%, vit=" + String.format("%.2f", vitaminScore()) + "}";
    }
}
