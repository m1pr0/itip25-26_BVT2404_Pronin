public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        try {
            // Обработка массива - вычисление суммы
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            // Вычисление среднего арифметического
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: арифметическая ошибка");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}