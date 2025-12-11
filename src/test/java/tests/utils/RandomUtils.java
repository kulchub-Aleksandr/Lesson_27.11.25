package tests.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en"));

    public static void main(String[] args) {
        System.out.println(getRandomString(8));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(333, 888));
        System.out.println(generateRandomPhoneNumber());
        System.out.println(generateNotFullRandomPhoneNumber());
        System.out.println(getRandomGender());
        System.out.println(generateRandomYear());
        System.out.println(generateRandomMonth());
        System.out.println(generateRandomDay());
        System.out.println(getRandomSubjectsInput());
        System.out.println(getRandomStateInput());
        System.out.println(getRandomCityInput(getRandomStateInput()));

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
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generateNotFullRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(9);

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

        int minYear = 1900;
        int maxYear = 2100;
        int year = getRandomInt(minYear, maxYear);
        return String.valueOf(year);
    }

    public static String generateRandomMonth() {

        int minMonth = 1;
        int maxMonth = 12;
        int month = getRandomInt(minMonth, maxMonth) + minMonth;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM", new Locale("en", "US"));
        return sdf.format(cal.getTime());
    }

    public static String generateRandomDay() {

        String yearStr = generateRandomYear();
        String monthName = generateRandomMonth();
        int monthNum = getMonthNumberFromName(monthName);
        int yearInt = Integer.parseInt(yearStr);
        Calendar cal = Calendar.getInstance();
        cal.set(yearInt, monthNum - 1, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = getRandomInt(0, maxDay) + 1;
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

    public static String getRandomSubjectsInput() {
        String[] subjects = {
                "Chemistry", "Computer Science", "English", "Maths", "Physics", "Economics",
                "Arts", "Social Studies", "History", "Civics", "Hindi", "Biology", "Commerce", "Accounting"
        }; //14

        return subjects[ThreadLocalRandom.current().nextInt(subjects.length - 1)];
    }


    public static String getRandomStateInput() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        //return state;
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



