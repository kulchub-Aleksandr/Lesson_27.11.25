package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxRegistrationPage;

public class TextBoxRegistrationWithPageObjectsTests extends TestBase {

    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();

    @Test
    void successfulRegistrationTest() {
        textBoxRegistrationPage
                .openPage()
                .removeBanner()
                .setFirstName("Alex Dmitr")
                .setEmail("Alex@Dmitr.com")
                .setCurrentAddress("Russia, Ufa")
                .setPermanentAddress("Another street 1")
                .setSubmit()
                .checkOutput("Name:", "Alex Dmitr")
                .checkOutput("Email:", "Alex@Dmitr.com")
                .checkOutput("Current Address :", "Russia, Ufa")
                .checkOutput("Permananet Address :","Another street 1");
    }
}