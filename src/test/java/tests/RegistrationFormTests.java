package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFromPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class RegistrationFormTests {


    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phone = getRandomPhone(),
            year = getRandomYear(),
            month = getRandomMonth(),
            day = getRandomDay(),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            picture = "picture_1.png",
            address = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state);

    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    void fillRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        registrationFromPage.typeFirstName(firstName);
        registrationFromPage.typeLastName(lastName);
        registrationFromPage.typeEmail(email);
        registrationFromPage.chooseGender(gender);
        registrationFromPage.typePhone(phone);
        registrationFromPage.chooseBirthDayDate(year, month, day);
        registrationFromPage.chooseSubject(subject);
        registrationFromPage.choseHobby(hobby);
        registrationFromPage.uploadPicture(picture);
        registrationFromPage.typeCurrentAddress(address);
        registrationFromPage.setState(state);
        registrationFromPage.setCity(city);
        registrationFromPage.clickSubmit();

        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(phone));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }

}

