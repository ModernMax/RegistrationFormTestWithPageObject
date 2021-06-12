package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFromPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {


    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastname = faker.name().lastName(),
            email = "modern@max.com",
            gender = utils.RandomUtils.getRandomGender(),
            phone = faker.phoneNumber().cellPhone(),
            year = "1990",
            month = "November",
            day = "08",
            subject = utils.RandomUtils.getRandomSubject(),
            hobby = utils.RandomUtils.getRandomHobby(),
            picture = "picture_1.png",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Panipat";

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
        registrationFromPage.typeLastName(lastname);
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
    }

}
