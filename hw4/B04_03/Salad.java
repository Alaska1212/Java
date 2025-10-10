package hw4.B04_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {
    private final String name;
    private final List<Ingredient> items = new ArrayList<>();

    public Salad(String name) { this.name = name; }
    public void add(Ingredient i) { items.add(i); }
    public List<Ingredient> ingredients() { return Collections.unmodifiableList(items); }

    public double totalCalories() {
        double sum = 0;
        for (Ingredient i : items) sum += i.calories();
        return sum;
    }

    public List<Ingredient> sortByVitaminization() {
        // робимо копію і сортуємо за порівнянням овочів (Comparable у Vegetable)
        List<Ingredient> copy = new ArrayList<>(items);
        Collections.sort(copy, (a, b) -> a.getVegetable().compareTo(b.getVegetable()));
        return copy;
    }

    public List<Ingredient> findByFreshness(int min, int max) {
        List<Ingredient> res = new ArrayList<>();
        if (min > max) { int t = min; min = max; max = t; }
        if (min < 0) min = 0; if (max > 100) max = 100;
        for (Ingredient i : items) {
            int f = i.getVegetable().getFreshness();
            if (f >= min && f <= max) res.add(i);
        }
        return res;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("Salad '" + name + "':\n");
        for (Ingredient i : items) sb.append(" • ").append(i).append('\n');
        sb.append("Total: ").append(String.format("%.1f", totalCalories())).append(" kcal\n");
        return sb.toString();
    }
}
