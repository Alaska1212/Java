package hw4.B04_03;

public class Ingredient {
    private final Vegetable veg;
    private final int grams; // >0

    public Ingredient(Vegetable veg, int grams) {
        this.veg = veg;
        this.grams = Math.max(1, grams);
    }

    public Vegetable getVegetable() { return veg; }
    public int getGrams() { return grams; }
    public double calories() { return veg.getKcalPer100g() * grams / 100.0; }

    @Override public String toString() {
        return veg.getName() + " " + grams + "g (" + String.format("%.1f", calories()) +
                " kcal, fresh=" + veg.getFreshness() + "%, vit=" +
                String.format("%.2f", veg.vitaminScore()) + ")";
    }
}
