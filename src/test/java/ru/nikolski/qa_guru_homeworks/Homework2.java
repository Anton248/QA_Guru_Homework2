package ru.nikolski.qa_guru_homeworks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//testing all fields, checkboxes and buttons at https://demoqa.com/automation-practice-form
public class Homework2 extends TestBase{
    String zero = ""; //utility string

    @Test
    void homework2() {

        //values for input fields, checkboxes, etc
        String firstName = "Ivan",
                lastName = "Ivanov",
                email = "ivanov@ivanov.com",
                gender = "Male",
                mobileNumber = "1234567890",
                dayOfBirth = "2",
                monthOfBirth = "February",
                yearOfBirth = "2000",
                subject1 = "Chemistry",
                subject2 = "Computer Science",
                hobbies1 = "sports",
                hobbies2 = "reading",
                hobbies3 = "music",
                file = "1.jpg",
                currentAddress = "Москва, ул. Уличная, д.5, кв.111",
                state = "Uttar Pradesh",
                city = "Agra";

        //filling the input fields, clicking the checkboxes, etc
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        //$("#genterWrapper").selectRadio(gender); //doesn't work
        //$("#gender-radio-1").parent().click(); //bad implementation
        $("#genterWrapper").$(By.cssSelector("input[value=\"" + gender + "\"]")).parent().click();
        $("#userNumber").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        if (dayOfBirth.length() == 1) zero = "0";
        $(".react-datepicker__day--0" + zero + dayOfBirth).click();

        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();








    }
}
