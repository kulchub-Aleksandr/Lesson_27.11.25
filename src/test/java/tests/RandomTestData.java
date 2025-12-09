package tests;

import static tests.utils.RandomUtils.*;

public class RandomTestData {
    static String firstName = getRandomString(8);
    static String lastName =  getRandomString(8);
    static String userEmail = getRandomEmail();
    static String gender = getRandomGender();
    static String userNumber = generateRandomPhoneNumber();
    static String notFullUserNumber = "123456789";
    static String day = "04";
    static String month = "October";
    static String year = "1990";
    static String sabjects = "Maths";
    static String hobbies = "Reading";
    static String Picture = "icons.png";
    static String currentAddress = "Russia, Ufa";
    static String state = "NCR";
    static String City = "Delhi";
    static String submitFormText = "Thanks for submitting the form";
    static String permanentAddress = "Another street 1";

}
