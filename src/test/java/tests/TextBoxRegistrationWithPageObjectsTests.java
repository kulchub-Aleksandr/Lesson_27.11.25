package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxRegistrationPage;

import static tests.TestData.*;

public class TextBoxRegistrationWithPageObjectsTests extends TestBase {

    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();

    @Test
    void successfulRegistrationTest() {
        textBoxRegistrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstName + " " +  lastName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .setSubmit()
                .checkOutput("Name:", firstName + " " + lastName)
                .checkOutput("Email:", userEmail)
                .checkOutput("Current Address :", currentAddress)
                .checkOutput("Permananet Address :", permanentAddress);
    }
}