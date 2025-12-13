package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.utils.RandomUtils;

public class RegistrationWithFakerDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils  randomUtils = new RandomUtils();
    FakerTestData fakerTestData = new FakerTestData();


    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                .setEmail(fakerTestData.userEmail)
                .setGender(fakerTestData.gender)
                .setUserNumber(fakerTestData.userNumber)
                .setDateOfBirth(fakerTestData.day, fakerTestData.month, fakerTestData.year)
                .setSabjects(fakerTestData.subjects)
                .setHobbies(fakerTestData.hobbies)
                .setUploadPicture(fakerTestData.Picture)
                .setCurrentAddress(fakerTestData.currentAddress)
                .setScroll()
                .setStateDropdown(fakerTestData.state)
                .setCityDropdown(fakerTestData.city)
                .setSubmit()
                .setModalDialog()
                .setModalTitle(randomUtils.submitFormText)
                .checkResult("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
                .checkResult("Student Email", fakerTestData.userEmail)
                .checkResult("Gender", fakerTestData.gender)
                .checkResult("Mobile", fakerTestData.userNumber)
                .checkResult("Date of Birth", fakerTestData.day + " " + fakerTestData.month + "," + fakerTestData.year)
                .checkResult("Subjects", fakerTestData.subjects)
                .checkResult("Hobbies", fakerTestData.hobbies)
                .checkResult("Picture", fakerTestData.Picture)
                .checkResult("Address", fakerTestData.currentAddress)
                .checkResult("State and City", fakerTestData.state + " " + fakerTestData.city)
                .closeModal();


    }

    @Test
    void minimalSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                //.setEmail("Alex@Dmitr.com")
                .setGender(fakerTestData.gender)
                .setUserNumber(fakerTestData.userNumber)
                //.setDateOfBirth("30", "October", "1990")
                //.setSabjects("Maths")
                //.setHobbies("Reading")
                //.setUploadPicture("icons.png")
                //.setCurrentAddress("Russia, Ufa")
                //.setStateDropdown(state)
                //.setStateCityWrapper(state)
                //.setCityDropdown(city)
                //.setStateCityWrapper(city)
                .setScroll()
                .setSubmit()
                .setModalDialog()
                .setModalTitle(randomUtils.submitFormText)
                .checkResult("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
//                .checkResult("Student Email", "Alex@Dmitr.com")
                .checkResult("Gender", fakerTestData.gender)
                .checkResult("Mobile", fakerTestData.userNumber)
//                .checkResult("Date of Birth", "30 October,1990")
//                .checkResult("Subjects", "Maths")
//                .checkResult("Hobbies", "Reading")
//                .checkResult("Picture", "icons.png")
//                .checkResult("Address", "Russia, Ufa")
//                .checkResult("State and City", "NCR Delhi")
                .closeModal();
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                .setEmail(fakerTestData.userEmail)
                .setGender(fakerTestData.gender)
                .setUserNumber(fakerTestData.notFullUserNumber)  // не полный набор цифр
                .setDateOfBirth(fakerTestData.day, fakerTestData.month, fakerTestData.year)
                .setSabjects(fakerTestData.subjects)
                .setHobbies(fakerTestData.hobbies)
                .setUploadPicture(fakerTestData.Picture)
                .setCurrentAddress(fakerTestData.currentAddress)
                .setScroll()
//                .setStateDropdown()
//                .setStateCityWrapper(state)
//                .setStateDropdown()
//                .setStateCityWrapper(city)
                .setSubmit()
                .getModalDialog();
        //.setModalDialog()
//                .setModalTitle("Thanks for submitting the form")
//                .checkResult("Student Name", "Alex Dmitr")
//                .checkResult("Student Email", "Alex@Dmitr.com")
//                .checkResult("Gender", "Male")
//                .checkResult("Mobile", "123456789")
//                .checkResult("Date of Birth", "04 October,1990")
//                .checkResult("Subjects", "Maths")
//                .checkResult("Hobbies", "Reading")
//                .checkResult("Picture", "icons.png")
//                .checkResult("Address", "Russia, Ufa")
//                .checkResult("State and City", "NCR Delhi")
//                .closeModal();


    }
}