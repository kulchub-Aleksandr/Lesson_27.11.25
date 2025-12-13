package tests;

import tests.utils.RandomUtils;


public class FakerTestData {

    RandomUtils randomUtils = new RandomUtils();

    public String firstName = randomUtils.firstName;
    public String lastName = randomUtils.lastName;
    public String userEmail = randomUtils.userEmail;
    public String gender = randomUtils.gender;
    public String userNumber = randomUtils.userNumber;
    public String notFullUserNumber = randomUtils.notFullUserNumber;
    public String day = randomUtils.day;
    public String month = randomUtils.month;
    public String year = randomUtils.year;
    public String subjects = randomUtils.subjects;
    public String hobbies = randomUtils.hobbies;
    public String Picture = randomUtils.Picture;
    public String currentAddress = randomUtils.currentAddress;

    public String state = randomUtils.state;
    public String city = randomUtils.city(randomUtils.state);

}
