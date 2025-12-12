package tests.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en"));

    public static void main(String[] args) {
        //System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        //System.out.println(getRandomInt(333, 888));
        //System.out.println(generateRandomPhoneNumber());
        //System.out.println(generateNotFullRandomPhoneNumber());
        System.out.println(getRandomGender());
        System.out.println(getRandomHobbies());
        System.out.println(generateRandomYear());
        System.out.println(generateRandomMonth());
        System.out.println(generateRandomDay());
        System.out.println(getRandomSubjectsInput());
        System.out.println(getRandomStateInput());
        System.out.println(getRandomCityInput(getRandomStateInput()));

    }


    public static String getRandomString(int len) {
       // String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));

        return result.toString();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomIntAsString(int min, int max) {
        return getRandomInt(min, max) + "";
    }

    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generateNotFullRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(9);

    }

    public static String getRandomGender() {
        String gender;
        gender = faker.options().option("Male", "Female", "Other");
        return gender;
    }

    public static String getRandomHobbies() {
        String hobbies;
        hobbies = faker.options().option("Sports", "Reading", "Music");
        return hobbies;
    }

    public static String generateRandomYear() {
        int year;
        year = faker.number().numberBetween(1990,2100);
        return String.valueOf(year);
    }

    public static String generateRandomMonth() {
        int month = faker.number().numberBetween(1, 12);
        Month monthEnum = Month.of(month);
        return monthEnum.getDisplayName(
                TextStyle.FULL,
                Locale.ENGLISH
        );
    }

    public static String generateRandomDay() {
        String yearStr = generateRandomYear();
        String monthName = generateRandomMonth();
        int yearInt = Integer.parseInt(yearStr);
        int monthNum = getMonthNumberFromName(monthName);
        YearMonth yearMonth = YearMonth.of(yearInt, monthNum);
        int maxDay = yearMonth.lengthOfMonth();
        int day = faker.number().numberBetween(0, maxDay);
        return String.format("%02d", day);
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

    public static String getRandomSubjectsInput() {
        String subjects;
        subjects = faker.options().option("Chemistry", "Computer Science", "English", "Maths", "Physics", "Economics",
               "Arts", "Social Studies", "History", "Civics", "Hindi", "Biology", "Commerce", "Accounting");
        return subjects;
    }

    public static String getRandomStateInput() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCityInput(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }


}



