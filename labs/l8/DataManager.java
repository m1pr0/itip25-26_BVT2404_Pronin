import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {
    private List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public List<String> loadData(String source) {
        return Arrays.asList("яблоко", "груша", "слива", "айва", "арбуз", "дыня");
    }

    public List<String> processData(List<String> data) throws Exception {

        List<String> result = new ArrayList<>(data);

        List<MethodInfo> methodsToExecute = new ArrayList<>();

        for (Object processor : processors) {
            Method[] methods = processor.getClass().getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    DataProcessor annotation = method.getAnnotation(DataProcessor.class);
                    methodsToExecute.add(new MethodInfo(processor, method, annotation.order(), annotation.name()));
                }
            }
        }

        methodsToExecute.sort(Comparator.comparingInt(m -> m.order));

        for (MethodInfo methodInfo : methodsToExecute) {

            if (methodInfo.method.getParameterTypes()[0] == List.class) {
                result = (List<String>) methodInfo.method.invoke(methodInfo.processor, result);
            }

            System.out.println(result);
        }

        return result;
    }

    public void saveData(String destination, List<String> data) {
        System.out.println("Итоговые данные: " + data);
    }

    private static class MethodInfo {
        Object processor;
        Method method;
        int order;
        String name;

        MethodInfo(Object processor, Method method, int order, String name) {
            this.processor = processor;
            this.method = method;
            this.order = order;
            this.name = name;
        }
    }

    public void processInParallel(List<String> data) throws InterruptedException {
        int mid = data.size() / 2;
        List<String> firstHalf = data.subList(0, mid);
        List<String> secondHalf = data.subList(mid, data.size());

        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            try {
                result1.addAll(processData(firstHalf));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                result2.addAll(processData(secondHalf));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        List<String> finalResult = new ArrayList<>();
        finalResult.addAll(result1);
        finalResult.addAll(result2);

        System.out.println("Результат параллельной обработки: " + finalResult);
    }
}