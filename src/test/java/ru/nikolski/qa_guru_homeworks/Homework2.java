package ru.nikolski.qa_guru_homeworks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//testing all fields, checkboxes and buttons at https://demoqa.com/automation-practice-form
public class Homework2 extends TestBase {
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
                hobbies1 = "Sports",
                hobbies2 = "Reading",
                hobbies3 = "Music",
                file = "1.jpg",
                pathToPictures = "pictures/",
                currentAddress = "Москва, ул. Уличная, д.5, кв.111",
                state = "Uttar Pradesh",
                city = "Agra";


        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //filling the input fields, clicking the checkboxes, etc

        //personal data
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        //$("#genterWrapper").selectRadio(gender); //doesn't work
        //$("#gender-radio-1").parent().click(); //bad implementation
        $("#genterWrapper").$(By.cssSelector("input[value=\"" + gender + "\"]")).parent().click();
        $("#userNumber").setValue(mobileNumber);

        //date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__week").$(byText(dayOfBirth)).click();

        //study subjects
        //$("#subjectsInput").setValue(subject1.substring(0,1));
        //$(".subjects-auto-complete__control css-yk16xz-control").find(byText(subject1)).click(); //doesn't work
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();

        //hobbies
        $("#hobbiesWrapper").$(byText(hobbies1)).parent().click();
        $("#hobbiesWrapper").$(byText(hobbies2)).parent().click();
        $("#hobbiesWrapper").$(byText(hobbies3)).parent().click();

        //file, address, state, city
        $("#uploadPicture").uploadFromClasspath(pathToPictures + file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();

        //submit the form
        $("#submit").click();

        //checking that all fields were filled right
        $(".table-responsive").shouldHave(
                text(firstName + " "),
                text(" " + lastName),
                text(email),
                text(gender),
                text(mobileNumber),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(subject1),
                text(subject2),
                text(hobbies1),
                text(hobbies2),
                text(hobbies3),
                text(file),
                text(currentAddress),
                text(state),
                text(city));

    }
}
