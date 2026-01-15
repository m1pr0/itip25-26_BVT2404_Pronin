public class main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы HashTable (Задание 1) ===");

        // Создаем хэш-таблицу
        HashTable<String, Integer> hashTable = new HashTable<>();

        // Добавляем элементы
        hashTable.put("apple", 10);
        hashTable.put("banana", 5);
        hashTable.put("orange", 8);

        System.out.println("Размер таблицы: " + hashTable.size());
        System.out.println("Пустая ли таблица: " + hashTable.isEmpty());

        // Получаем элементы
        System.out.println("Количество яблок: " + hashTable.get("apple"));
        System.out.println("Количество бананов: " + hashTable.get("banana"));

        // Обновляем элемент
        hashTable.put("apple", 15);
        System.out.println("Обновленное количество яблок: " + hashTable.get("apple"));

        // Удаляем элемент
        hashTable.remove("banana");
        System.out.println("Размер после удаления: " + hashTable.size());
        System.out.println("Бананы после удаления: " + hashTable.get("banana"));

        System.out.println("\n=== Демонстрация работы ProductStore (Задание 2) ===");

        // Создаем магазин товаров
        ProductStore store = new ProductStore();

        // Добавляем товары
        store.addProduct("A001", "Ноутбук", "Игровой ноутбук", 1500.0, 5);
        store.addProduct("A002", "Мышь", "Беспроводная мышь", 25.0, 20);
        store.addProduct("A003", "Клавиатура", "Механическая клавиатура", 80.0, 10);

        // Показываем все товары
        store.showAllProducts();

        // Ищем товары
        System.out.println("\nПоиск товаров:");
        store.findProduct("A001");
        store.findProduct("A999"); // Несуществующий товар

        // Удаляем товар
        System.out.println("\nУдаляем товар A002:");
        store.removeProduct("A002");
        store.showAllProducts();
    }
}