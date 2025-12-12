package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static tests.RandomTestData.*;

public class RegistrationWithRandomDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSabjects(sabjects)
                .setHobbies(hobbies)
                .setUploadPicture(Picture)
                .setCurrentAddress(currentAddress)
                .setScroll()
                .setStateDropdown(state)
                //.setStateCityWrapper(state)
                .setCityDropdown(city)
                //.setStateCityWrapper(city)
                .setSubmit()
                .setModalDialog()
                .setModalTitle(submitFormText)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month+ "," + year)
                .checkResult("Subjects", sabjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", Picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeModal();



    }

    @Test
    void minimalSuccessfulRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                //.setEmail("Alex@Dmitr.com")
                .setGender(gender)
                .setUserNumber(userNumber)
                //.setDateOfBirth("30", "October", "1990")
                //.setSabjects("Maths")
                //.setHobbies("Reading")
                //.setUploadPicture("icons.png")
                //.setCurrentAddress("Russia, Ufa")
                //.setStateDropdown()
                //.setStateCityWrapper("NCR")
                //.setCityDropdown()
                //.setStateCityWrapper("Delhi")
                .setScroll()
                .setSubmit()
                .setModalDialog()
                .setModalTitle(submitFormText)
                .checkResult("Student Name", firstName + " " + lastName)
//                .checkResult("Student Email", "Alex@Dmitr.com")
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
//                .checkResult("Date of Birth", "30 October,1990")
//                .checkResult("Subjects", "Maths")
//                .checkResult("Hobbies", "Reading")
//                .checkResult("Picture", "icons.png")
//                .checkResult("Address", "Russia, Ufa")
//                .checkResult("State and city", "NCR Delhi")
                .closeModal();
    }
    @Test
    void negativeRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(notFullUserNumber)  // не полный набор цифр
                .setDateOfBirth(day, month, year)
                .setSabjects(sabjects)
                .setHobbies(hobbies)
                .setUploadPicture(Picture)
                .setCurrentAddress(currentAddress)
                .setScroll()
                .setStateDropdown(state)
                .setCityDropdown(city)
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
//                .checkResult("State and city", "NCR Delhi")
//                .closeModal();



    }
}