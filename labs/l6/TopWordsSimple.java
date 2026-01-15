import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWordsSimple {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("text.txt"));
            Map<String, Integer> wordMap = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-яё]", "");

                if (!word.isEmpty()) {
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }
            scanner.close();

            List<String> words = new ArrayList<>(wordMap.keySet());

            words.sort((a, b) -> wordMap.get(b) - wordMap.get(a));

            for (int i = 0; i < Math.min(10, words.size()); i++) {
                String word = words.get(i);
                System.out.printf("%d. '%s' - %d раз\n", i + 1, word, wordMap.get(word));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден!");
        }
    }
}
