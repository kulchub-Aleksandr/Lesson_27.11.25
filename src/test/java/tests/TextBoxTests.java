package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

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
        $("label[for='gender-radio-1']").click();
        //$("#gender-radio-1 [value='Male']").click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirth-wrapper").click();

        $(".react-datepicker__month-select").click();
        $(byText("October")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1990")).click();
        $(".react-datepicker__week").$("react-datepicker__day react-datepicker__day--004");
        $(byText("4")).click();

        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("m");
        $(byText("Maths")).click();

        $("label[for='hobbies-checkbox-2']").click();

        File uploadFile = $("#uploadPicture").uploadFile(new File("C:/Users/user/Documents/qa guru/27.11.25/icons8-pubg-50.png"));

        $("#currentAddress").setValue("Russia, Ufa");

        $("#submit")
                .scrollIntoView("{block: 'center'}");

        $("#state").click();
        $(byText("NCR")).click();

        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Dmitr"));
       //$("#output #email").shouldHave(text("alex@egorov.com"));
        //$("#output #currentAddress").shouldHave(text("Some street 1"));
        //$("#output #permanentAddress").shouldHave(text("Another street 1"));

        $("#closeLargeModal")
                .scrollIntoView("{block: 'center'}");

        $("#closeLargeModal").click();



    }
}
