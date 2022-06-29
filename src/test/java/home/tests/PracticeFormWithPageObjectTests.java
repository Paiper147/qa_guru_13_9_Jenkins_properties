package home.tests;

import home.pages.PracticeFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithPageObjectTests extends home.tests.TestBaseWithPageObject {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @Tag("practiceFormWithPageObjectTests")
    void successfulTestPracticeForm() {

        String name = "myName";
        String lastName = "myLastName";
        String email = "myEmail@mail.com";
        String gender = "Female";
        String mobileNumber = "0123456789";
        String birthday = "30 August,1992";
        String dayBirthday = "30";
        String monthBirthday = "August";
        String yearBirthday = "1992";
        String subjects = "Maths";
        String hobbies = "Reading";
        String picture = "1.png";
        String picturePath = "img/1.png";
        String address = "my currentAddress";
        String state = "Haryana";
        String city = "Panipat";
        String stateAndCity = "Haryana Panipat";

        step("Fill registration form", () -> {
            practiceFormPage.openPage()
                    .setFirstName(name)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobileNumber(mobileNumber)
                    .setDateOfBirth(dayBirthday, monthBirthday, yearBirthday)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setPicture(picturePath)
                    .setCurrentAddress(address)
                    .setState(state)
                    .setCity(city)
                    .submitClick();
        });

        step("Check registration form", () -> {
            //Проверка вывода формы подтверждения
            practiceFormPage.checkTitleOfResultPage("Thanks for submitting the form")
                    .checkResult("Student Name", name + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", mobileNumber)
                    .checkResult("Date of Birth", birthday)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", stateAndCity);
        });

        step("Close registration form", () -> {
            //Клик Close
            practiceFormPage.closeClick();
        });

    }
}
