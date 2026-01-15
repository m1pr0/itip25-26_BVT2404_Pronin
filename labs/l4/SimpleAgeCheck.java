import java.io.FileWriter;
import java.io.IOException;

public class SimpleAgeCheck {
    public static void main(String[] args) {
        checkAge(25);   // Корректный
        checkAge(-10);  // Ошибка
        checkAge(130);  // Ошибка
        checkAge(18);   // Корректный
    }

    public static void checkAge(int age) {
        try {
            if (age < 0 || age > 120) {
                throw new CustomAgeException("Возраст " + age + " недопустим! Должен быть от 0 до 120.");
            }
            System.out.println("Возраст " + age + " - OK");

        } catch (CustomAgeException e) {
            // Записываем ошибку в файл
            try (FileWriter writer = new FileWriter("age_errors.txt", true)) {
                writer.write("Ошибка: " + e.getMessage() + "\n");
                System.out.println("Записано в лог: " + e.getMessage());
            } catch (IOException ioException) {
                System.out.println("Не удалось записать в файл: " + ioException.getMessage());
            }
        }
    }
}
