package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFromPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
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
        step("Открываем Форму регистрации", () -> {
            open("https://demoqa.com/automation-practice-form");
        });

        step("Заполняем Имя", () -> {
            registrationFromPage.typeFirstName(firstName);
        });

        step("Заполняем Фамилию", () -> {
            registrationFromPage.typeLastName(lastName);
        });

        step("Заполняем email", () -> {
            registrationFromPage.typeEmail(email);
        });

        step("Выбираем пол", () -> {
            registrationFromPage.chooseGender(gender);
        });

        step("Заполняем номер телефона", () -> {
            registrationFromPage.typePhone(phone);
        });

        step("Выбираем дату рождения в календаре", () -> {
            registrationFromPage.chooseBirthDayDate(year, month, day);
        });

        step("Выбираем предмет", () -> {
            registrationFromPage.chooseSubject(subject);
        });

        step("Выбираем хобби", () -> {
            registrationFromPage.choseHobby(hobby);
        });

        step("Загружаем изображение", () -> {
            registrationFromPage.uploadPicture(picture);
        });

        step("Заполняем фактический адрес", () -> {
            registrationFromPage.typeCurrentAddress(address);
        });

        step("Выбираем штат", () -> {
            registrationFromPage.setState(state);
        });

        step("Выбираем город", () -> {
            registrationFromPage.setCity(city);
        });

        step("Нажимаем предоставить данные", () -> {
            registrationFromPage.clickSubmit();
        });

        step("Проверяем представленные данные на соответвие заполненым", () -> {
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
        });

    }

}

