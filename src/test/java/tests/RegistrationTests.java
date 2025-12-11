package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Dmitr");
        $("#userEmail").setValue("Alex@Dmitr.com");
        //Gender
        $("#genterWrapper").$(byText("Male")).click();
        //Namber Tell
        $("#userNumber").setValue("8999999999");
        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("October")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("4")).click();
        //Subjects
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("m");
        $(byText("Maths")).click();
        //Hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //Picture
        $("#uploadPicture").uploadFromClasspath("icons.png");
        //Current Address
        $("#currentAddress").setValue("Russia, Ufa");

        $("#submit")
                .scrollIntoView("{block: 'center'}");
        //State and city
        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();
        //Проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).closest("tr").shouldHave(text("Alex Dmitr"));
        $(".table-responsive").$(byText("Student Email")).closest("tr").shouldHave(text("Alex@Dmitr.com"));
        $(".table-responsive").$(byText("Gender")).closest("tr").shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).closest("tr").shouldHave(text("8999999999"));
        $(".table-responsive").$(byText("Date of Birth")).closest("tr").shouldHave(text("04 October,1990"));
        $(".table-responsive").$(byText("Subjects")).closest("tr").shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).closest("tr").shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).closest("tr").shouldHave(text("icons.png"));
        $(".table-responsive").$(byText("Address")).closest("tr").shouldHave(text("Russia, Ufa"));
        $(".table-responsive").$(byText("State and City")).closest("tr").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal")
                .scrollIntoView("{block: 'center'}");

       // $("#closeLargeModal").click();

    }
}
