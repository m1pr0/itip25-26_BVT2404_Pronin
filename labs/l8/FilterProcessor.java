import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {

    @DataProcessor(name = "Фильтр длинных слов", order = 2)
    public List<String> filterLongWords(List<String> data) {

        return data.stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());
    }
}