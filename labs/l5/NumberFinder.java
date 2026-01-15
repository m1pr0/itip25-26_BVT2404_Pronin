import java.util.regex.*;

// задание1

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Цены: 100 руб, 25.50 руб, 3.14 и 1000";
        findNumbers(text);
    }

    public static void findNumbers(String text) {
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Найдено число: " + matcher.group());
        }
    }
}