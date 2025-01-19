import java.util.*;

class Cosmetics {
    private String name;
    private String brand;
    private double price;
    private int quantity;
    private String category;


    public Cosmetics(String name, String brand, double price, int quantity, String category) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cosmetics that = (Cosmetics) o;
        return Double.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(name, that.name) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, price, quantity, category);
    }

    @Override
    public String toString() {
        return String.format("Cosmetics{name='%s', brand='%s', price=%.2f, quantity=%d, category='%s'}",
                name, brand, price, quantity, category);
    }
}


public class Main {
    public static void main(String[] args) {

        List<Cosmetics> cosmeticsList = new ArrayList<>();
        cosmeticsList.add(new Cosmetics("Lipstick", "BrandA", 15.99, 50, "Makeup"));
        cosmeticsList.add(new Cosmetics("Foundation", "BrandB", 29.99, 30, "Makeup"));
        cosmeticsList.add(new Cosmetics("Shampoo", "BrandC", 9.99, 100, "Haircare"));
        cosmeticsList.add(new Cosmetics("Conditioner", "BrandC", 12.99, 80, "Haircare"));
        cosmeticsList.add(new Cosmetics("Mascara", "BrandA", 19.99, 20, "Makeup"));

        cosmeticsList.sort(Comparator.comparingDouble(Cosmetics::getPrice)
                .thenComparing(Comparator.comparingInt(Cosmetics::getQuantity).reversed()));

        System.out.println("Відсортований список косметики за ціною:");
        cosmeticsList.forEach(System.out::println);

        cosmeticsList.sort(Comparator.comparing(Cosmetics::getName)
                .thenComparing(Comparator.comparingDouble(Cosmetics::getPrice))
                .thenComparing(Comparator.comparingInt(Cosmetics::getQuantity).reversed()));
        System.out.println("Відсортований список косметики за алфавітом:");
        cosmeticsList.forEach(System.out::println);
        Cosmetics target = new Cosmetics("Shampoo", "BrandC", 9.99, 100, "Haircare");
        int index = cosmeticsList.indexOf(target);
        if (index != -1) {
            System.out.println("Знайдено об'єкт: " + cosmeticsList.get(index));
        } else {
            System.out.println("Об'єкт не знайдено у списку.");
        }
    }
}
