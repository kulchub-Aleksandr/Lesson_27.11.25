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
        System.out.println(getRandomGender());
        System.out.println(generateRandomYear());
        System.out.println(generateRandomMonth());
        System.out.println(generateRandomDay());
        System.out.println(getRandomSubjectsInput());
        System.out.println(getStateRandomInput());
        System.out.println(getCityRandomInput(getStateRandomInput()));

    }

    //private static final Random random = new Random();

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
//    public static String generateRandomPhoneNumber() {
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        // Первая цифра: от 1 до 9
//        StringBuilder phone = new StringBuilder();
//        phone.append(random.nextInt(1, 10)); // [1, 10) → 1–9
//        // Остальные 9 цифр: от 0 до 9
//        for (int i = 0; i < 9; i++) {
//            phone.append(random.nextInt(0, 10)); // [0, 10) → 0–9
//        }
//        return phone.toString();
//    }
//    public static String generateNotFullRandomPhoneNumber() {
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        // Первая цифра: от 1 до 9
//        StringBuilder phone = new StringBuilder();
//        phone.append(random.nextInt(1, 10)); // [1, 10) → 1–9
//        // Остальные 9 цифр: от 0 до 8
//        for (int i = 0; i < 8; i++) {
//            phone.append(random.nextInt(0, 9)); // [0, 10) → 0–9
//        }
//        return phone.toString();
//    }

//    // +3 (263) 253 - 66 - 12
//    public static String getRandomPhoneExtended() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
//    }

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
        int month = getRandomInt(minMonth, minMonth) + minMonth;
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
//        Random random = new Random();
//        int count = random.nextInt(subjects.length);//
//        for (int i = 0; i < count; i++) {
//            int index = random.nextInt(subjects.length);
//            result.add(subjects[index]);
//        }
//        return result;
        return subjects[ThreadLocalRandom.current().nextInt(subjects.length - 1)];
    }

//    public static String getStateInput() {
//        //Random random = new Random();
//        String[] subjects = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
//        return subjects[getRandomInt(0, subjects.length - 1)];
//    }


    public static String getStateRandomInput() {
        String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        ;
        //--> Faker выбирает штат из заданного списка
        return state; // state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCityRandomInput(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

//        public static String getCityInput () {
//            String state = getStateInput();
//            //Random random = new Random();
//
//            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
//            String[] cityUttarPradesh = {"Agra", "Lucknow", "Merrut"};
//            String[] cityHaryana = {"Karnal", "Panipat"};
//            String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
//
//            if (state.equals("NCR")) {
//                return cityNCR[getRandomInt(0, cityNCR.length - 1)];
//            } else if (state.equals("Uttar Pradesh")) {
//                return cityUttarPradesh[getRandomInt(0, cityUttarPradesh.length - 1)];
//            } else if (state.equals("Haryana")) {
//                return cityHaryana[getRandomInt(0, cityHaryana.length - 1)];
//            } else if (state.equals("Rajasthan")) {
//                return cityRajasthan[getRandomInt(0, cityRajasthan.length - 1)];
//            }
//            return "Unknown City";
//        }


    }
}


