package tests.utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(333, 888));
        System.out.println(getRandomPhoneExtended());
        System.out.println(generateRandomPhoneNumber());
        System.out.println(getRandomGender());
        System.out.println(generateRandomYear());
        System.out.println(generateRandomMonth());
        System.out.println(generateRandomDay());

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
    public static String generateNotFullRandomPhoneNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // Первая цифра: от 1 до 9
        StringBuilder phone = new StringBuilder();
        phone.append(random.nextInt(1, 10)); // [1, 10) → 1–9
        // Остальные 9 цифр: от 0 до 8
        for (int i = 0; i < 8; i++) {
            phone.append(random.nextInt(0, 9)); // [0, 10) → 0–9
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

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[ThreadLocalRandom.current().nextInt(hobbies.length)];
    }

    public static String generateRandomYear() {
        Random random = new Random();
        int minYear = 1900;
        int maxYear = 2100;
        int year = random.nextInt(maxYear - minYear + 1) + minYear;
        return String.valueOf(year);
    }
    public static String generateRandomMonth() {
        Random random = new Random();
        int minMonth = 1;
        int maxMonth = 12;
        int month = random.nextInt(maxMonth - minMonth + minMonth) + minMonth;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM", new Locale("en", "US"));
        return sdf.format(cal.getTime());
    }
    public static String generateRandomDay() {
        Random random = new Random();
        String yearStr = generateRandomYear();
        String monthName = generateRandomMonth();
        int monthNum = getMonthNumberFromName(monthName);
        int yearInt = Integer.parseInt(yearStr);
        Calendar cal = Calendar.getInstance();
        cal.set(yearInt, monthNum - 1, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = random.nextInt(maxDay) + 1;
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    private static int getMonthNumberFromName(String monthName) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(monthName)) {
                return i + 1; // номер месяца (1–12)
            }
        }
        return 1; // по умолчанию январь, если не найдено
    }

}

