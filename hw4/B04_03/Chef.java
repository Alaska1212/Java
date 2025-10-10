package hw4.B04_03;
import java.util.List;

public class Chef {
    public static void main(String[] args) {
        // мінімальний набір овочів
        Vegetable tomato = new Leafy("Tomato", 18, 90, 50); // умовно як листовий для простоти
        Vegetable carrot = new Root("Carrot", 41, 80, 60);
        Vegetable spinach = new Leafy("Spinach", 23, 95, 85);

        Salad s = new Salad("Simple Fit");
        s.add(new Ingredient(tomato, 120));
        s.add(new Ingredient(carrot, 80));
        s.add(new Ingredient(spinach, 60));

        System.out.println("--- SALAD ---");
        System.out.println(s);

        System.out.println("--- SORTED BY VITAMINS ---");
        for (Ingredient i : s.sortByVitaminization()) System.out.println(" • " + i);

        System.out.println("--- FRESHNESS 85..100 ---");
        List<Ingredient> fresh = s.findByFreshness(85, 100);
        if (fresh.isEmpty()) System.out.println(" (none)");
        for (Ingredient i : fresh) System.out.println(" • " + i);

        // показати вплив свіжості
        tomato.setFreshness(60);
        System.out.println("\nAfter tomato freshness=60% -> re-sort:");
        for (Ingredient i : s.sortByVitaminization()) System.out.println(" • " + i);
    }
}
