package tests.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(333, 888));
        System.out.println(getRandomPhoneExtended());
        System.out.println(generateRandomPhoneNumber());
        System.out.println(getRandomGender());

    }

    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));

        return result.toString();
    }
    public static String getRandomEmail() {

        return getRandomString(8) + "@" + getRandomString(8) + ".com";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomIntAsString(int min, int max) {
        return getRandomInt(min, max) + "";
    }

    public static String generateRandomPhoneNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // Первая цифра: от 1 до 9
        StringBuilder phone = new StringBuilder();
        phone.append(random.nextInt(1, 10)); // [1, 10) → 1–9

        // Остальные 9 цифр: от 0 до 9
        for (int i = 0; i < 9; i++) {
            phone.append(random.nextInt(0, 10)); // [0, 10) → 0–9
        }

        return phone.toString();
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomPhoneExtended() {
//        return "+" + getRandomInt(1, 9) + " (" ....

//        String.format("Hello, %s!", "username"); -> "Hello, username!";
//        String.format("Hello, %s %s!", "Alex", "Egorov"); -> "Hello, Alex !";
//        String.format("Hello, %s %s %s!", "Alex", "Egorov"); -> "Hello, Alex !";

        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return gender[ThreadLocalRandom.current().nextInt(gender.length)];
    }



}
