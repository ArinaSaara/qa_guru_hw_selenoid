package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    private final SelenideElement firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthOfBirthOption = $(".react-datepicker__month-select"),
            yearOfBirthOption = $(".react-datepicker__year-select"),
            subjectInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            createStudentButton = $("#submit");

    public PracticeForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PracticeForm enterLastName(String userLastName) {
        secondNameInput.setValue(userLastName);
        return this;
    }

    public PracticeForm enterFirstName(String userName) {
        firstNameInput.setValue(userName);
        return this;
    }

    public PracticeForm enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeForm selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PracticeForm selectDateOfBirthday(int month, int year, int day) {
        dateOfBirthInput.click();
        monthOfBirthOption.selectOption(month - 1);
        yearOfBirthOption.selectOption(String.valueOf(year));
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public PracticeForm enterMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    public PracticeForm enterSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeForm enterAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public PracticeForm checkHobby(String hobby) {
        $(withText(hobby)).click();
        return this;
    }

    public PracticeForm uploadImage(String imagePath) {
        uploadPictureButton.uploadFile(new File(imagePath));
        return this;
    }

    public PracticeForm selectStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public void clickOnCreateStudentButton() {
        createStudentButton.shouldBe(enabled).click();
    }
}

