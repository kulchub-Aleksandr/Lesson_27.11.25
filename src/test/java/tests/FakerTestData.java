package tests;

import com.github.javafaker.Faker;
//import tests.utils.RandomDateGenerator;

import java.util.Locale;

import static tests.utils.RandomUtils.*;
//import static tests.utils.RandomDateGenerator.*;

public class FakerTestData {
    static Faker faker = new Faker(new Locale("en"));
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = faker.internet().safeEmailAddress();
    static String gender = getRandomGender();
    static String userNumber = faker.phoneNumber().subscriberNumber(10);;
    static String notFullUserNumber = faker.phoneNumber().subscriberNumber(9);;
    static String day = generateRandomDay();
    static String month = generateRandomMonth();
    static String year = generateRandomYear();
    static String sabjects = getRandomSubjectsInput();
    static String hobbies = getRandomHobbies();
    static String Picture = "icons.png";
    static String currentAddress = faker.address().fullAddress();
    static String state = getRandomStateInput();
    static String city = getRandomCityInput(state);
    static String submitFormText = "Thanks for submitting the form";
    //static String permanentAddress = faker.address().secondaryAddress();

}
