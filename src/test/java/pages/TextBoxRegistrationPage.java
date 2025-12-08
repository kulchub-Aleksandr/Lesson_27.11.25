package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxTableOutput;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxRegistrationPage {
    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress" ),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit");
            //check = $("#output #name");



    public TextBoxRegistrationPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxRegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public TextBoxRegistrationPage setFirstName(String value) {
        fullNameInput.setValue(value);
        return this;
    }
    public TextBoxRegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxRegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public TextBoxRegistrationPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxRegistrationPage setSubmit() {
        submit.click();
        return this;
    }

    public TextBoxRegistrationPage checkOutput(String key, String value) {
        TextBoxTableOutput.setOutput(key, value);
        return this;
    }
}