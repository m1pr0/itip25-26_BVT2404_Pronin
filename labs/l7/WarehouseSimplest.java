import java.util.*;

public class WarehouseSimplest {
    // Простейший склад без сложной логики
    static class SimpleWarehouse {
        private List<String> products = Collections.synchronizedList(new ArrayList<>());
        private int currentWeight = 0;

        public void addProduct(String product, int weight) {
            products.add(product + " (" + weight + "кг)");
        }

        public synchronized String takeProduct() {
            if (products.isEmpty()) return null;
            return products.remove(0);
        }

        public synchronized boolean canAddToTruck(int weight) {
            return (currentWeight + weight) <= 150;
        }

        public synchronized void addWeight(int weight) {
            currentWeight += weight;
        }

        public synchronized void resetTruck() {
            currentWeight = 0;
        }
    }

    // Простой грузчик
    static class SimpleLoader extends Thread {
        private SimpleWarehouse warehouse;

        SimpleLoader(String name, SimpleWarehouse warehouse) {
            super(name);
            this.warehouse = warehouse;
        }

        public void run() {
            System.out.println(getName() + " начал работу");

            while (true) {
                String product = warehouse.takeProduct();
                if (product == null) break;

                // Извлекаем вес из строки "Телевизор (25кг)"
                int weight = Integer.parseInt(product.split("\\(")[1].replace("кг)", ""));

                // Проверяем, поместится ли на грузовик
                if (!warehouse.canAddToTruck(weight)) {
                    System.out.println("⚡ " + getName() + ": Грузовик полон! Отправляем...");
                    warehouse.resetTruck();
                }

                // Кладем товар
                warehouse.addWeight(weight);
                System.out.println(getName() + " загрузил: " + product);

            }

            System.out.println(getName() + " закончил работу");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleWarehouse warehouse = new SimpleWarehouse();
        Random rand = new Random();

        // Заполняем склад
        String[] items = {"Ящик", "Коробка", "Мешок", "Бочка"};
        for (int i = 1; i <= 20; i++) {
            int weight = rand.nextInt(30) + 10;
            String item = items[rand.nextInt(items.length)] + " " + i;
            warehouse.addProduct(item, weight);
        }

        // Создаем и запускаем грузчиков
        SimpleLoader[] loaders = new SimpleLoader[3];
        for (int i = 0; i < 3; i++) {
            loaders[i] = new SimpleLoader("Работник-" + (i+1), warehouse);
            loaders[i].start();
        }

        // Ждем завершения
        for (SimpleLoader loader : loaders) {
            loader.join();
        }

        System.out.println("\n=== ВСЕ ТОВАРЫ ПЕРЕВЕЗЕНЫ! ===");
    }
}