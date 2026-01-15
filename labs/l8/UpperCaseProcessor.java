import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseProcessor {

    @DataProcessor(name = "Верхний регистр", order = 1)
    public List<String> toUpperCase(List<String> data) {

        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}