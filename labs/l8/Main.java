import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== ПРОГРАММА ОБРАБОТКИ ДАННЫХ ===\n");

        DataManager manager = new DataManager();

        manager.registerDataProcessor(new UpperCaseProcessor());
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new NumberProcessor());

        List<String> data = manager.loadData("test-data.txt");

        List<String> processedData = manager.processData(data);

        manager.saveData("output.txt", processedData);

        manager.processInParallel(data);

        System.out.println("\n=== ОБРАБОТКА ЧИСЕЛ ===");
        NumberProcessor numberProcessor = new NumberProcessor();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubled = numberProcessor.doubleNumbers(numbers);
        System.out.println("Числа: " + numbers);
        System.out.println("Удвоенные: " + doubled);

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }
}