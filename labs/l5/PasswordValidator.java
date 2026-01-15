import java.util.regex.*;

//задание2

public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {"Pass123", "weak", "StrongPass1", "short", "GoodPass123"};

        for (String pwd : passwords) {
            System.out.println(pwd + " - " + (isValidPassword(pwd) ? "валиден" : "невалиден"));
        }
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        return password.matches(regex);
    }
}
