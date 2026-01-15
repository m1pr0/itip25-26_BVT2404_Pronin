import java.util.regex.*;

//задание3

public class LowerUpperFinder {
    public static void main(String[] args) {
        String text = "helloWorld javaProgramming testCase exampleText";
        findLowerUpper(text);
    }

    public static void findLowerUpper(String text) {
        Pattern pattern = Pattern.compile("[a-z][A-Z]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String found = matcher.group();
            System.out.println("Найдено: " + found + " -> !" + found + "!");
        }
    }
}
