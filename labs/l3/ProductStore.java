import java.util.HashMap;

public class ProductStore {
    private HashMap<String, Product> products = new HashMap<>();

    // Добавление товара
    public void addProduct(String article, String name, String description, double price, int quantity) {
        products.put(article, new Product(name, description, price, quantity));
    }

    // Поиск товара
    public void findProduct(String article) {
        Product product = products.get(article);
        if (product != null) {
            System.out.println("Найден товар: " + product);
        } else {
            System.out.println("Товар с артикулом " + article + " не найден");
        }
    }

    // Удаление товара
    public void removeProduct(String article) {
        Product removed = products.remove(article);
    }

    // Показать все товары
    public void showAllProducts() {
        System.out.println("Все товары:");
        for (String article : products.keySet()) {
            System.out.println("Артикул: " + article + "," + products.get(article));
        }
    }
}
