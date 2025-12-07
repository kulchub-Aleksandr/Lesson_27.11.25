package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName("Alex")
                .setLastName("Dmitr")
                .setEmail("Alex@Dmitr.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "October", "1990")
                .setSabjects("Maths")
                .setHobbies("Reading")
                .setUploadPicture("icons.png")
                .setCurrentAddress("Russia, Ufa")
                .setStateDropdown()
                .setStateCityWrapper("NCR")
                .setCityDropdown()
                .setStateCityWrapper("Delhi")
                .setSubmit()
                .setModalDialog()
                .setModalTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Alex Dmitr")
                .checkResult("Student Email", "Alex@Dmitr.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 October,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "icons.png")
                .checkResult("Address", "Russia, Ufa")
                .checkResult("State and City", "NCR Delhi")
                .closeModal();



    }

    @Test
    void minimalSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName("Alex")
                .setLastName("Dmitr")
                //.setEmail("Alex@Dmitr.com")
                .setGender("Male")
                .setUserNumber("8999999999")
                //.setDateOfBirth("30", "October", "1990")
                //.setSabjects("Maths")
                //.setHobbies("Reading")
                //.setUploadPicture("icons.png")
                //.setCurrentAddress("Russia, Ufa")
                //.setStateDropdown()
                //.setStateCityWrapper("NCR")
                //.setCityDropdown()
                //.setStateCityWrapper("Delhi")
                .setSubmit()
                .setModalDialog()
                .setModalTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Alex Dmitr")
//                .checkResult("Student Email", "Alex@Dmitr.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999999999")
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
                .setFirstName("Alex")
                .setLastName("Dmitr")
                .setEmail("Alex@Dmitr.com")
                .setGender("Male")
                .setUserNumber("123456789")  // не полный набор цифр
                .setDateOfBirth("04", "October", "1990")
                .setSabjects("Maths")
                .setHobbies("Reading")
                .setUploadPicture("icons.png")
                .setCurrentAddress("Russia, Ufa")
                .setStateDropdown()
                .setStateCityWrapper("NCR")
                .setCityDropdown()
                .setStateCityWrapper("Delhi")
                .setSubmit()
                .setModalDialog()
                .setModalTitle("Thanks for submitting the form")
                .checkResult("Student Name", "Alex Dmitr")
                .checkResult("Student Email", "Alex@Dmitr.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "123456789")
                .checkResult("Date of Birth", "04 October,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "icons.png")
                .checkResult("Address", "Russia, Ufa")
                .checkResult("State and City", "NCR Delhi")
                .closeModal();
    }
}