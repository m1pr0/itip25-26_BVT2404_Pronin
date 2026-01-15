import java.util.List;
import java.util.stream.Collectors;

public class NumberProcessor {

    @DataProcessor(name = "Удвоение чисел", order = 3)
    public List<Integer> doubleNumbers(List<Integer> numbers) {

        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }
}
