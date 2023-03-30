package ru.nikolski.qa_guru_homeworks;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//testing all fields, checkboxes and buttons at https://demoqa.com/automation-practice-form
public class Homework2 extends TestBase{
    String zero = ""; //is used to add "0" to String

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
                currentAddress = "Москва, ул. Уличная, д.5, кв.111",
                state = "Uttar Pradesh",
                city = "Agra";


        open("/automation-practice-form");

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
        if (dayOfBirth.length() == 1) zero = "0";
        $(".react-datepicker__day--0" + zero + dayOfBirth).click();

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
                Condition.text(firstName + " "),
                Condition.text(" " + lastName),
                Condition.text(email),
                Condition.text(gender),
                Condition.text(mobileNumber),
                Condition.text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                Condition.text(subject1),
                Condition.text(subject2),
                Condition.text(hobbies1),
                Condition.text(hobbies2),
                Condition.text(hobbies3),
                Condition.text(file),
                Condition.text(currentAddress),
                Condition.text(state),
                Condition.text(city));

    }
}
