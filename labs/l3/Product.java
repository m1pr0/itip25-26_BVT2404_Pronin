import java.util.HashMap;

class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " | " + description + " | Цена: " + price + " | В наличии: " + quantity;
    }
}

