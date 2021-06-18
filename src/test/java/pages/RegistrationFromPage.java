package pages;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFromPage {
    public void typeFirstName(String firstname) {
        $("#firstName").setValue(firstname);
    }

    public void typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void typeEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void chooseGender(String gender) {
        $(byText(gender)).click();
    }

    public void typePhone(String phone) {
        $("#userNumber").setValue(phone);
    }

    public void chooseBirthDayDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).shouldBe(Condition.visible).click();
    }

    public void chooseSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void choseHobby(String hobby) {
        $(byText(hobby)).click();
    }

    public void uploadPicture(String picture) {
        File file = $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
    }

    public void typeCurrentAddress(String address) {
        $("[placeholder=\"Current Address\"]").setValue(address);
    }

    public void setState(String state) {
        $("#state").click();
        $(byText(state)).click();
    }

    public void setCity(String city) {
        $("#city").click();
        $(byText(city)).click();
    }

    public void clickSubmit() {
        $("#submit").click();
    }

}
