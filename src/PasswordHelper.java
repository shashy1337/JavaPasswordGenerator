import java.security.SecureRandom;
import java.util.Random;

public class PasswordHelper {
    public static String generatePassword(int length) {
        if (length < 8) {
            length = 8;
        }

        final char[] upperCase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] numbers = "1234567890".toCharArray();
        final char[] symbols = "^$?!@#%&".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

        Random random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length - 4; i++) {

            password.append(allAllowed[random.nextInt(allAllowed.length)]);
        }

        password.insert(random.nextInt(password.length()), lowerCase[random.nextInt(lowerCase.length)]);
        password.insert(random.nextInt(password.length()), upperCase[random.nextInt(upperCase.length)]);
        password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
        password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);
        return password.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatePassword(10));
    }
}
