import java.util.regex.*;

//задание5

public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple banana cherry apricot berry apple";
        char searchLetter = 'a';
        findWordsStartingWith(text, searchLetter);
    }

    public static void findWordsStartingWith(String text, char letter) {
        Pattern pattern = Pattern.compile("\\b" + letter + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова на букву '" + letter + "':");
        while (matcher.find()) {
            System.out.println("- " + matcher.group());
        }
    }
}