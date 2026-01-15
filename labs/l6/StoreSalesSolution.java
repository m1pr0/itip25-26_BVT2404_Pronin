import java.util.ArrayList;


public class StoreSalesSolution {

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> sales = new ArrayList<>();
        double total = 0;

        sales.add(new Product("Хлеб", 50));
        sales.add(new Product("Молоко", 80));
        sales.add(new Product("Хлеб", 50));
        sales.add(new Product("Яйца", 120));

        System.out.println("Список проданных товаров:");
        for (Product p : sales) {
            System.out.println("- " + p.name + ": " + p.price + " руб.");
            total += p.price;
        }

        System.out.println("Общая сумма: " + total);

        String popular = "";
        int maxCount = 0;

        for (int i = 0; i < sales.size(); i++) {
            int count = 0;
            for (int j = 0; j < sales.size(); j++) {
                if (sales.get(i).name.equals(sales.get(j).name)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                popular = sales.get(i).name;
            }
        }

        System.out.println("Популярный товар: " + popular +
                " (продано " + maxCount + " раз)");
    }
}
